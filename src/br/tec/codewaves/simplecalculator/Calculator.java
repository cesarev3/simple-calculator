package br.tec.codewaves.simplecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public Calculator(){
    }

    public String calculateAddition(double number1, double number2){
        BigDecimal decimal = new BigDecimal(number1 + number2);
        return maxDecimalScale(decimal);
    }

    public String calculateSubtraction(double number1, double number2){
        BigDecimal decimal = new BigDecimal(number1 - number2);
        return maxDecimalScale(decimal);
    }

    public String calculateMultiplicacation(double number1, double number2){
        BigDecimal decimal = new BigDecimal(number1 * number2);
        return maxDecimalScale(decimal);
    }

    public String calculateDivision(double number1, double number2){
        BigDecimal decimal = new BigDecimal(number1 / number2);
        return maxDecimalScale(decimal);
    }

    public String calculatePowerBy(double number1, double number2){
        BigDecimal decimal = BigDecimal.valueOf(Math.pow(number1, number2));
        return maxDecimalScale(decimal);
    }

    public String calculatePercent(String inputBuildNumber){
        double baseNumber = Double.parseDouble(String.valueOf(inputBuildNumber));
        BigDecimal decimal = new BigDecimal(baseNumber / 100.0);
        return maxDecimalScale(decimal);
    }

    public String maxDecimalScale(BigDecimal inputDecimal){
        if (inputDecimal.scale() > 10) {
            return String.valueOf(inputDecimal.setScale(10, RoundingMode.CEILING));
        } else return String.valueOf(inputDecimal);
    }
}
