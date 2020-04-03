/*
 ==========================================================================================
 Name        : ProgettoScala
 Author      : Simone Sudati
 Description : L’ambito è culinario e in particolare quello dei dolci. L’obbiettivo è 
 							 calcolare le calorie nei dolci (che possono essere torte o biscotti) per
 							 capire in quale quantità possono essere mangiati per rimanere al di sotto
 							 di una determinata soglia di calorie assunte.
 ==========================================================================================
 */

trait Dietetico {
  
  // Funzione che indica se un alimento è calorico o meno
  // ovvero se supera una determinata soglia di calorie prestabilita
  def calorico(): Boolean
  
  // Funzione che calcola le calorie totali presenti in un alimento
  // Input: quantità in grammi di un alimento
  def calcolaCalorie(quantità: Int): Double 
  
  // Funzione che calcola quanta quantità in grammi 
  // posso assumere per non sforare le calorie massime assumibili
  // Input: quantità--> quantità in grammi di alimento che VORREI assumere
  def calcolaQuantitaDaMangiare(quantità:Int): Double
  
  // Funzione che calcola quanti grammi posso assumere 
  // Input: Ncalorie--> quantità di calorie desiderate
  def quantitaPerAvereNcalorie (Ncalorie:Int): Double
  
}