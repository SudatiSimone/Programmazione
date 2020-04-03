/*
 ==========================================================================================
 Name        : ProgettoAsmeta
 Author      : Simone Sudati
 Description : Si vuole modellare la gestione dei referti medici online
 			   per i pazienti di un ospedale. Il cliente potrà accedere tramite le proprie
 			   credenziali inserendo prima il proprio ID Utente e in seguito la password.
 			   E procedere a scaricare come pdf il proprio referto.
 ==========================================================================================
 */

asm Referto_Medico_Online

import StandardLibrary

signature:
	domain UserIDList subsetof Integer
	domain Referti subsetof Integer
	domain Semafori subsetof Integer
	enum domain State = {START | INSERIREID | CHECKID | INSERIREPWD | CHECKPWD | CHOOSESERVICE| INSERIRERFT | CHECKRFT |CHECKNOROBOT }
	enum domain Service = {REFERTI | CHANGEPWS | EXIT}
	dynamic controlled noRobot: Referti -> Integer
	dynamic controlled currentState : State
	dynamic controlled messaggio : String
	dynamic controlled currentUserID : Integer
	dynamic controlled currentPwd : String
	dynamic controlled currentRFT : Integer
	dynamic monitored inputString : String
	dynamic monitored inputInteger : Integer
	dynamic monitored selectedService: Service
	static isValidID: Integer -> Boolean
	static isValidPwd: String -> Boolean
	static isValidRFT: Integer -> Boolean
	static isValidNumSemafori: Integer->Boolean


definitions:
	// User ID registrati nel sistema
	domain UserIDList = { 1045936 , 123423 , 4562456 , 5644665}
	// Referti presenti nel sistema
	domain Referti = { 1000 , 1500 , 2006 , 2020 , 1818}
	// Numero di semafori presenti nell'immagine (per confermare di non essere un robot)
	domain Semafori= {3}


	function isValidID($id in Integer) =
		if(exist $u in UserIDList with $u = $id ) then
			true
		else
			false
		endif

	function isValidPwd($pwd in String) =
		if (($pwd ="miao1"and currentUserID=1045936) or ($pwd ="miao2"and currentUserID=123423) or ($pwd ="miao3"and currentUserID=4562456) or ($pwd ="miao4"and currentUserID=5644665) ) then
			true
		else
			false
		endif


	function isValidRFT($rft in Integer) =
		if(exist $r in Referti with $r = $rft ) then
			true
		else
			false
		endif

	function isValidNumSemafori($sem in Integer) =
		if(exist $s in Semafori with $s = $sem ) then
			true
		else
			false
		endif


	macro rule r_insertID =
		if(currentState = INSERIREID) then
			par
				currentUserID := inputInteger
				currentState := CHECKID
			endpar
		endif

	macro rule r_checkID =
		if(currentState = CHECKID) then
				if(isValidID(currentUserID)) then
					par
						currentState := INSERIREPWD
						messaggio := "Inserire la Password"
					endpar
				else
					par
						currentState := START
						messaggio := "ID Utente inesistente!"
					endpar
				endif
		endif

	macro rule r_insertPWD =
		if(currentState = INSERIREPWD) then
			par
				currentPwd := inputString
				currentState := CHECKPWD
			endpar
		endif

	macro rule r_checkPWD =
		if(currentState = CHECKPWD) then
			if(isValidPwd(currentPwd)) then
				par
					currentState := CHOOSESERVICE
					messaggio := "Di che servizio vuoi usufruire? REFERTI o CHANGEPWS o EXIT"
				endpar
			else
				par
					currentState := START
					messaggio := "Password errata!"
				endpar
			endif
		endif


	macro rule r_chooseService =
		if(currentState=CHOOSESERVICE) then
			par
				if(selectedService=REFERTI) then
					par
						currentState := INSERIRERFT
						messaggio := "Inserisci codice del referto"
					endpar
				endif

				if(selectedService=EXIT) then
					par
						currentState := START
						messaggio := "Uscita dal sistema!"
					endpar
				endif
				if(selectedService=CHANGEPWS) then
					par
						//TODO: per implementazioni future!
						currentState:= START
						messaggio := "Uscita dal sistema!"
					endpar
				endif
			endpar
		endif

	macro rule r_insertRFT =
		if(currentState = INSERIRERFT) then
			par
				currentRFT := inputInteger
				currentState := CHECKRFT
			endpar
		endif

	macro rule r_checkRFT =
		if(currentState = CHECKRFT) then
				if(isValidRFT(currentRFT)) then
					par
						currentState := CHECKNOROBOT
						messaggio := "Quanti semafori ci sono nell'immagine?"
					endpar
				else
					par
						currentState := INSERIRERFT
						messaggio := "Referto inesistente!"
					endpar
				endif
		endif

	macro rule r_checkNOROBOT =
		if(currentState = CHECKNOROBOT) then
			if( isValidNumSemafori(inputInteger)) then
				par
					messaggio :=" Eccoti il pdf del referto :) "
					currentState := START
				endpar
			else
				par
					messaggio :=" Reinserisci il codice del referto.. puoi essere un robot! :( "
					currentState := INSERIRERFT
				endpar
			endif
		endif


	main rule r_Main =
		if(currentState = START) then
			par
				currentState := INSERIREID
				messaggio := "Inserire ID Utente"
			endpar
		else
			par
				r_insertID[]
				r_checkID[]
				r_insertPWD[]
				r_checkPWD[]
				r_chooseService[]
				r_insertRFT[]
				r_checkRFT[]
				r_checkNOROBOT[]
			endpar
		endif


default init s0:
	function currentState = START






