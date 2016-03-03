package exo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;

public class MulticastUDP_Envoyer {

	public static int port = 7654;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
    	while (true) {
    		try {
 
    			MulticastSocket server = new MulticastSocket();
 
    			byte[] buffer = new byte[8192];
    			Scanner sc = new Scanner(System.in);
    			buffer = sc.nextLine().getBytes();
	            
	            InetAddress adr = InetAddress.getByName("224.0.0.1");
	            
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,adr,port);
	            //packet.setData(buffer);
	            
	            server.send(packet);
	            
	            server.close();
	            
    		} catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}

	}

}
