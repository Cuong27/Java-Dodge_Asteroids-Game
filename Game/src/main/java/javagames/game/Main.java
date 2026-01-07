package javagames.game;

import javagames.util.GamePanel;

import javax.swing.*;

public class Main {
    public static void main() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.setTitle("Tim con me m");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setVisible(true);
        window.setLocationRelativeTo(null);
        gamePanel.StartGame();
        gamePanel.requestFocusInWindow();
    }
}
