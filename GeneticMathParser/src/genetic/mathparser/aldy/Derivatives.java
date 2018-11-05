/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.mathparser.aldy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aldy Marcellino Christian - 2013730005
 */
public class Derivatives {

    private List<String> expr;
    private List<String> op;
    private List<String> func;
    private List<String> digit;

    public Derivatives() {
        this.setGrammarRules();
    }

    private void setGrammarRules() {
        expr = new ArrayList<String>();
        expr.add("<expr> <op> <expr>");
        expr.add("<expr>");
        expr.add("<func> <expr>");
        expr.add("<digit>");
        expr.add("x");
        expr.add("y");
        expr.add("z");

        op = new ArrayList<String>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");

        func = new ArrayList<String>();
        func.add("sin");
        func.add("cos");
        func.add("exp");
        func.add("log");

        digit = new ArrayList<String>();
        digit.add("0");
        digit.add("1");
        digit.add("2");
        digit.add("3");
        digit.add("4");
        digit.add("5");
        digit.add("6");
        digit.add("7");
        digit.add("8");
        digit.add("9");

    }

    private List<String> opParser(String var_str) {
        List<String> output = new ArrayList<String>();

        //only operator '+' and '-'
        for (int i = 0; i < 2; i++) {
            String[] var_split = var_str.split(ProductionRules.BACKSLACE + op.get(i));

            if (var_split.length > 1) {
                for (String str : var_split) {
                    output.add(str);
                    output.add(op.get(i));
                }
                //output.addAll(Arrays.asList(var_split));

                output.remove(output.size() - 1);
                return output;
            }
        }

        return output;
    }

    public List<String> DerivativeParser(String func_str) {
        List<String> output = new ArrayList<String>();

        List<String> outputOp = this.opParser(func_str);

        if (outputOp.size() > 0) {
            for (String func : outputOp) {
                List<String> outputNext = DerivativeParser(func);
                output.addAll(outputNext);
            }

        } else {
            output.add(func_str);
        }

        return output;
    }

    public String DerivativeFunc(List<String> list) {
        String output = MainFrame.SPACE;

        if (list.size() != 0) {
            String[] listOutput = new String[list.size()];

            int i = 0;
            for (String ls : list) {
                //if operator "+" or "-"
                if (ls.equals(op.get(0)) || ls.equals(op.get(1))) {
                    listOutput[i] = ls;
                } else {
                    listOutput[i] = this.getDerivative(ls);
                }
                i++;
            }

            for (String lsO : listOutput) {

            }

            output = String.join(MainFrame.SPACE, listOutput);
        }

        if (output.equals(MainFrame.SPACE)) {
            output = "0";
        }
        return output;
    }

    private boolean checkOp(String var_str, String op_str) {
        String[] var_split = var_str.split(ProductionRules.BACKSLACE + op_str);

        if (var_split.length > 1) {
            return true;
        } else {
            return false;
        }
    }

    private String checkNumberDigit(String var_str) {
        try {
            int test = Integer.parseInt(var_str);
            return var_str;
        } catch (Exception e) {
            return "xxx";
        }
    }

    private String multiplyOp(String var_str) {
        String output = MainFrame.EMPTY;

        String[] var_split = var_str.split(ProductionRules.BACKSLACE + op.get(2));
        if (var_split.length == 0) {
            return output;
        }

        List<String> list = new ArrayList<String>();

        int i = 0;
        for (String str : var_split) {
            if (str.trim().toLowerCase().equals("x")) {
                i++;
            } else {
                String test = this.checkNumberDigit(str);

                if (!test.equals("xxx")) {
                    list.add(str);
                    list.add(op.get(2));
                }
            }
        }
        //untuk menghapus tanda simbol * di ujung looping
        if (list.size() > 1) {
            list.remove(list.size() - 1);
        }

        //untuk mengumpulkan x 
        if (i > 1) {
            list.add(String.valueOf(i) + MainFrame.SPACE + op.get(2) + MainFrame.SPACE + "x");
        }

        if (list.size() > 1) {
            output = String.join(MainFrame.SPACE, list.toArray(new String[list.size()]));
            output = output.trim();
        } else {
            output = MainFrame.EMPTY;
        }

        return output;
    }

