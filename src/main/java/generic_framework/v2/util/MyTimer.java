package generic_framework.v2.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

    private final Timer t = new Timer();

    public TimerTask schedule(final Runnable r, Date firstTime, long period) {
        final TimerTask task = new TimerTask() {
            public void run() {
                r.run();
            }
        };
        t.schedule(task, firstTime, period);
        return task;
    }

}