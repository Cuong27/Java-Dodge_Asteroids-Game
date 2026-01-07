package javagames.util;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //Màn hình settings
    final int defaultsize = 16;
    final int scale = 2;

    final int final_size = defaultsize*scale;
    final int maxScreenCol = 18;
    final int maxScreenRow = 16;
    final int Width = final_size * maxScreenCol;
    final int Height = final_size * maxScreenRow;


    int FPS = 60;
    Thread gameThread;
    KeyHandler keyhandler = new KeyHandler();
    Framerate fps = new Framerate();

    //Set vị trí mặc định cho nhân vật
    int Npc_x = 36;
    int Npc_Y = 18;
    int speed = 2;

    public GamePanel(){
        this.setPreferredSize(new Dimension(Width,Height));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyhandler);
        this.setFocusable(true);
        fps.initialize();
    }
    public void StartGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        while(gameThread != null){    //Vòng loop game update hành động nhân vật
            update();
            fps.calculate();
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){
        if(keyhandler.up == true){
            Npc_Y -= speed;
        }
        else if(keyhandler.down == true){
            Npc_Y += speed;
        }
        else if(keyhandler.right == true){
            Npc_x += speed;
        }
        else if(keyhandler.left == true){
            Npc_x -= speed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.cyan);
        g2.fillOval(Npc_x,Npc_Y,final_size,final_size);
        g2.drawString(fps.getFrameRate(),10,10);
        g2.dispose();
    }
}
/*@Override
public void run(){
    double drawinterval = 1_000_000_000.0 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;

    while(gameThread!=null){
        currentTime = System.nanoTime();
        delta += (currentTime-lastTime) / drawinterval;
        lastTime = currentTime;
        if(delta >= 1){
            update();
            repaint();
            delta--;
        }
        else
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
Sử dụng delta accumulator
*/

