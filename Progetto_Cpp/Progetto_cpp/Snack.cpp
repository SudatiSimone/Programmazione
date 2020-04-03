#include "Snack.h"
#include "Alimento.h"
#include <iostream>
using namespace std;


Snack::Snack(string nome):Alimento(nome){

}

Snack::Snack():Alimento("Sconosciuto"){

}

Snack::Snack(string nome, enum Snack::Orario time):Alimento(nome){
	cout<<"CS ";
	switch (time) {
	case colazione:	Snack::sceltaOrario="colazione";
		break;
	case merenda: Snack::sceltaOrario="merenda";
		break;
	case pastoMezzanotte:Snack::sceltaOrario="pastoMezzanotte";
		break;
	}
}

int Snack::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di Snack- "<<2;
	return 2;
}

void Snack::stampa(){
	Alimento::stampa();
	cout<<" è un SNACK.";
	cout<<endl<<"Periodo giornata: "<<Snack::sceltaOrario<<endl;
}
