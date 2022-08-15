package Link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",8080);
             Scanner scanner=new Scanner(System.in)){

            System.out.println("连接服务器成功");
//数据传输
       while (true){
           System.out.println("请输入需要传输数据...");
           OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());
           writer.write(scanner.nextLine()+"\n");
           writer.flush();
           System.out.println("数据传输成功");

//数据接收
           System.out.println("读取服务端端数据");
           BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
           System.out.println(reader.readLine());
           System.out.println("数据接收成功");
       }




        } catch (IOException e) {
            System.out.println("连接服务器失败");
            e.printStackTrace();

        }
    }



}
