package rtu.task23;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new GuessGame();
    }
}

class GuessGame extends JFrame {

    private final JLabel title = new JLabel("Игра-Угадайка");
    private final JLabel label = new JLabel("Угадайте число от 0 до 20");
    private final JTextField textField = new JTextField(50);
    boolean isGameOver;
    private boolean isGuessed;
    private int attemptNumber = 3;
    private final int mysteryNumber;

    public GuessGame(){
        setSize(300,300);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        title.setBounds(100, 0, 100, 50);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        label.setBounds(25, 70, 250, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        textField.setBounds(100, 140, 100, 30);
        textField.setHorizontalAlignment(JTextField.CENTER);

        JButton button = new JButton("OK");
        button.setBounds(100, 200, 100, 30);

        add(title);
        add(label);
        add(textField);
        add(button);

        mysteryNumber = (int)(Math.random() * 20 + 1);

        button.addActionListener(e -> {
            if(isGameOver) {
                return;
            }
            guess();
            if(attemptNumber == 0 || isGuessed) {
                finishGame(isGuessed);
            }
        });
    }

    private void guess(){
        String text = textField.getText();
        if(text == null) {
            return;
        }

        int result = Integer.parseInt(text);

        if (result == mysteryNumber) {
            isGuessed = true;
        }
        else if (result > mysteryNumber) {
            label.setText("Введённое число меньше загаданного");
            attemptNumber--;
        }
        else {
            label.setText("Введённое число больше загаданного");
            attemptNumber--;
        }
    }

    private void finishGame(boolean guessed){
        if (guessed){
            label.setText("Число угадано!");
        }
        else {
            label.setText("Вы не смогли угадать число " + mysteryNumber);
        }
        isGameOver = true;
    }
}
