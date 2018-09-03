
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Digit extends ProductionRule {

    public Digit() {
        super();
        this.createRules();
    }

    @Override
    protected void createRules() {
        LinkedList<String> listPR0 = new LinkedList<>();
        listPR0.add("0");
        productionRule.add(listPR0);

        LinkedList<String> listPR1 = new LinkedList<>();
        listPR1.add("1");
        productionRule.add(listPR1);

        LinkedList<String> listPR2 = new LinkedList<>();
        listPR2.add("2");
        productionRule.add(listPR2);

        LinkedList<String> listPR3 = new LinkedList<>();
        listPR3.add("3");
        productionRule.add(listPR3);

        LinkedList<String> listPR4 = new LinkedList<>();
        listPR4.add("4");
        productionRule.add(listPR4);

        LinkedList<String> listPR5 = new LinkedList<>();
        listPR5.add("5");
        productionRule.add(listPR5);

        LinkedList<String> listPR6 = new LinkedList<>();
        listPR6.add("6");
        productionRule.add(listPR6);

        LinkedList<String> listPR7 = new LinkedList<>();
        listPR7.add("7");
        productionRule.add(listPR7);

        LinkedList<String> listPR8 = new LinkedList<>();
        listPR8.add("8");
        productionRule.add(listPR8);

        LinkedList<String> listPR9 = new LinkedList<>();
        listPR9.add("9");
        productionRule.add(listPR9);
    }
}
