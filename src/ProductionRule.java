/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class ProductionRule {

    ArrayList<LinkedList> productionRule;

    public ProductionRule() {
        productionRule = new ArrayList<>();
    }

    public void addRule(LinkedList ll) {
        productionRule.add(ll);
    }

    public int getRuleCount() {
        return productionRule.size();
    }

    public LinkedList getRule(Integer i) {
        return productionRule.get(i);
    }

    protected void createRules() {

    }
}
