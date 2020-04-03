#include "Dolce.h"
#include "Snack.h"

#ifndef BISCOTTI_H_
#define BISCOTTI_H_

class Biscotti: public Dolce,public Snack{
public:
	string forma;
	Biscotti();
	Biscotti(string nome);
	Biscotti(string nome,string forma,enum Orario time, int grammiZucchero,bool freddo);
	~Biscotti();
	void stampa();
	int CalcolaCalorie();
};


#endif /* BISCOTTI_H_ */
