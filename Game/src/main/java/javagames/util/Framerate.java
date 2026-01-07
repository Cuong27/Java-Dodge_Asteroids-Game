package javagames.util;

public class Framerate {
    private String FrameRate;
    private long lastTime;
    private long currentTime;
    private int frameCount;
    private long delta;
    public void initialize(){
        FrameRate = "FPS 0";
        lastTime = System.currentTimeMillis();
        delta = 0;
        frameCount = 0;
    }
    public void calculate(){
        currentTime = System.currentTimeMillis();
        delta += currentTime - lastTime;
        lastTime = currentTime;
        frameCount++;
        if(delta > 1000) {
            FrameRate = String.format("FPS %s", frameCount);
            frameCount = 0;
            delta -= 1000;

        }
        }
    public String getFrameRate(){
        return FrameRate;
    }
}
