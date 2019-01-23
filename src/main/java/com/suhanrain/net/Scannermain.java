package com.suhanrain.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Scannermain {
    public static void main(String[] args) {
        getAllAddress("www.baidu.com");
        try {
            ServerSocket seo=new ServerSocket(9090);
            Socket a=seo.accept();
            Scanner scanner=new Scanner(a.getInputStream());
            PrintWriter out=new PrintWriter(new OutputStreamWriter(a.getOutputStream(),"UTF-8"),true);
            while(true) {
                if (scanner.hasNextLine()) {
                    System.out.println("Client say:"+scanner.nextLine());
                    out.println("Server said Hello!!!!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getAllAddress(String url){
        try {
            InetAddress[] address=InetAddress.getAllByName(url);
            if(address.length>0){
                for (InetAddress a:address){
                    System.out.println(a);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
