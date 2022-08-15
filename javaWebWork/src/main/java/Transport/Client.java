package Transport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket=new Socket("localhost",8080);){
            FileInputStream fileInputStream=new FileInputStream("secret.txt");//file是从外部获取到程序
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