    private String getDerivative(String var_str) {

        //variabel x
        if (var_str.trim().toLowerCase().equals("x")) {
            return "1";
        }

        if (var_str.trim().toLowerCase().equals("sin ( x )")) {
            return "cos ( x )";
        }

        if (var_str.trim().toLowerCase().equals("cos ( x )")) {
            return "-sin ( x )";
        }

        if (var_str.trim().toLowerCase().equals("exp ( x )")) {
            return "e ^ x";
        }

        if (var_str.trim().toLowerCase().equals("log ( x )")) {
            return "1 / x * log (x)";
        }

        if (var_str.trim().toLowerCase().equals("-sin ( x )")) {
            return "-cos ( x )";
        }

        if (var_str.trim().toLowerCase().equals("-cos ( x )")) {
            return "sin ( x )";
        }

        if (var_str.trim().toLowerCase().equals("e ^ x")) {
            return "e ^ x";
        }

        //variabel y
        if (var_str.trim().toLowerCase().equals("y")) {
            return "1";
        }

        if (var_str.trim().toLowerCase().equals("sin ( y )")) {
            return "cos ( y )";
        }

        if (var_str.trim().toLowerCase().equals("cos ( y )")) {
            return "-sin ( y )";
        }

        if (var_str.trim().toLowerCase().equals("exp ( y )")) {
            return "e ^ y";
        }

        if (var_str.trim().toLowerCase().equals("log ( y )")) {
            return "1 / y * log (y)";
        }

        if (var_str.trim().toLowerCase().equals("-sin ( y )")) {
            return "-cos ( y )";
        }

        if (var_str.trim().toLowerCase().equals("-cos ( y )")) {
            return "sin ( y )";
        }

        if (var_str.trim().toLowerCase().equals("e ^ y")) {
            return "e ^ y";
        }

        if (var_str.trim().toLowerCase().equals("y")) {
            return "1";
        }

        if (var_str.trim().toLowerCase().equals("sin ( y )")) {
            return "cos ( y )";
        }

        if (var_str.trim().toLowerCase().equals("cos ( y )")) {
            return "-sin ( y )";
        }

        if (var_str.trim().toLowerCase().equals("exp ( y )")) {
            return "e ^ y";
        }

        if (var_str.trim().toLowerCase().equals("log ( y )")) {
            return "1 / y * log (y)";
        }

        if (var_str.trim().toLowerCase().equals("-sin ( y )")) {
            return "-cos ( y )";
        }

        if (var_str.trim().toLowerCase().equals("-cos ( y )")) {
            return "sin ( y )";
        }

        if (var_str.trim().toLowerCase().equals("e ^ y")) {
            return "e ^ y";
        }
        
        //variabel z
         if (var_str.trim().toLowerCase().equals("z")) {
            return "1";
        }

        if (var_str.trim().toLowerCase().equals("sin ( z )")) {
            return "cos ( z )";
        }

        if (var_str.trim().toLowerCase().equals("cos ( z )")) {
            return "-sin ( z )";
        }

        if (var_str.trim().toLowerCase().equals("exp ( z )")) {
            return "e ^ z";
        }

        if (var_str.trim().toLowerCase().equals("log ( z )")) {
            return "1 / z * log (z)";
        }

        if (var_str.trim().toLowerCase().equals("-sin ( z )")) {
            return "-cos ( z )";
        }

        if (var_str.trim().toLowerCase().equals("-cos ( z )")) {
            return "sin ( z )";
        }

        if (var_str.trim().toLowerCase().equals("e ^ z")) {
            return "e ^ z";
        }
        
        // check multiply operator ("*")
        String mulOutput = multiplyOp(var_str);
        if (!mulOutput.equals(MainFrame.EMPTY)) {
            return mulOutput;
        }

        return "0";
    }

}
