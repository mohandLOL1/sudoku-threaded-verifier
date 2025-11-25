package io;

public class CSVFileHandler { //singleton design pattern
     private static CSVFileHandler instance = null;


     private CSVFileHandler(){
     }

     public static CSVFileHandler getInstance(){

         if(instance == null) {
             instance = new CSVFileHandler();
         }

         return instance;
     }

     public int[][] CSVReader(String filename){
         return null;
     }
}
