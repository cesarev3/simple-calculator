/*
 * Created by JFormDesigner on Wed Jan 17 14:51:43 BRT 2024
 */

package br.tec.codewaves.simplecalculator.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import br.tec.codewaves.simplecalculator.Calculator;
import net.miginfocom.swing.*;

/**
 * @author Carlos Cesar Pereira - Janeiro/2024
 */
public class MainFrame extends JFrame {
    Calculator calculator = new Calculator();
    StringBuilder buildNumber = new StringBuilder();
    
    public MainFrame() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        buildNumber.append("1");
        updateScreen();
    }

    private void button2(ActionEvent e) {
        buildNumber.append("2");
        updateScreen();
    }

    private void button3(ActionEvent e) {
        buildNumber.append("3");
        updateScreen();
    }

    private void button4(ActionEvent e) {
        buildNumber.append("4");
        updateScreen();
    }

    private void button5(ActionEvent e) {
        buildNumber.append("5");
        updateScreen();
    }

    private void button6(ActionEvent e) {
        buildNumber.append("6");
        updateScreen();
    }

    private void button7(ActionEvent e) {
        buildNumber.append("7");
        updateScreen();
    }

    private void button8(ActionEvent e) {
        buildNumber.append("8");
        updateScreen();
    }

    private void button9(ActionEvent e) {
        buildNumber.append("9");
        updateScreen();
    }

    private void button10(ActionEvent e) {
        buildNumber.append("0");
        updateScreen();
    }

    private void invert(ActionEvent e) {
        int i = buildNumber.indexOf("-");

        if (i == 0) buildNumber.delete(0, 1);
        else buildNumber.insert(0, "-");
        updateScreen();
    }

    private void decimal(ActionEvent e) {
        if (buildNumber.isEmpty() && !decimal) {
            buildNumber.append("0.");
            decimal = true;

        } else if (!decimal) {
            buildNumber.append(".");
            decimal = true;
        }
        updateScreen();
    }

    private void updateScreen() {
        textScreen.setText(buildNumber.toString());
    }

    private void clean(ActionEvent e) {
        allClean();
    }

    private void turnBooleansToFalse() {
        plus = false;
        minus = false;
        times = false;
        dividedBy = false;
        powerBy = false;
    }

    private void percent(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        buildNumber = new StringBuilder(calculator.calculatePercent(String.valueOf(buildNumber)));
//        double baseNumber = Double.parseDouble(String.valueOf(buildNumber));
//        baseNumber = baseNumber / 100;
//        buildNumber = new StringBuilder(String.valueOf(baseNumber));
        updateScreen();
    }

    private void plus(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        firstNumber = Double.parseDouble(String.valueOf(buildNumber));
        plus = true;
        decimal = false;
        buildNumber.delete(0,buildNumber.length());
    }

    private void minus(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        firstNumber = Double.parseDouble(String.valueOf(buildNumber));
        minus = true;
        decimal = false;
        buildNumber.delete(0,buildNumber.length());
    }

    private void times(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        firstNumber = Double.parseDouble(String.valueOf(buildNumber));
        times = true;
        decimal = false;
        buildNumber.delete(0,buildNumber.length());
    }

    private void dividedBy(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        firstNumber = Double.parseDouble(String.valueOf(buildNumber));
        dividedBy = true;
        decimal = false;
        buildNumber.delete(0,buildNumber.length());
    }

    private void powerBy(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        firstNumber = Double.parseDouble(String.valueOf(buildNumber));
        powerBy = true;
        decimal = false;
        buildNumber.delete(0,buildNumber.length());
    }

    private void equals(ActionEvent e) {
        if (buildNumber.isEmpty()) return;
        secondNumber = Double.parseDouble(String.valueOf(buildNumber));
        String newTextScreen;

        if (plus) newTextScreen = calculator.calculateAddition(firstNumber, secondNumber);
        else if (minus) newTextScreen = calculator.calculateSubtraction(firstNumber, secondNumber);
        else if (times) newTextScreen = calculator.calculateMultiplicacation(firstNumber, secondNumber);
        else if (dividedBy) newTextScreen = calculator.calculateDivision(firstNumber, secondNumber);
        else if (powerBy) newTextScreen = calculator.calculatePowerBy(firstNumber, secondNumber);
        else return;

        buildNumber.delete(0,buildNumber.length());
        buildNumber.append(newTextScreen);
        updateScreen();
        turnBooleansToFalse();
        decimal = true;
    }
    
    private void allClean() {
        buildNumber.delete(0,buildNumber.length());
        textScreen.setText("");
        decimal = false;
        plus = false;
        minus = false;
        times = false;
        dividedBy = false;
        powerBy = false;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Cesar
        textScreen = new JFormattedTextField();
        buttonClean = new JButton();
        buttonPercent = new JButton();
        buttonPowerBy = new JButton();
        buttonDividedBy = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        buttonTimes = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        buttonMinus = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        buttonPlus = new JButton();
        buttonInvert = new JButton();
        button10 = new JButton();
        buttonDecimal = new JButton();
        buttonEquals = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,align leading top",
            // columns
            "[77,fill]" +
            "[68,fill]" +
            "[77,fill]" +
            "[77,fill]",
            // rows
            "[70]" +
            "[12]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- textScreen ----
        textScreen.setFont(new Font("Segoe UI", Font.PLAIN, 36));
        textScreen.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(textScreen, "cell 0 0 4 1,growy");

        //---- buttonClean ----
        buttonClean.setText("C");
        buttonClean.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonClean.addActionListener(e -> clean(e));
        contentPane.add(buttonClean, "cell 0 2");

        //---- buttonPercent ----
        buttonPercent.setText("%");
        buttonPercent.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonPercent.addActionListener(e -> percent(e));
        contentPane.add(buttonPercent, "cell 1 2");

        //---- buttonPowerBy ----
        buttonPowerBy.setText("x^y");
        buttonPowerBy.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonPowerBy.addActionListener(e -> powerBy(e));
        contentPane.add(buttonPowerBy, "cell 2 2");

        //---- buttonDividedBy ----
        buttonDividedBy.setText("\u00f7");
        buttonDividedBy.setBackground(new Color(0xd69999));
        buttonDividedBy.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonDividedBy.addActionListener(e -> dividedBy(e));
        contentPane.add(buttonDividedBy, "cell 3 2");

        //---- button7 ----
        button7.setText("7");
        button7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7, "cell 0 3");

        //---- button8 ----
        button8.setText("8");
        button8.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8, "cell 1 3");

        //---- button9 ----
        button9.setText("9");
        button9.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button9.addActionListener(e -> button9(e));
        contentPane.add(button9, "cell 2 3");

        //---- buttonTimes ----
        buttonTimes.setText("\u00d7");
        buttonTimes.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonTimes.setBackground(new Color(0xd69999));
        buttonTimes.addActionListener(e -> times(e));
        contentPane.add(buttonTimes, "cell 3 3");

        //---- button4 ----
        button4.setText("4");
        button4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4, "cell 0 4");

        //---- button5 ----
        button5.setText("5");
        button5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button5.addActionListener(e -> button5(e));
        contentPane.add(button5, "cell 1 4");

        //---- button6 ----
        button6.setText("6");
        button6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6, "cell 2 4");

        //---- buttonMinus ----
        buttonMinus.setText("-");
        buttonMinus.setBackground(new Color(0xd69999));
        buttonMinus.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonMinus.addActionListener(e -> minus(e));
        contentPane.add(buttonMinus, "cell 3 4");

        //---- button1 ----
        button1.setText("1");
        button1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1, "cell 0 5");

        //---- button2 ----
        button2.setText("2");
        button2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2, "cell 1 5");

        //---- button3 ----
        button3.setText("3");
        button3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3, "cell 2 5");

        //---- buttonPlus ----
        buttonPlus.setText("+");
        buttonPlus.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonPlus.setBackground(new Color(0xd69999));
        buttonPlus.addActionListener(e -> plus(e));
        contentPane.add(buttonPlus, "cell 3 5");

        //---- buttonInvert ----
        buttonInvert.setText("+/-");
        buttonInvert.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonInvert.addActionListener(e -> invert(e));
        contentPane.add(buttonInvert, "cell 0 6");

        //---- button10 ----
        button10.setText("0");
        button10.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button10.addActionListener(e -> button10(e));
        contentPane.add(button10, "cell 1 6");

        //---- buttonDecimal ----
        buttonDecimal.setText(".");
        buttonDecimal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        buttonDecimal.addActionListener(e -> decimal(e));
        contentPane.add(buttonDecimal, "cell 2 6");

        //---- buttonEquals ----
        buttonEquals.setText("=");
        buttonEquals.setFont(new Font("Segoe UI", Font.BOLD, 18));
        buttonEquals.setBackground(new Color(0xff6419));
        buttonEquals.addActionListener(e -> equals(e));
        contentPane.add(buttonEquals, "cell 3 6");

        //---- label1 ----
        label1.setText("Powered by CodeWaves");
        contentPane.add(label1, "cell 0 7 4 1,alignx center,growx 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // personalizado
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Calculator");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Carlos Cesar
    private JFormattedTextField textScreen;
    private JButton buttonClean;
    private JButton buttonPercent;
    private JButton buttonPowerBy;
    private JButton buttonDividedBy;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonTimes;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton buttonMinus;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton buttonPlus;
    private JButton buttonInvert;
    private JButton button10;
    private JButton buttonDecimal;
    private JButton buttonEquals;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    double firstNumber;
    double secondNumber;
    boolean plus;
    boolean minus;
    boolean times;
    boolean dividedBy;
    boolean decimal;
    boolean powerBy;
}
