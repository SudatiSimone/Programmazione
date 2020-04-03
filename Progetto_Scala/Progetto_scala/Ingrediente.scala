// Torta ha un campo che è una lista di tipo Ingrediente
class Ingrediente(Nome:String,quantity:Int,Calorie:Double) {
  
  val nome=Nome;
  val quantità=quantity;
  val calorie=Calorie; //calorie al grammo

  def getName(): String = {
    nome
  }
  def getQuantità(): Int = {
    quantità
  }
  def getCalorie(): Double = {
    calorie
  }

}