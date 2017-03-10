/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.alg_ex2;

/**
 *
 * @author Joachim Dittman Jepsen
 */
public class Main {

   static long start, end, finalTimeCon;
   static double result;
    static Controller c;

    private static void insertionSort(int size, int runTimes) {
        c = new Controller(size);
      
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.insertionSort();
            end = System.currentTimeMillis();
            finalTimeCon += (end - start);
        }
        result = finalTimeCon/runTimes;
        System.out.println(size+" - result : "+result +" ms");

    }
        private static void selectionSort(int size, int runTimes) {
        c = new Controller(size);
      finalTimeCon = 0;
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.selectionSort();
            end = System.currentTimeMillis();
            finalTimeCon += (end - start);
        }
        
        result = finalTimeCon/runTimes; 
        System.out.println(size+" - result : "+result +" ms");

    }
           private static void mergeSort(int size, int runTimes) {
        c = new Controller(size);
      finalTimeCon = 0;
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.realMergeSort();
            end = System.currentTimeMillis();
            finalTimeCon += (end - start);
        }
        
        result = finalTimeCon/runTimes;
        
        System.out.println(size+" - result : "+result +" ms");

    }

    public static void main(String[] args) {
       
       System.out.println("Insertion sort:");
       insertionSort(1000,200);
       insertionSort(2000,200);
       insertionSort(4000,200);
       insertionSort(8000,200);

       System.out.println("Selection sort:");
       selectionSort(1000,200);
       selectionSort(2000,200);
       selectionSort(4000,200);
       selectionSort(8000,200);
       
       System.out.println("Merge sort:");
       mergeSort(1000,200);
       mergeSort(2000,200);
       mergeSort(4000,200);
       mergeSort(8000,200);
    }
}
