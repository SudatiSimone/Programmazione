#include "Biscotti.h"
#include "Snack.h"
#include "Dolce.h"
#include <iostream>
using namespace std;


Biscotti::~Biscotti(){

}

Biscotti::Biscotti():Dolce(),Snack(){

}

Biscotti::Biscotti(string nome):Snack(nome){
}

Biscotti::Biscotti(string nome,string forma,enum Orario time,int grammiZucchero, bool freddo):Alimento(nome),Dolce(nome,grammiZucchero,freddo),Snack(nome,time){
	Biscotti::forma=forma;
	cout<<"CB ";
}

void Biscotti::stampa(){
	Dolce::stampa();
	Snack::stampa();
	cout<<"BISCOTTO di forma "<<Biscotti::forma<<endl;
}

int Biscotti::CalcolaCalorie(){
	cout<<"Calcola calorie: -metodo di biscotti- "<<Biscotti::grammiZucchero*2;
	return Biscotti::grammiZucchero*2;
}
