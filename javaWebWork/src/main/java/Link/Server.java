package Link;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(8080);
        Scanner scanner=new Scanner(System.in);){
//TCP连接
            System.out.println("等待客户端连接");
            Socket socket=serverSocket.accept();//客户端没有连接，进程阻塞等待连接，连接成功返回socket
            System.out.println("客户端已连接,ip:"+socket.getInetAddress().getHostAddress());
            socket.setSoTimeout(3000);
//数据接收
        while (true){
            System.out.println("读取客户端数据");
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            System.out.println("数据接收成功");


//数据传输
            System.out.println("请输入需要传输数据...");
            OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());
            writer.write(scanner.nextLine()+"\n");
            writer.flush();
            System.out.println("数据传输成功");

        }

//关闭TCP
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
