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

trait Dietetico {
  
  // Funzione che indica se un alimento � calorico o meno
  // ovvero se supera una determinata soglia di calorie prestabilita
  def calorico(): Boolean
  
  // Funzione che calcola le calorie totali presenti in un alimento
  // Input: quantit� in grammi di un alimento
  def calcolaCalorie(quantit�: Int): Double 
  
  // Funzione che calcola quanta quantit� in grammi 
  // posso assumere per non sforare le calorie massime assumibili
  // Input: quantit�--> quantit� in grammi di alimento che VORREI assumere
  def calcolaQuantitaDaMangiare(quantit�:Int): Double
  
  // Funzione che calcola quanti grammi posso assumere 
  // Input: Ncalorie--> quantit� di calorie desiderate
  def quantitaPerAvereNcalorie (Ncalorie:Int): Double
  
}