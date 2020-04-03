class Torta(nome:String,codice:Int,Ingredienti:List[Ingrediente])extends Dolce{  
  
  val name: String=nome
  val codRicetta: Int=codice
  val ingredienti: List[Ingrediente]=Ingredienti
  
  def getName(): String={
    name
  }

  def getIngredienti(): String = {
    var stringa="";
    for (x<- ingredienti){
      stringa+=x.getName()+" "
    }
    stringa
  }
  
  def getcodRicetta():Int={
    codRicetta
  }
  
  def getCodice(): Int = {
    codRicetta
  }
  
  def calorico(Ingr:Ingrediente):Boolean={
    if (Ingr.quantit�*Ingr.calorie>100)return true
    else false 
  }
  
  def calcolaCalorie(quantit�: Int): Double = {
    return quantit�*(ingredienti.foldLeft(0.0)((x,y)=> if (y.calorie>0) x+(y.calorie*y.quantit�) else x));
  }
  
  def calcolaCalorie(): Double = {
    return ingredienti.foldLeft(0.0)((x,y)=> if (y.calorie>0) x+(y.calorie*y.quantit�) else x);
  }
  
  // Funzione che calcola la quantit� in grammi da assumere
  // data in input le calorie che ne vuoi assumere
  def quantitaPerAvereNcalorie (Ncalorie:Int): Double={
    val quantity=(Ncalorie/this.mediaCalorieCalorici_map())
    return quantity
  }
  
  // Funzione che assicura che si assuma al massimo 500 calorie
  // di torta, nel caso la richiesta fosse <=500 viene accettata
  def calcolaQuantitaDaMangiare(quantit�:Int): Double={
    val totCalorie=calcolaCalorie(quantit�)
    if (totCalorie>500) return quantitaPerAvereNcalorie(500)
    else return quantit�
  }
  
  def calorico(): Boolean = {
    for (x<-ingredienti){
      if (x.quantit�*x.calorie>100)return true
    }
    return false;
  }
  
  //funzione con for
  def mediaCalorieCalorici_for():Double={
    var Somma=0.0;
    for (x<-ingredienti){
      if (calorico(x)){
        Somma+=(x.calorie*x.quantit�)
      }
    }
    Somma/ingredienti.size
  }
  
  //funzione con foreach
  def mediaCalorieCalorici_foreach(): Double = {
    var Somma=0.0;
    ingredienti.foreach(s=> if(calorico(s)) Somma+=s.calorie*s.quantit� )
      
    return Somma/ingredienti.size
  }
  
  //funzione con filter
  def mediaCalorieCalorici_filter(): Double = {
    var Somma = 0.0;
    for (x<- ingredienti.filter(calorico(_))){
      Somma+=(x.calorie*x.quantit�);
    }

    return Somma / ingredienti.size
  }
  
  //funzione con fold
  def mediaCalorieCalorici_fold(): Double =ingredienti.foldLeft(0.0)((x,y)=> if (calorico(y)) x+(y.calorie*y.quantit�) else x)/ingredienti.size
  
  //funzione con map
  def mediaCalorieCalorici_map(): Double = {
    var Somma=0.0
    for (x <- ingredienti.filter(calorico(_))) {
      Somma += (x.calorie * x.quantit�);
    }
    val size=ingredienti.map(calorico(_)).size
    
    return Somma/size
  }
  
  //funzione con HOF
  def mediaCalorieCalorici_std(f: (Ingrediente) => Boolean) : List[Ingrediente]=>Double = {
    def inner(lista: List[Ingrediente]): Double = {
      var Somma = 0.0
      for (x <- ingredienti.filter(f(_))) {
        Somma += (x.calorie * x.quantit�);
      }
      val size = ingredienti.map(f(_)).size
      Somma/size
    }
    inner
  }
  
  //funzione con currying
  def mediaCalorieCalorici_curr(f: (Ingrediente) => Boolean)(list:List[Ingrediente])= {
    var Somma = 0.0
    list.foreach(s => if (f(s)) Somma += s.quantit� * s.calorie else Somma)
    Somma/list.size

  }
   
}


