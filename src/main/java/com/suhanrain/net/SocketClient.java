package com.suhanrain.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket a =new Socket("127.0.0.1",9090);
            PrintWriter out=new PrintWriter(new OutputStreamWriter(a.getOutputStream(),"UTF-8"),true);
            Scanner socketin=new Scanner(a.getInputStream());
            Scanner scan=new Scanner(System.in);
            while (true) {
                if (scan.hasNextLine()) {
                    String ac=scan.nextLine();
                    System.out.println(ac);
                    out.println(ac);
                }
                if(socketin.hasNextLine()){
                    System.out.println(socketin.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
