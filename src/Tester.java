
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Tester {

    public static void main(String[] args) {
        //ChromosomeRandom cr = new ChromosomeRandom(10);
        //int[] array = cr.getArray();
        int[] array = {212, 8, 0, 69, 40, 168, 39, 57, 101, 139};
        Chromosome c = new Chromosome(array);
        Process p = new Process(c);
        Derivative d = new Derivative(p.getEquation());
    }
}
//{212, 8, 0, 69, 40, 168, 39, 57, 101, 139}
//{92, 14, 5, 20, 249, 33, 73, 39, 2, 167}
//{92, 14, 5, 20, 24, 33, 73, 39, 2, 167}
//{14, 2, 13, 23, 3, 95, 7, 4, 95, 8}
//{21, 11, 94, 13, 3, 95, 7, 4, 95, 2}
//{21, 11, 94, 7, 4, 95, 13, 3, 95, 2}
//{140, 83, 13, 242, 43, 9, 32, 175, 65, 44}
//

//buat cari turunan dalam pakai rekursif?
//jika polinom biasa, langsung berhenti
//jika fungsi sin cos sampai fungsi dalam habis 
//bikin variabel x aja