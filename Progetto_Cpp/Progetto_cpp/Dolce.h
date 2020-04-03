#include "Alimento.h"
#ifndef DOLCE_H_
#define DOLCE_H_

class Dolce: public virtual Alimento{
private:
	int codRicetta;
	static int ordine;
public:
	int grammiZucchero;
	bool freddo; //se dolce freddo=true=1 o se dolce caldo=false=0
	Dolce();
	Dolce(string nome);
	Dolce(string nome,int grammiZucchero,bool freddo=false);
	//In alternativa al delegating constructor si usa default inizialization
	~ Dolce(){};
	void stampa();
	int getCodRicetta();
	void setCodRicetta();
	int CalcolaCalorie();
};

#endif /* DOLCE_H_ */
