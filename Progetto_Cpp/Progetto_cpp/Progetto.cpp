#include <iostream>
#include "Alimento.h"
#include "Dolce.h"
#include "Torta.h"
#include "Snack.h"
#include "Biscotti.h"

using namespace std;

int main() {

	// Notazione costruttori:
	// CA= costruttore Alimento
	// CD= costruttore Dolce
	// CT= costruttore Torta
	// CTM= costruttore TortaMele
	// CTP= costruttore TortaPere
	// CS= costruttore Snack
	// CB= costruttore Biscotti

	Dolce dolce2= Dolce("Strudel",13,true);
	dolce2.stampa();
	dolce2.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;

	Torta torta2= Torta("Crostata",20,3,2);
	torta2.stampa();
	torta2.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;

	TortaMele tortaMele1= TortaMele("Crostata mele",3,30,5,2);
	tortaMele1.stampa();
	tortaMele1.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;

	TortaPere tortaPere1= TortaPere("Crostata pere",5,28,7,2);
	tortaPere1.stampa();
	tortaPere1.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;

	Snack snack1= Snack("Ovetto Kinder",Snack::merenda);
	snack1.stampa();
	snack1.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;

	Biscotti biscotto1= Biscotti("Le Gocciole", "goccia",Snack::pastoMezzanotte,12,true);
	biscotto1.stampa();
	biscotto1.CalcolaCalorie();
	cout<<endl<<"----------------------------------"<<endl;



	//esempio chiamata esplicita distruttore
	//dolce2.~Dolce();
	//in c++ il distruttore viene chiamato implicitamente.
	//alimento ha distruttore virtual quindi vengono richiamati
	//automaticamente tutti i costruttori delle sottoclassi
	
	return 0;
}
