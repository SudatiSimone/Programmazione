#include "Dolce.h"
#ifndef TORTA_H_
#define TORTA_H_

class Torta: public Dolce{
public:
	int minForno;
	int numUova;
	Torta();
	Torta(string nome);
	~Torta();
	Torta(string nome,int minForno,int numUova,int grammiZucchero);//:minutiForno(minForno),numeroUova(numUova),colore(color){}cout<<"inizializer list";;
	void stampa();
	int CalcolaCalorie();
};


class TortaPere: public Torta{
private:
	int numPere;
public:
	TortaPere();
	TortaPere(string nome);
	TortaPere(string nome,int numPere,int minForno, int numUova,int grammiZucchero);
	~TortaPere(){};
	int getNumeroPere();
	void setNumeroPere(int quantity);
	void stampa();
	int CalcolaCalorie();
};

class TortaMele: public Torta{
private:
	int numMele;
public:
	TortaMele();
	TortaMele(string nome);
	TortaMele(string nome,int numMele, int minForno, int numUova,int grammiZucchero);
	~TortaMele(){};
	int getNumeroMele();
	void setNumeroMele(int quantity);
	void stampa();
	int CalcolaCalorie();
};

#endif /* TORTA_H_ */
