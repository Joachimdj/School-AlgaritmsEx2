/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.alg_ex2; 
import java.util.Random;

/**
 *
 * @author Joachim Dittman Jepsen
 */

 
public class SortController {
    private int maxInt;
    private int size;
    private int[] list;
    Random ran;
    private int[] helperArrayArray;
    
    public Controller(int size){
         this.maxInt = 1000;
         this.size = size;
         this.list = new int[size];
         this.ran = new Random();
          
    }
    
    public void addRandomData() {
        for (int i = 0; i < list.length; i++) {
            list[i] = ran.nextInt(maxInt);
        }
    }
    
    void insertionSort() {
        int temp;

        for (int i = 1; i < size; i++) {
            temp = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > temp; j--)
                list[j + 1] = list[j];
            list[j + 1] = temp;
        }
    }

    void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++)
                if (list[j] < list[index])
                    index = j;

            int smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }
    }

    void realMergeSort() {
        this.helperArrayArray = new int[size];
        mergesort(0, size - 1);
    }

    void mergesort(int low, int high) { 
        if (low < high) { 
            int middle = low + (high - low) / 2; 
            mergesort(low, middle); 
            mergesort(middle + 1, high); 
            merge(low, middle, high);
        }
    }

    void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helperArray[i] = list[i];
        } 
        int i = low;
        int j = middle + 1;
        int k = low; 
        while (i <= middle && j <= high) {
            if (helperArray[i] <= helperArray[j]) {
                list[k] = helperArray[i];
                i++;
            } else {
                list[k] = helperArray[j];
                j++;
            }
            k++;
        } 
        while (i <= middle) {
            list[k] = helperArray[i];
            k++;
            i++;
        } 
    } 
}
