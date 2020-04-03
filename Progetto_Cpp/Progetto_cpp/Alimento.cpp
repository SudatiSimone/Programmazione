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

#include "Alimento.h"
#include <iostream>
using namespace std;

//Costruttore con Inizialization list
Alimento::Alimento(string nome):nome(nome){

	cout<<"CA ";
}

//Costruttore vuoto
Alimento::Alimento(){
	cout<<"CA ";
}

//Distruttore
Alimento::~Alimento(){

}

//Metodo virtual da fare overriding nelle sottoclassi
int Alimento::CalcolaCalorie(){
	return 0;
}

//Metodo virtual da fare overriding nelle sottoclassi
void Alimento::stampa(){
	cout<<endl<<this->nome;
}

