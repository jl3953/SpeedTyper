package SpeedTyper;

public class Timer {

    private long startTime;
    private long endTime;
    private int elapsed; //elapsed time in seconds

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    
    public int[] calculateMinSec() {
        this.elapsed = (int) (this.endTime - this.startTime) / 1000;
        int min = this.elapsed / 60;
        int sec = this.elapsed % 60;
        return new int[]{min, sec};
    }

    public float getTimeMinutes() {
        return this.elapsed / (float) 60;
    }
}

