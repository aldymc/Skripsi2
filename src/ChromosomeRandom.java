
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class ChromosomeRandom {

    int size;
    ArrayList<Integer> chromosome;

    public ChromosomeRandom(int size) {
        this.size = size;
        this.chromosome = new ArrayList();
        Random randomNumber = new Random();
        for (int i = 0; i < size; i++) {
            addNumber(randomNumber.nextInt(256));
        }
    }

    public void addNumber(int i) {
        chromosome.add(i);
    }

    public void printArray() {
        for (int i = 0; i < chromosome.size(); i++) {
            System.out.println(chromosome.get(i));
        }
    }

    public int[] getArray() {
        int[] array = new int[chromosome.size()];
        for (int i = 0; i < chromosome.size(); i++) {
            array[i] = chromosome.get(i);
        }
        return array;
    }

}
