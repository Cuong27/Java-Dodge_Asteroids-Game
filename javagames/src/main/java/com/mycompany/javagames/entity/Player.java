/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javagames.entity;
import com.mycompany.javagames.util.GamePanel;
import com.mycompany.javagames.util.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import com.mycompany.javagames.util.GamePanel;
/**
 *
 * @author Admin
 */


public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;
    
    public Player(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        
    }
    public void init(){
        this.x = 100;
        this.y = 100;
        this.speed =4;
    }
    public void paint(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
    
    public void update(){
        if(keyHandler.upPressed){
            y -= speed;
            System.out.println("W key pressed");
        } 
        if(keyHandler.downPressed){
            y += speed;
            System.out.println("S key pressed");
        } 
        if(keyHandler.leftPressed){
            x -= speed;
            System.out.println("A key pressed");
        } 
        if(keyHandler.rightPressed){
            x += speed;
            System.out.println("D key pressed");
        } 
    }
}
