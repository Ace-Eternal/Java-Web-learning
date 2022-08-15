package Transport;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(8080);) {
            Socket socket=serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress());
            InputStream inputStream=socket.getInputStream();
            while(true){
                int i=inputStream.read();
                if(i==-1){
                    break;
                }
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
