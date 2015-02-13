package udptimeserver;
import java.net.*;
import java.io.*;

/**
 *
 * @author petersodborgchristensen
 */
public class Clientnew {
    
    public static void main(String args[]) throws SocketException, UnknownHostException, IOException{
        
        System.out.println("Server Time...");
        
        DatagramSocket sc = new DatagramSocket();
        
        InetAddress ip = InetAddress.getByName("localhost");
        
        byte[] rd = new byte[100];
        byte[] sd = new byte[100];
        
        DatagramPacket sp = new DatagramPacket(sd,sd.length, ip, 1234);
        DatagramPacket rp = new DatagramPacket(rd,rd.length);
        
        sc.send(sp);
        sc.receive(rp);
        
        String time = new String(rp.getData());
        System.out.println(time);
        
        sc.close();
        
        
    }
    
}
