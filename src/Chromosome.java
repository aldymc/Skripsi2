
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Chromosome {

    int[] chromosomeArray;
    ArrayList<Integer> chromosome = new ArrayList();

    public Chromosome(int[] array) {
        this.chromosomeArray = array;
    }

    public void addNumber(int i) {
        chromosome.add(i);
    }

    public int[] getArray() {
        return chromosomeArray;
    }

    public void printArray() {
        for (int i = 0; i < chromosomeArray.length; i++) {
            System.out.println(chromosomeArray[i]);
        }
    }

}
