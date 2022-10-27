package rtu.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SoccerApplication extends JFrame {

    public int realScore = 0;
    public int milanScore = 0;

    private void updateWinner(JLabel label)
    {
        if (realScore == milanScore)
            label.setText("Winner: DRAW");
        else {
            if (realScore > milanScore)
                label.setText("winner: Real Madrid");
            else
                label.setText("winner: AC Milan");
        }
    }

    public SoccerApplication()
    {
        super("Real Madrid - AC Milan");
        setLayout(new BorderLayout(10, 10));
        setSize(500, 500);

        JButton realButton = new JButton("Real Madrid");
        JButton milanButton = new JButton("AC Milan");
        JLabel resultLabel = new JLabel("Result: " +
                realScore + " x "+ milanScore);
        JLabel scorerLabel = new JLabel("Last Scorer: N/A");
        JLabel winnerLabel = new JLabel("Winner: DRAW");

        scorerLabel.setPreferredSize(new Dimension(200, 100));
        resultLabel.setPreferredSize(new Dimension(200, 100));
        winnerLabel.setPreferredSize(new Dimension(200, 100));

        scorerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(realButton, BorderLayout.WEST);
        add(milanButton, BorderLayout.EAST);
        add(winnerLabel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.NORTH);
        add(scorerLabel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem resetItem = new JMenuItem("Reset the game");
        settingsMenu.add(resetItem);
        menuBar.add(settingsMenu);
        setJMenuBar(menuBar);

        realButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                realScore++;
                resultLabel.setText("Result: " +
                        realScore + " x "+ milanScore);
                scorerLabel.setText("Last Scorer: Real Madrid");
                updateWinner(winnerLabel);
            }
        });

        milanButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                milanScore++;
                resultLabel.setText("Result: " +
                        realScore + " x "+ milanScore);
                scorerLabel.setText("Last Scorer: AC Milan");
                updateWinner(winnerLabel);
            }
        });

        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realScore = 0;
                milanScore = 0;
                JLabel resultLabel = new JLabel("Result: " +
                        realScore + " x "+ milanScore);
                JLabel scorerLabel = new JLabel("Last Scorer: N/A");
                JLabel winnerLabel = new JLabel("Winner: DRAW");
            }
        });

    }


    public static void main(String[] args) {
        new SoccerApplication().setVisible(true);
    }
}


