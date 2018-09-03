
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
public class Expr extends ProductionRule {

    public Expr() {
        super();
        createRules();
    }

    @Override
    protected void createRules() {
        LinkedList<String> listPR0 = new LinkedList<>();
        listPR0.add("expr");
        listPR0.add("op");
        listPR0.add("expr");
        productionRule.add(listPR0);

        LinkedList<String> listPR1 = new LinkedList<>();
        listPR1.add("(");
        listPR1.add("expr");
        listPR1.add(")");
        productionRule.add(listPR1);

        LinkedList<String> listPR2 = new LinkedList<>();
        Func func1 = new Func();
        listPR2.add("func");
        listPR2.add("(");
        listPR2.add("expr");
        listPR2.add(")");
        productionRule.add(listPR2);

        LinkedList<String> listPR3 = new LinkedList<>();
        listPR3.add("digit");
        productionRule.add(listPR3);

        LinkedList<String> listPR4 = new LinkedList<>();
        listPR4.add("x");
        productionRule.add(listPR4);

        LinkedList<String> listPR5 = new LinkedList<>();
        listPR5.add("y");
        productionRule.add(listPR5);

        LinkedList<String> listPR6 = new LinkedList<>();
        listPR6.add("z");
        productionRule.add(listPR6);
    }
}
