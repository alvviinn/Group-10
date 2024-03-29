package com.calculator;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;

public class Calculator_App extends JFrame implements CalculatorButtonClickListener{

    private JTextField cal_screen;
    private double total = 0;
    private char math_operator;
    private double total_eva;
    private int equalClickCount = 0;

    

    public Calculator_App() {
        setTitle(" ");
        setSize(1000, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font screenFont = new Font ("Times New Roman", Font.PLAIN, 25);

        JPanel calScreenPanel = new JPanel(new BorderLayout());
        cal_screen = new JTextField();
        cal_screen.setEditable(false);
        // cal_screen.setBounds(0, 0, 1000, 100);
        cal_screen.setBackground(Color.GRAY);
        cal_screen.setForeground(Color.WHITE);
        cal_screen.setHorizontalAlignment(SwingConstants.RIGHT);
        cal_screen.setPreferredSize(new Dimension(1000, 90));
        cal_screen.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        cal_screen.setFont(screenFont);
        calScreenPanel.add(cal_screen, BorderLayout.CENTER);
        add(calScreenPanel, BorderLayout.NORTH);


        Font buttonFont = new Font ("Times New", Font.PLAIN, 25);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 10, 0, 0));
        // buttonPanel.setBounds(0, 95, 1000, 469);
        buttonPanel.setBackground(Color.WHITE );
        String[] buttonLabels = {
                "(", ")", "mc", "m+", "m-", "mr", " ", "+/-", "%", "÷",
                "2ⁿᵈ", "x²", "x³", "xʸ", "eˣ", "10ˣ", "7", "8", "9", "x",
                "⅟x", "√", "∛", "x√y", "ln", "log₁₀", "4", "5", "6", "-",
                "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+",
                "Rad", "sinh", "cosh", "tanh", "π", "Rand", "C", "0", ".", "=",
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setForeground(Color.WHITE);
            button.setBackground(Color.BLACK);
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            if (label.equals("÷") || label.equals("x") || label.equals("-") || label.equals("+") || label.equals("=")) {
                button.setBackground(Color.ORANGE);
            }
            if (label.matches("\\d")) {
                button.setBackground(Color.GRAY);
            }
            if (label.equals("C")){
                button.setBackground(Color.DARK_GRAY);
                button.setForeground(Color.RED);
            }
            button.setFont(buttonFont);
            buttonPanel.add(button);
            button.addActionListener(e -> {
                String command = ((JButton) e.getSource()).getText();
                this.onButtonClicked(command); 
            });
            
    }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void onButtonClicked(String command) {
        
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
                String[] parts = cal_screen.getText().split("x√y");
                if (parts.length != 2) {
                    System.err.println("Invalid input format. Please enter x√y followed by a number.");
                    break;
                }
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                double result = Math.pow(y, 1 / x);
                cal_screen.setText(Double.toString(result));
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
    
    public static void main(String[] args) {
        new Calculator_App();
    }
}

