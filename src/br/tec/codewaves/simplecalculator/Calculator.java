package br.tec.codewaves.simplecalculator;

public class Calculator {
    private double number1;
    private double number2;
    private double subTotal;
    private double total;

    public Calculator(){

    }
    public Calculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public String calculateAddition(double number1, double number2){
        return String.valueOf(number1 + number2);
    }

    public String calculateSubtraction(double number1, double number2){
        return String.valueOf(number1 - number2);
    }

    public String calculateMultiplicacation(double number1, double number2){
        return String.valueOf(number1 * number2);
    }

    public String calculateDivision(double number1, double number2){
        return String.valueOf(number1 / number2);
    }

    public String calculatePowerBy(double number1, double number2){
        return String.valueOf(Math.pow(number1, number2));
    }
}
