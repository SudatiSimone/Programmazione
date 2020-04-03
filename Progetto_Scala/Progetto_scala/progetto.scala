/*
 ==========================================================================================
 Name        : ProgettoScala
 Author      : Simone Sudati
 Description : L�ambito � culinario e in particolare quello dei dolci. L�obbiettivo � 
 							 calcolare le calorie nei dolci (che possono essere torte o biscotti) per
 							 capire in quale quantit� possono essere mangiati per rimanere al di sotto
 							 di una determinata soglia di calorie assunte.
 ==========================================================================================
 */

object progetto {
  
  
  def main(args: Array[String]) {
    
    val farina= new Ingrediente("Farina",10,13.5)  //nome, quantit�, calorie al grammo
    val zucchero= new Ingrediente("Zucchero",7,8.2)
    val uova= new Ingrediente("Uova",9,12.1)
    
    val ingredienti=List(farina,zucchero,uova)
    
    val crostata= new Torta("Crostata",8,ingredienti)
    println("---------------------------------------------");
    println("Torta: "+crostata.getName+"\nCodice: "+crostata.getCodice)
    println("Ingredienti :"+crostata.getIngredienti)
    println
    
    // farina e uova sono calorici 
    println("Farina calorico? "+crostata.calorico(farina)) 
    println("Zucchero calorico? "+crostata.calorico(zucchero))
    println("Uova calorico? "+crostata.calorico(uova))
    println("\nQuantit� che posso mangiarne: "+crostata.calcolaQuantitaDaMangiare(1) +" grammi")
    println("Quantit� che posso mangiarne: "+crostata.calcolaQuantitaDaMangiare(30)+" grammi")
    println("Quantit� che posso mangiarne: "+crostata.calcolaQuantitaDaMangiare(70)+" grammi")
    
    
    //Siccome la torta � fatta da pi� ingredienti prendo solamente gli ingredienti calorici
    //e calcolo le calorie medie che contengono
    println
    println("Media calorici -for-: "+crostata.mediaCalorieCalorici_for)
    println("Media calorici -foreach-: "+crostata.mediaCalorieCalorici_foreach)
    println("Media calorici -filter-: "+crostata.mediaCalorieCalorici_filter)
    println("Media calorici -fold-: "+crostata.mediaCalorieCalorici_fold)
    println("Media calorici -map-: "+crostata.mediaCalorieCalorici_map)
    println("Media calorici -std-: "+crostata.mediaCalorieCalorici_std(crostata.calorico)(ingredienti))
    println("Media calorici -curr-: "+crostata.mediaCalorieCalorici_curr(crostata.calorico)(ingredienti))
    
    println("---------------------------------------------");
    val biscotto1= new Biscotti("Le Gocciole",5,6,"gocciola"); //nome, codice, calorie, forma
    println ("Biscotto: "+biscotto1.getName())
    println("Calorico? "+biscotto1.calorico())
    println("Calorie: "+biscotto1.calcolaCalorie(10))
    println("Quantit� che posso mangiarne: "+biscotto1.calcolaQuantitaDaMangiare(30)+" grammi")
    println("Quantit� che posso mangiarne: "+biscotto1.calcolaQuantitaDaMangiare(60)+" grammi")
    println("Quantit� che posso mangiarne: "+biscotto1.calcolaQuantitaDaMangiare(80)+" grammi")
    println("---------------------------------------------");
 
  }
  
}


