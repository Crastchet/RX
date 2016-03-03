package exo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class MulticastUDP_Recevoir {

    public static int port = 7654;
 
    public static void main(String[] args) {
 
    	while (true) {
    		try {
 
    			MulticastSocket server = new MulticastSocket(port);
 
    			byte[] buffer = new byte[8192];
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	            InetAddress add = InetAddress.getByName("224.0.0.1");
	            server.joinGroup(add);
	            server.receive(packet);
	 
	            String str = new String(packet.getData());
	            System.out.print("Reçu de la part de " + packet.getAddress() + " sur le port " + packet.getPort() + " : ");
	            System.out.println(str);
	            packet.setLength(buffer.length);
	 
	            server.leaveGroup(add);
	 
	            } catch (SocketException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
    	}
    }
}