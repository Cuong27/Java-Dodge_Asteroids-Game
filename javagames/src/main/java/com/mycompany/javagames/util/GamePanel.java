/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javagames.util;

/**
 *
 * @author Admin
 */

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.mycompany.javagames.entity.Player;

public class GamePanel extends JPanel implements Runnable {
    // Game 2D co kich thuoc cac tile la 16 * 16
    final int originalTileSize = 16;    
    final int scale = 3;
    // do 16*16 rat nho so voi do phan giai man hinh hien tai
    // can scale kich thuoc tile len 48*48
    public final int tileSize = originalTileSize * scale;
        
    // so luong hang tile max = 12
    final int maxRows = 12;
        
    // so luong cot tile max = 16
    final int maxCols = 16;
    final int screenWidth  = maxCols*tileSize;
        
    final int screenHeight = maxRows*tileSize; 
    // game thread
    
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    
    Player player = new Player(this,keyH);
    int player_x = 100;
    int player_y = 100;
    int speed = 4;
    
    int FPS = 60;
    
    public GamePanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
    }
    
    public void initGameThread(){
        gameThread = new Thread(this);
        
        gameThread.start();
        
    }
    // cap nhat thong tin vi tri
    // ve lai
    @Override
    public void run(){
        // 1 s = 1 000 000 000 nano second
        double drawInterval =  1_000_000_000 / FPS;
        long lastTime = System.nanoTime();
        long currentTime;
        int drawCount=0;
        double delta=0;
        long timer=0;
        
        player.init();
        while(gameThread!=null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                drawCount++;
                delta--;
            }
            if(timer>=1_000_000_000){
                System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }     
        }
       
    }
    // ham nay update lai vi tri -> chay trong thread
    public void update(){
        player.update();
    }
    
    // ham nay ve len panel
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        player.paint(g2);
        //g2.setColor(Color.WHITE);
        //g2.fillRect(player_x, player_y, tileSize, tileSize);
    }
}
