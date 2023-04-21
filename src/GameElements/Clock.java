package GameElements;

public class Clock {
    private long startTime;
    private long tick;

    public Clock() {
        reset();
    }

    public void reset() {
        startTime = currentTime();
        tick();
    }

    public long currentTime() {
        return System.nanoTime() - startTime;
    }

    public long tick() {
        long sinceLastTick = currentTime() - tick;
        tick = currentTime();
        return sinceLastTick;
    }

    public long tick(int maxFrameRate) {
        double nanosPerFrame = 1000000000.0 / maxFrameRate;
        long nanosElapsed = currentTime() - tick;
        if(nanosElapsed < nanosPerFrame)
            delay((long)((nanosPerFrame-nanosElapsed)/1000000));
        return tick();
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
