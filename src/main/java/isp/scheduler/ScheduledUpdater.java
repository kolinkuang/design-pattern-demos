package isp.scheduler;

import isp.config.Updater;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledUpdater {

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final long initialDelayInSeconds;
    private final long periodInSeconds;
    private final Updater updater;

    public ScheduledUpdater(Updater updater, long initialDelayInSeconds, long periodInSeconds) {
        this.updater = updater;
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
    }

    public void run() {
        executor.scheduleAtFixedRate(updater::update, this.initialDelayInSeconds, this.periodInSeconds, TimeUnit.SECONDS);
    }

}
