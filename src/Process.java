
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Process {

    Chromosome chromosome;
    int[] array;
    LinkedList<Object> listPR;
    LinkedList<String> listPRImplified;
    String equation;

    Expr expr;
    Func func;
    Op op;
    Digit digit;

    public Process(Chromosome chromosome) {
        listPR = new LinkedList<Object>();
        listPR.add("expr");
        this.chromosome = chromosome;
        array = chromosome.getArray();
        printListPR();
        System.out.println("");
        expr = new Expr();
        func = new Func();
        op = new Op();
        digit = new Digit();
        processLoop();
        simplyfyEquation();
    }

    private void processLoop() {
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            while (j < listPR.size()) {
                if (listPR.get(j) == "expr") {
                    System.out.println(listPR.get(j));
                    System.out.println(array[i] % expr.getRuleCount());
                    listPR.remove(j);
                    listPR.addAll(j, expr.getRule(array[i] % expr.getRuleCount()));
                    printListPR();
                    System.out.println("");
                    break;
                } else if (listPR.get(j) == "func") {
                    System.out.println(listPR.get(j));
                    System.out.println(array[i] % func.getRuleCount());
                    listPR.remove(j);
                    listPR.addAll(j, func.getRule(array[i] % func.getRuleCount()));
                    printListPR();
                    System.out.println("");
                    break;
                } else if (listPR.get(j) == "op") {
                    System.out.println(listPR.get(j));
                    System.out.println(array[i] % op.getRuleCount());
                    listPR.remove(j);
                    listPR.addAll(j, op.getRule(array[i] % op.getRuleCount()));
                    printListPR();
                    System.out.println("");
                    break;
                } else if (listPR.get(j) == "digit") {
                    System.out.println(listPR.get(j));
                    System.out.println(array[i] % digit.getRuleCount());
                    listPR.remove(j);
                    listPR.addAll(j, digit.getRule(array[i] % digit.getRuleCount()));
                    printListPR();
                    System.out.println("");
                    break;
                } else {
                    j++;
                }
            }
        }
    }

    public void simplyfyEquation() {
        String equation = new String();
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> equations = new ArrayList<String>();
        for (int i = 0; i < listPR.size(); i++) {
            equation += listPR.get(i).toString();
        }
        System.out.println(equation);
        String[] split = equation.split("(?<=log\\()|(?=log\\()"
                + "|(?<=exp\\()|(?=exp\\()"
                + "|(?<=sin\\()|(?=sin\\()"
                + "|(?<=cos\\()|(?=cos\\()"
                + "|(?<=\\))|(?=\\))"
                + "|(?<=\\+)|(?=\\+)"
                + "|(?<=\\-)|(?=\\-)");
        System.out.println(Arrays.toString(split));
        for (int i = 0; i < split.length; i++) {
            boolean zero = false;
            String[] splitMultiplyDivide = split[i].split("(?<=\\*)|(?=\\*)"
                    + "|(?<=\\/)|(?=\\/)");
            if (splitMultiplyDivide[0].equals("0")) {
                zero = true;
            }
            if (splitMultiplyDivide[0].equals("1") && (splitMultiplyDivide[1].equals("*"))) {
                splitMultiplyDivide[0] = "";
                splitMultiplyDivide[1] = "";
            }
            for (int j = 1; j < splitMultiplyDivide.length - 1; j++) {
                if (splitMultiplyDivide[j].equals("*") && splitMultiplyDivide[j + 1].equals("1")) {
                    splitMultiplyDivide[j] = "";
                    splitMultiplyDivide[j + 1] = "";
                }
                if (splitMultiplyDivide[j].equals("/") && splitMultiplyDivide[j + 1].equals("1")) {
                    splitMultiplyDivide[j] = "";
                    splitMultiplyDivide[j + 1] = "";
                }
                if (splitMultiplyDivide[j].equals("*") && splitMultiplyDivide[j + 1].equals("0")) {
                    zero = true;
                }
                if (splitMultiplyDivide[j].equals("/") && splitMultiplyDivide[j + 1].equals("0")) {
                    throw new IllegalStateException("Error! Can not be divided by zero!");
                }
            }
            split[i] = new String();
            if (zero == true) {
                split[i] = "0";
            } else {
                for (int j = 0; j < splitMultiplyDivide.length; j++) {
                    split[i] += splitMultiplyDivide[j];
                }
            }
        }
        listPRImplified = new LinkedList<String>();
        for (int i = 0; i < split.length; i++) {
            listPRImplified.add(split[i]);
        }
        printListPRSimplified();
    }

    public LinkedList getEquation() {
        return listPR;
    }

    public LinkedList getSimplifiedEquation() {
        return listPRImplified;
    }

    public boolean isNumeric(String strNum) {
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public void printListPR() {
        for (int i = 0; i < listPR.size(); i++) {
            System.out.print(listPR.get(i).toString() + " ");
        }
        System.out.println("");
    }

    public void printListPRSimplified() {
        for (int i = 0; i < listPRImplified.size(); i++) {
            System.out.print(listPRImplified.get(i).toString() + " ");
        }
        System.out.println(" ");
    }
}
