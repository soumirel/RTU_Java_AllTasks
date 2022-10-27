package rtu.task23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new Game();
    }
}

class Game extends JFrame {
    private final JLabel label = new JLabel("Угадайте число от 0 до 20");
    private final JTextField textField = new JTextField(50);

    boolean isGameOver;

    private int attemptCount = 3;
    private boolean guessed;
    private final int hiddenNumber;

    public Game(){
        setSize(300,200);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        label.setBounds(0, 0, 300, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        textField.setBounds(100, 51, 100, 30);
        textField.setHorizontalAlignment(JTextField.CENTER);

        JButton button = new JButton("OK");
        button.setBounds(100, 91, 100, 30);

        add(label);
        add(textField);
        add(button);

        hiddenNumber = (int)(Math.random() * 20 + 1);

        button.addActionListener(e -> {
            if(isGameOver) return;

            TryToGuess();
            if(attemptCount == 0 || guessed){
                finishGame(guessed);
            }
        });
    }

    private void TryToGuess(){
        String text = textField.getText();
        if(text == null) return;

        int result = Integer.parseInt(text);

        if(result == hiddenNumber){
            guessed = true;
        } else if (result > hiddenNumber) {
            label.setText("Введённое число меньше загаданного");
            attemptCount--;
        }else{
            label.setText("Введённое число больше загаданного");
            attemptCount--;
        }
        textField.setText("");
    }

    private void finishGame(boolean guessed){
        if (guessed){
            label.setText("Число угадано!");
        }else{
            label.setText("Поражение!");
        }
        isGameOver = true;
    }
}
