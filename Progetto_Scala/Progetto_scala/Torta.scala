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
    if (Ingr.quantità*Ingr.calorie>100)return true
    else false 
  }
  
  def calcolaCalorie(quantità: Int): Double = {
    return quantità*(ingredienti.foldLeft(0.0)((x,y)=> if (y.calorie>0) x+(y.calorie*y.quantità) else x));
  }
  
  def calcolaCalorie(): Double = {
    return ingredienti.foldLeft(0.0)((x,y)=> if (y.calorie>0) x+(y.calorie*y.quantità) else x);
  }
  
  // Funzione che calcola la quantità in grammi da assumere
  // data in input le calorie che ne vuoi assumere
  def quantitaPerAvereNcalorie (Ncalorie:Int): Double={
    val quantity=(Ncalorie/this.mediaCalorieCalorici_map())
    return quantity
  }
  
  // Funzione che assicura che si assuma al massimo 500 calorie
  // di torta, nel caso la richiesta fosse <=500 viene accettata
  def calcolaQuantitaDaMangiare(quantità:Int): Double={
    val totCalorie=calcolaCalorie(quantità)
    if (totCalorie>500) return quantitaPerAvereNcalorie(500)
    else return quantità
  }
  
  def calorico(): Boolean = {
    for (x<-ingredienti){
      if (x.quantità*x.calorie>100)return true
    }
    return false;
  }
  
  //funzione con for
  def mediaCalorieCalorici_for():Double={
    var Somma=0.0;
    for (x<-ingredienti){
      if (calorico(x)){
        Somma+=(x.calorie*x.quantità)
      }
    }
    Somma/ingredienti.size
  }
  
  //funzione con foreach
  def mediaCalorieCalorici_foreach(): Double = {
    var Somma=0.0;
    ingredienti.foreach(s=> if(calorico(s)) Somma+=s.calorie*s.quantità )
      
    return Somma/ingredienti.size
  }
  
  //funzione con filter
  def mediaCalorieCalorici_filter(): Double = {
    var Somma = 0.0;
    for (x<- ingredienti.filter(calorico(_))){
      Somma+=(x.calorie*x.quantità);
    }

    return Somma / ingredienti.size
  }
  
  //funzione con fold
  def mediaCalorieCalorici_fold(): Double =ingredienti.foldLeft(0.0)((x,y)=> if (calorico(y)) x+(y.calorie*y.quantità) else x)/ingredienti.size
  
  //funzione con map
  def mediaCalorieCalorici_map(): Double = {
    var Somma=0.0
    for (x <- ingredienti.filter(calorico(_))) {
      Somma += (x.calorie * x.quantità);
    }
    val size=ingredienti.map(calorico(_)).size
    
    return Somma/size
  }
  
  //funzione con HOF
  def mediaCalorieCalorici_std(f: (Ingrediente) => Boolean) : List[Ingrediente]=>Double = {
    def inner(lista: List[Ingrediente]): Double = {
      var Somma = 0.0
      for (x <- ingredienti.filter(f(_))) {
        Somma += (x.calorie * x.quantità);
      }
      val size = ingredienti.map(f(_)).size
      Somma/size
    }
    inner
  }
  
  //funzione con currying
  def mediaCalorieCalorici_curr(f: (Ingrediente) => Boolean)(list:List[Ingrediente])= {
    var Somma = 0.0
    list.foreach(s => if (f(s)) Somma += s.quantità * s.calorie else Somma)
    Somma/list.size

  }
   
}


