//
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
public class Func extends ProductionRule {

    public Func() {
        super();
        this.createRules();
    }

    @Override
    protected void createRules() {
        LinkedList<String> listPR0 = new LinkedList<>();
        listPR0.add("sin");
        productionRule.add(listPR0);

        LinkedList<String> listPR1 = new LinkedList<>();
        listPR1.add("cos");
        productionRule.add(listPR1);

        LinkedList<String> listPR2 = new LinkedList<>();
        listPR2.add("exp");
        productionRule.add(listPR2);

        LinkedList<String> listPR3 = new LinkedList<>();
        listPR3.add("log");
        productionRule.add(listPR3);
    }
}
