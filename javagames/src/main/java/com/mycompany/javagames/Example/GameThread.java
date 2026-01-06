/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javagames.Example;

/**
 *
 * @author Admin
 */

// vi du cho Game Thread

import java.awt.event.*;
import javax.swing.*;

// day la 1 vi du ve game thread
// class Gamethread ke thua tu JFrame 

// chay 1 thread song song voi EDT
// EDT cap nhat GUI
// thread se thuc hien viec render

public class GameThread extends JFrame implements Runnable{
    Thread gameThread;
    private boolean running;
    public GameThread(){}
    
    // ham tao GUI va thread
    public void showAndCreateGUI(){
        gameThread =  new Thread(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
        gameThread.start();
    }
    
    private void sleep(long sleep){
        try{Thread.sleep(sleep);
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    // override method run cua Runnable
    // thuc hien viec in ra man hinh 
    // va sleep 10ms
    @Override
    public void run(){
        running = true;
        while(running){
            System.out.println("Game Thread is running");
            sleep(10);
        }
    }
    
    // dong thread dung cach tranh loi
    protected void onWindowClosing(){
        try{
            System.out.println("Stopping");
            running = false;
            // ham join tra ket qua thi moi in duoc stopped
            // de ham nay no se doi gameThread dung hoan toan
            gameThread.join();
            System.out.println("stopped");
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        System.exit(0);
    }
    public static void main(String[] args) {
        GameThread g = new GameThread();
        // them listener lang nghe viec nguoi dung dong cua so
        // thuc hien viec dong cua so
        g.addWindowListener(new WindowAdapter(){
            @Override 
            public void windowClosing(WindowEvent e){
                g.onWindowClosing();
            }
        });
        
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                g.showAndCreateGUI();
            }
        });             
       
    }

}
