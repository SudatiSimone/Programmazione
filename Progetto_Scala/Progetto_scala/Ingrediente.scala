// Torta ha un campo che � una lista di tipo Ingrediente
class Ingrediente(Nome:String,quantity:Int,Calorie:Double) {
  
  val nome=Nome;
  val quantit�=quantity;
  val calorie=Calorie; //calorie al grammo

  def getName(): String = {
    nome
  }
  def getQuantit�(): Int = {
    quantit�
  }
  def getCalorie(): Double = {
    calorie
  }

}