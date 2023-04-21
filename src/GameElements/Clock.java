package GameElements;

import java.util.ArrayList;

/**
 * Clock is a time handling class that should be used for consistent game physics.
 * tick() returns the time since its' last call, and tick(int fps) limits the frame rate.
 * framerate() returns the average frame rate based on the previous 10 calls.
 */
public class Clock {
    private long startTime;
    private long tick;
    private final ArrayList<Long> ticks;

    public Clock() {
        ticks = new ArrayList<>();
        reset();
    }

    public void reset() {
        startTime = currentTime();
        ticks.clear();
        tick();
    }

    public long currentTime() {
        return System.nanoTime() - startTime;
    }

    public long tick() {
        // Add the tick time to the storage array ticks
        ticks.add(currentTime()-tick);
        if(ticks.size() > 10)
            ticks.remove(0);
        // Return the tick time, and set tick to currentTime()
        long sinceLastTick = currentTime() - tick;
        tick = currentTime();
        return sinceLastTick;
    }

    public long tick(int maxFrameRate) {
        // Delay until the given frame time, if necessary, then call tick()
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

    public int frameRate() {
        long avg = 0;
        for (long tickTime : ticks)
            avg += (tickTime / ticks.size());
        return (int)(1000000000/avg);
    }
}
