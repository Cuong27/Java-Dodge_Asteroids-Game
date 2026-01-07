/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javagames;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import com.mycompany.javagames.util.*;

public class Javagames {

    public static void main(String[] args) {
        JFrame window = new JFrame("Game");
        window.setSize(300, 300);
        window.setResizable(false);
        
        
        GamePanel gamepanel = new GamePanel();
        
        window.add(gamepanel);
        
        window.pack();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamepanel.requestFocusInWindow(); // 👈 VERY IMPORTANT
        gamepanel.initGameThread();
        
        System.out.println(System.getProperty("user.dir"));
    }
}
