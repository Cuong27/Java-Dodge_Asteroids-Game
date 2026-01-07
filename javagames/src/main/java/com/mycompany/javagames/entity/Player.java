/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javagames.entity;

import com.mycompany.javagames.util.KeyHandler;
import java.awt.Graphics2D;

import java.awt.Color;
import javax.imageio.ImageIO;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import com.mycompany.javagames.util.GamePanel;
import java.awt.image.BufferedImage;
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
        this.getPlayerImage();
        direction = "down";
    }
    public void init(){
        this.x = 100;
        this.y = 100;
        this.speed =4;
    }
    public void paint(Graphics2D g){
        //g.setColor(Color.WHITE);
        //g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        BufferedImage image = null;
        
        // kiem tra direction
        switch(direction){
            case "up":
                // su dung toan tu ternary
                image = (spriteNum == 1) ? up1 : up2;
                break;
            case "down":
                image = (spriteNum == 1) ? down1 : down2;
                break;
            case "left":
                image = (spriteNum == 1) ? left1 : left2;
                break;
            case "right":
                image = (spriteNum == 1) ? right1 : right2;
                break;
        }
        g.drawImage(image, x,y,gamePanel.tileSize,gamePanel.tileSize,null);
    }
    // phuong thuc nay load anh nhan vat
    public void getPlayerImage(){
        Path resPath = Paths.get(
        System.getProperty("user.dir"),
        "resources",
        "trump_32"
        );
        try{
            up1 = ImageIO.read(resPath.resolve("back1.png").toFile());
            up2 = ImageIO.read(resPath.resolve("back2.png").toFile());
            down1 = ImageIO.read(resPath.resolve("down1.png").toFile());
            down2 = ImageIO.read(resPath.resolve("down2.png").toFile());
            left1 = ImageIO.read(resPath.resolve("left1.png").toFile());
            left2 = ImageIO.read(resPath.resolve("left2.png").toFile());
            right1 = ImageIO.read(resPath.resolve("right1.png").toFile());
            right2 = ImageIO.read(resPath.resolve("right2.png").toFile());
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void update(){
        if(keyHandler.upPressed || keyHandler.downPressed || 
                keyHandler.rightPressed || keyHandler.leftPressed){
          if(keyHandler.upPressed){
            direction = "up";
            y -= speed;
        } 
        if(keyHandler.downPressed){
            direction = "down";
            y += speed;
            
        } 
        if(keyHandler.leftPressed){
            direction = "left";
            x -= speed;
            
        } 
        if(keyHandler.rightPressed){
            direction = "right";
            x += speed;
            
        }
        spriteCounter++;
        // sau 10 frame mac du nhan vat van di chuyen thi sau 10 frame
        // moi update anh moi
        if(spriteCounter>10){
            spriteNum = (spriteNum==1) ? 2 : 1;
            spriteCounter = 0;
        }  
        }
        
    }
}
