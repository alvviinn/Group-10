package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_App extends JFrame {

    private JTextField cal_screen;
    private double total = 0;
    private char math_operator;
    private double total_eva;

    Font myFont = new Font ("Ink Free", Font.BOLD, 30);


    public Calculator_App() {
        setTitle(" ");
        setSize(700, 494); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        cal_screen = new JTextField("HINT : Press the \"=\" button twice to clear the screen");
        cal_screen.setEditable(false);
        cal_screen.setBounds(0, 0, 700, 55);
        cal_screen.setBackground(Color.DARK_GRAY);
        cal_screen.setForeground(Color.WHITE);
        cal_screen.setHorizontalAlignment(SwingConstants.RIGHT);
        add(cal_screen, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 10, 0, 0));
        buttonPanel.setBounds(0, 56, 700, 400);
        buttonPanel.setBackground(Color.WHITE );
        String[] buttonLabels = {
                "(", ")", "mc", "m+", "m-", "mr", "C", "+/-", "%", "÷",
                "2ⁿᵈ", "x²", "x³", "xʸ", "eˣ", "10ˣ", "7", "8", "9", "x",
                "⅟x", "√", "∛", "x√y", "ln", "log₁₀", "4", "5", "6", "-",
                "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+",
                "Rad", "sinh", "cosh", "tanh", "π", "Rand", "0", " ", ".", "=",
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setForeground(Color.WHITE);
            button.setBackground(Color.BLACK);
            if (label.equals("÷") || label.equals("x") || label.equals("-") || label.equals("+") || label.equals("=")) {
                button.setBackground(Color.ORANGE);
            }
            buttonPanel.add(button);
            button.addActionListener(new ButtonClickListener());
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int equalClickCount = 0;
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
    
            switch (command) {
                case "C":
                    total_eva = 0;
                    cal_screen.setText("");
                    break;
                case "=":
                    equalClickCount++;
                    if (equalClickCount == 2) {
                        cal_screen.setText("");
                        equalClickCount = 0;
                    } else {
                    if (!cal_screen.getText().isEmpty()) {
                        switch (math_operator) {
                            case '+':
                                total_eva = total + Double.parseDouble(cal_screen.getText());
                                break;
                            case '-':
                                total_eva = total - Double.parseDouble(cal_screen.getText());
                                break;
                            case 'x':
                                total_eva = total * Double.parseDouble(cal_screen.getText());
                                break;
                            case '÷':
                                total_eva = total / Double.parseDouble(cal_screen.getText());
                                break;
                        }
                        if (total_eva == (int) total_eva) {
                            cal_screen.setText(Integer.toString((int) total_eva)); 
                        } else {
                            cal_screen.setText(Double.toString(total_eva));
                        }
                        total = 0;
                    }
                }
                    break;
                case "+":
                case "-":
                case "x":
                case "÷":
                    total = Double.parseDouble(cal_screen.getText());
                    math_operator = command.charAt(0);
                    cal_screen.setText("");
                    break;
                case "√":
                    double sqrt = Math.sqrt(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(sqrt));
                    break;
                case "(":
                    cal_screen.setText(cal_screen.getText() + "(");
                    break;
                case ")":
                    cal_screen.setText(cal_screen.getText() + ")");
                    break;
                case "mc":
                    break;
                case "m+":
                    break;
                case "m-":
                    break;
                case "mr":
                    break;
                case "+/-":
                    double value = Double.parseDouble(cal_screen.getText());
                    value = -value;
                    cal_screen.setText(Double.toString(value));
                    break;
                case "%":
                    double percent = Double.parseDouble(cal_screen.getText()) / 100;
                    cal_screen.setText(Double.toString(percent));
                    break;
                case "2ⁿᵈ":
                    break;
                case "x²":
                    double square = Math.pow(Double.parseDouble(cal_screen.getText()), 2);
                    cal_screen.setText(Double.toString(square));
                    break;
                case "x³":
                    double cube = Math.pow(Double.parseDouble(cal_screen.getText()), 3);
                    cal_screen.setText(Double.toString(cube));
                    break;
                case "xʸ":
                    break;
                case "eˣ":
                    double exp = Math.exp(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(exp));
                    break;
                case "10ˣ":
                    double exp10 = Math.pow(10, Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(exp10));
                    break;
                case "⅟x":
                    double reciprocal = 1 / Double.parseDouble(cal_screen.getText());
                    cal_screen.setText(Double.toString(reciprocal));
                    break;
                case "∛":
                    double cuberoot = Math.cbrt(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(cuberoot));
                    break;
                case "x√y":
                    break;
                case "ln":
                    double ln = Math.log(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(ln));
                    break;
                case "log₁₀":
                    double log10 = Math.log10(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(log10));
                    break;
                case "x!":
                    int factorial = 1;
                    int num = Integer.parseInt(cal_screen.getText());
                    for (int i = 1; i <= num; i++) {
                        factorial *= i;
                    }
                    cal_screen.setText(Integer.toString(factorial));
                    break;
                case "sin":
                    double sin = Math.sin(Math.toRadians(Double.parseDouble(cal_screen.getText())));
                    cal_screen.setText(Double.toString(sin));
                    break;
                case "cos":
                    double cos = Math.cos(Math.toRadians(Double.parseDouble(cal_screen.getText())));
                    cal_screen.setText(Double.toString(cos));
                    break;
                case "tan":
                    double tan = Math.tan(Math.toRadians(Double.parseDouble(cal_screen.getText())));
                    cal_screen.setText(Double.toString(tan));
                    break;
                case "e":
                    cal_screen.setText(Double.toString(Math.E));
                    break;
                case "EE":
                    break;
                case "Rad":
                    break;
                case "sinh":
                    double sinh = Math.sinh(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(sinh));
                    break;
                case "cosh":
                    double cosh = Math.cosh(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(cosh));
                    break;
                case "tanh":
                    double tanh = Math.tanh(Double.parseDouble(cal_screen.getText()));
                    cal_screen.setText(Double.toString(tanh));
                    break;
                case "π":
                    cal_screen.setText(Double.toString(Math.PI));
                    break;
                case "Rand":
                    double rand = Math.random();
                    cal_screen.setText(Double.toString(rand));
                    break;
                case ".":
                    cal_screen.setText(cal_screen.getText() + ".");
                    break;
                default:
                    cal_screen.setText(cal_screen.getText() + command);
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        new Calculator_App();
    }
}
