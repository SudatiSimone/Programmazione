#include "Alimento.h"
#ifndef SNACK_H_
#define SNACK_H_

class Snack: private virtual Alimento{
public:
	//Enumerativo
	enum Orario { colazione=0, merenda=1, pastoMezzanotte=2 };
	string sceltaOrario;
	Snack();
	Snack(string nome);
	Snack(string nome,enum Orario time);
	~Snack(){};
	void stampa();
	int CalcolaCalorie();
};


#endif /* SNACK_H_ */
