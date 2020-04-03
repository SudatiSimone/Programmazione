/*
 ==========================================================================================
 Name        : ProgettoCpp
 Author      : Simone Sudati
 Description : Il programma si occupa della gestione dei dolci all’interno di un ricettario.
			   Ogni dolce è ordinato e identificato da un codice identificativo.Il programma
			   ha l’obiettivo di creare un output ordinato a forma di ricettario in cui ogni
			   dolce appena inserito contenga tutti i propri parametri che lo caratterizzano.
 ==========================================================================================
 */

#include <string>
using namespace std;

#ifndef ALIMENTO_H_
#define ALIMENTO_H_

class Alimento {
public:
	string nome;
	Alimento(string nome);
	Alimento();
	virtual ~Alimento();
	virtual void stampa();
	virtual int CalcolaCalorie()=0;
};


#endif /* ALIMENTO_H_ */
