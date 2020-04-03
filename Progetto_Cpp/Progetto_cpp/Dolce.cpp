#include "Dolce.h"
#include <iostream>
using namespace std;

//set del membro statico della classe
int Dolce::ordine=0;

//Metodi getter and setter
void Dolce::setCodRicetta(){
	Dolce::codRicetta=++ordine;
}

int Dolce::getCodRicetta(){
	return Dolce::codRicetta;
}

//Costruttore vuoto
Dolce::Dolce():Dolce("-Sconosciuto-"){
	//Delegating constructor
}

Dolce::Dolce(string nome):Alimento(nome){
	Dolce::freddo=true;
	Dolce::grammiZucchero=0;
	Dolce::setCodRicetta();
	cout<<"CD ";
}


Dolce::Dolce(string nome,int grammiZucchero,bool freddo):Alimento(nome){
	Dolce::setCodRicetta();
	Dolce::grammiZucchero=grammiZucchero;
	Dolce::freddo=freddo;
	cout<<"CD ";
}

void Dolce::stampa(){
	Alimento::stampa();
	cout<<" è un DOLCE."<<endl;
	cout<<"Codice ricetta: "<<Dolce::codRicetta<<endl;
	cout<<"Freddo: "<<Dolce::freddo<<endl;
	cout<<"Grammi zucchero: "<<Dolce::grammiZucchero<<endl;
}

//In 1 grammo di zucchero ci sono 3,87 calorie. Per semplicità useremo 4
int Dolce::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di dolce- "<<Dolce::grammiZucchero*4;
	return Dolce::grammiZucchero*4;
}




