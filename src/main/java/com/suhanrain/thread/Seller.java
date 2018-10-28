package com.suhanrain.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class Seller extends  Thread
{
    public static int ticket=5000;
    private static Logger LOG= LoggerFactory.getLogger(Seller.class);
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                if (ticket > 0) {
                    LOG.info(Thread.currentThread().getName() + "ticket No." + ticket + "selled");
                    ticket--;
                } else
                    break;
            }
        }
    }
}
