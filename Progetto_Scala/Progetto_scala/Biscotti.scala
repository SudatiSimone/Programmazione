class Biscotti(nome:String,codice:Int,Calorie:Int,Forma:String) extends Dolce{
  val name: String=nome
  val codRicetta: Int=codice
  val calorie: Int=Calorie
  val forma:String=Forma
  
  def getName(): String={
    name
  }
  
  def getCalorie(): Int={
    calorie
  }
  
  def getcodRicetta(): Int={
    codRicetta
  }
  
  def getforma(): String={
    forma
  }
  
  def calorico(): Boolean={
    if (calorie>100) return true
    else false
  }
  
  def calcolaCalorie(quantità: Int): Double ={
    return (quantità*calorie +1)
  }
  
   // Funzione che calcola la quantità in grammi da assumere
  // data in input le calorie che ne vuoi assumere
  def quantitaPerAvereNcalorie (Ncalorie:Int): Double={
    val quantity=(Ncalorie/this.calorie)
    return quantity
  }
  
  // Funzione che assicura che si assuma al massimo 200 calorie
  // di biscotti, nel caso la richiesta fosse <=200 viene accettata
  def calcolaQuantitaDaMangiare(quantità:Int): Double={
    val totCalorie=calcolaCalorie(quantità)
    if (totCalorie>200) return quantitaPerAvereNcalorie(200)
    else return quantità
  }
}