
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 *
 * @author Lenovo
 */
public class Derivative {

    LinkedList equation;
    LinkedList equationBackup;

    public Derivative(LinkedList equation) {
        this.equation = equation;
        this.equationBackup = equation;
        process();
        printEquation();
    }

    private void process() {
        for (int i = 0; i < equation.size(); i++) {
            if (equation.get(i).toString() == "sin") {
                equation.set(i, "cos");
            } else if (equation.get(i).toString() == "cos") {
                equation.set(i, "-sin");
            } else if (equation.get(i).toString() == "-sin") {
                equation.set(i, "-cos");
            } else if (equation.get(i).toString() == "-cos") {
                equation.set(i, "sin");
            }
        }
    }

    public LinkedList getEquation() {
        return equation;
    }
    
    public int findClosingParenthesis(LinkedList equation, int openPosition) {
        int closePosition = openPosition;
        int counter = 1;
        while (counter > 0) {
            String str = equation.get(++closePosition).toString();
            if (str == "(") {
                counter++;
            }
            else if (str == ")") {
                counter--;
            }
        }
        return closePosition;
    }

    public void printEquation() {
        for (int i = 0; i < equation.size(); i++) {
            System.out.print(equation.get(i).toString() + " ");
        }
        System.out.println("");
    }

}
