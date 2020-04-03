#include "Torta.h"
#include "Alimento.h"
#include <iostream>
using namespace std;

Torta::Torta():Alimento(nome),Dolce(){
	Torta::minForno=0;
	Torta::numUova=0;
}

Torta::Torta(string nome):Alimento(nome),Dolce(nome){
	Torta::minForno=0;
	Torta::numUova=0;
	cout<<"CT ";
}
Torta::Torta(string nome,int minForno,int numUova,int grammiZucchero):Alimento(nome),Dolce(nome){
	Torta::minForno=minForno;
	Torta::numUova=numUova;
	Torta::grammiZucchero=grammiZucchero;
	cout<<"CT ";
}

Torta::~Torta(){

}
//Overriding metodo CalcolaCalorie()
//Le calorie in 1 grammo di zucchero sono 3,87. Nella torta le calcoliamo come fossero 3
int Torta::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di torta- "<<Torta::grammiZucchero*3;
	return Torta::grammiZucchero*3;
}
//Overriding metodo Stampa()
void Torta::stampa(){
	Dolce::stampa();
	cout<<"E'una TORTA."<<endl;
	cout<<"Minuti forno: "<<minForno<<endl;
	cout<<"Numero uova: "<<numUova<<endl;
}
TortaMele::TortaMele():Alimento(){
	TortaMele::setNumeroMele(0);
}

TortaPere::TortaPere():Alimento(){
	TortaPere::setNumeroPere(0);
}

TortaMele::TortaMele(string nome):Alimento(nome),Torta(nome){
	TortaMele::setNumeroMele(0);
}

TortaPere::TortaPere(string nome):Alimento(nome),Torta(nome){
	TortaPere::setNumeroPere(0);
}
TortaMele::TortaMele(string nome, int numMele,int minForno, int numUova,int grammiZucchero):Alimento(nome),Torta(nome){
	TortaMele::setNumeroMele(numMele);
	TortaMele::grammiZucchero=grammiZucchero;
	TortaMele::minForno=minForno;
	TortaMele::numUova=numUova;
	cout<<"CTM ";
}

TortaPere::TortaPere(string nome, int numPere,int minForno, int numUova,int grammiZucchero):Alimento(nome),Torta(nome){
	TortaPere::setNumeroPere(numPere);
	TortaPere::grammiZucchero=grammiZucchero;
	TortaPere::minForno=minForno;
	TortaPere::numUova=numUova;
	cout<<"CTP ";
}

//Overriding metodo CalcolaCalorie()
//Le calorie in 1 grammo di zucchero sono 3,87. Nella torta le calcoliamo come fossero 3 e 5
int TortaMele::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di tortaMele- "<<TortaMele::grammiZucchero*3;
	return TortaMele::grammiZucchero*3;
}

int TortaPere::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di tortaPere- "<<TortaPere::grammiZucchero*5;
	return TortaPere::grammiZucchero*5;
}

//Overriding metodo stampa()
void TortaMele::stampa(){
	Torta::stampa();
	cout<<"E' una TORTA DI MELE."<<endl;
	cout<<"Numero mele: "<<getNumeroMele()<<endl;
}

void TortaPere::stampa(){
	Torta::stampa();
	cout<<"E' una TORTA DI PERE."<<endl;
	cout<<"Numero pere: "<<getNumeroPere()<<endl;
}

//Metodi getter and setter
void TortaMele::setNumeroMele(int quantity){
	TortaMele::numMele=quantity;
}

void TortaPere::setNumeroPere(int quantity){
	TortaPere::numPere=quantity;
}

int TortaMele::getNumeroMele(){
	return TortaMele::numMele;
}

int TortaPere::getNumeroPere(){
	return TortaPere::numPere;
}


