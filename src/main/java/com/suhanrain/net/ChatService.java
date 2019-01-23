package com.suhanrain.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatService {


    public static void main(String[] args) {
        try {
            int i=0;
            List<PrintWriter> list = new ArrayList<>();
            ServerSocket serverSocket = new ServerSocket(9090);
            while (true) {
                Socket a = serverSocket.accept();
                PrintWriter out=new PrintWriter(new OutputStreamWriter(a.getOutputStream(),"UTF-8"),true);
                list.add(out);
                ChatThread run=new ChatThread(a,list);
                run.start();
                System.out.println(String.format("第%d个客户已连接",i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class ChatThread extends Thread {
    private Scanner tin;
    private List<PrintWriter> list;
    public ChatThread(Socket s, List<PrintWriter> list) {
        try {
            tin = new Scanner(s.getInputStream());
            this.list=list;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (tin.hasNextLine()) {
                String text=tin.nextLine();
                System.out.println("匿名发言:" +text);
                for(PrintWriter printWriter:list){
                    printWriter.println("匿名发言:" +text);
                }
            }
        }
    }
}