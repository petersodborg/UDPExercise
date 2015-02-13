package udptimeserver;
import java.net.*;
import java.io.*;
import java.util.Date;
/**
 *
 * @author petersodborgchristensen
 */
public class UDPTimeServer {
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        DatagramSocket ss = new DatagramSocket(1234);
        
        while(true){
            System.out.println("Server kører....");
            
            byte[] rd = new byte[100];
            byte[] sd = new byte[100];
            
            DatagramPacket rp = new DatagramPacket(rd,sd.length);
            
            ss.receive(rp);
            
            InetAddress ip = rp.getAddress();
            
            int port = rp.getPort();
            
            Date d = new Date();
            
            String time = d + "";
            
            sd=time.getBytes();
            
            DatagramPacket sp=new DatagramPacket(sd,sd.length,ip,port);
 
            ss.send(sp);            
            rp=null;
            
            System.out.println("Done..!!");
        }
        
    }
    
}
