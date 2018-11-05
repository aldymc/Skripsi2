/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.mathparser.aldy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Aldy Marcellino Christian - 2013730005
 */
public class ProductionRules {

    public final static int MAX_RANDOM = 255;
    public final static int MAX_CHROMOSOME = 50;

    public final static String EXPR = "<expr>";
    public final static String OP = "<op>";
    public final static String FUNC = "<func>";
    public final static String DIGIT = "<digit>";
    public final static String START_PARENTHESIS = "(";
    public final static String END_PARENTHESIS = ")";
    public final static String BACKSLACE = "\\";

    public final static int NO_INDEX = -1;

    private List<String> expr;
    private List<String> op;
    private List<String> func;
    private List<String> digit;

    public ProductionRules() {
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

    private int lengthGrammarRules(int val) {
        this.setGrammarRules();

        if (val == 0) {
            return expr.size();
        }

        if (val == 1) {
            return op.size();
        }

        if (val == 2) {
            return func.size();
        }

        if (val == 3) {
            return digit.size();
        }

        return 0;
    }

    private List<String> selectGrammarRules(String val) {
        this.setGrammarRules();

        if (val.equals(ProductionRules.EXPR)) {
            return expr;
        }

        if (val.equals(ProductionRules.OP)) {
            return op;
        }

        if (val.equals(ProductionRules.FUNC)) {
            return func;
        }

        if (val.equals(ProductionRules.DIGIT)) {
            return digit;
        }

        return new ArrayList<String>();
    }

    private List<Integer> convertArraytoListInteger(int[] val) {
        List<Integer> output = new ArrayList<Integer>();

        for (int v : val) {
            output.add(v);
        }

        return output;
    }

    private int[] convertListtoArrayInteger(List<Integer> val) {
        int[] output = new int[val.size()];

        int i = 0;
        for (int v : val) {
            output[i] = v;
            i++;
        }

        return output;
    }

    private int checkIndexGrammar(String[] list_str_output) {
        int output = ProductionRules.NO_INDEX;

        int i = 0;
        for (String str : list_str_output) {
            List<String> check_grammar = this.selectGrammarRules(str);

            if (check_grammar.size() > 0) {
                return i;
            }
            i++;
        }

        return output;
    }

    public List<String> startProductionRules(int[] chromosome) {
        List<String> list_str_output = new ArrayList<String>();

        List<Integer> ch_output = this.convertArraytoListInteger(chromosome);
        int len = ch_output.size();
        if (len == 0) {
            return null;
        }

        int loop = 0;
        String str_output = ProductionRules.EXPR;
        list_str_output.add(str_output);

        while (loop < len) {
            String[] split_str_output = str_output.split(MainFrame.SPACE);
            int index_grammar = this.checkIndexGrammar(split_str_output);

            if (index_grammar == ProductionRules.NO_INDEX) {
                break;
            }

            String str_grammar = split_str_output[index_grammar];
            List<String> current_grammar = this.selectGrammarRules(str_grammar);

            int current_val = ch_output.get(0);
            int div = current_grammar.size();

            int result = current_val % div;

            String str_current = current_grammar.get(result);
            /*if(loop == 0) str_current = current_grammar.get(2);
            if(loop == 2) str_current = current_grammar.get(0);*/
            split_str_output[index_grammar] = str_current;

            if (str_grammar.equals(ProductionRules.FUNC)) {
                split_str_output[index_grammar + 1] = ProductionRules.START_PARENTHESIS + MainFrame.SPACE
                        + split_str_output[index_grammar + 1] + MainFrame.SPACE + ProductionRules.END_PARENTHESIS + MainFrame.SPACE;
            }

            str_output = String.join(MainFrame.SPACE, split_str_output);
            list_str_output.add(str_output);
            ch_output.remove(0);
            loop++;

        }

        return list_str_output;
    }

    public String stringRandomIntegerArray(int[] x) {
        String output = MainFrame.EMPTY;

        for (int l : x) {
            output += String.valueOf(l) + MainFrame.COMMA + MainFrame.SPACE;
        }

        output = output.substring(0, output.length() - 2);
        return output;
    }

    public int[] randomIntegerArray(int x) {
        if (x <= 0 || x > ProductionRules.MAX_RANDOM) {
            return null;
        }

        int loop = 0;
        List<Integer> listInt = new ArrayList<Integer>();

        while (loop < x) {
            Random rnd = new Random();
            int val = rnd.nextInt(ProductionRules.MAX_RANDOM + 1) + 1;

            int idx = listInt.indexOf(val);
            if (idx < 0) {
                listInt.add(val);
                loop++;
            }
        }

        if (listInt.size() <= 0) {
            return null;
        }

        int[] output = this.convertListtoArrayInteger(listInt);
        return output;
    }

}
