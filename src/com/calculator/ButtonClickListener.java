package com.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private CalculatorButtonClickListener buttonClickListener;

    public ButtonClickListener(CalculatorButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        buttonClickListener.onButtonClicked(command);
    }
}
