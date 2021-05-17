package com.tuu.springboot.util;

/**
 * 由于System.currentTimeMillis()性能问题，缓存当前时间，每100ms更新一次
 */
public enum CachedMillisecondClock {
    //缓存当前时间
    INS;
    // 当前时间
    private volatile long now = 0;

    CachedMillisecondClock() {
        this.now = System.currentTimeMillis() / 100;
        start();
    }

    private void start() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                now = System.currentTimeMillis() / 100;
            }
        }, "CachedMillisecondClockUpdater");
        t.setDaemon(true);
        t.start();
    }

    public long now() {
        return now;
    }

}
