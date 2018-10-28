package com.suhanrain.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellTicket {

    private static Logger LOG= LoggerFactory.getLogger(SellTicket.class);
    public static void main(String[] args) {
        new Seller().start();
        new Seller().start();

    }


}
