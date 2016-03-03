package question2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagrammeUDP_Envoyer {

	final static int BUFFER_SIZE = 1000;
	final static int PORT = 1500;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Programme \"envoyer message\"");
		
		byte[] buffer = new byte[BUFFER_SIZE];
		buffer = "Message test à envoyer".getBytes();
	
		DatagramSocket socket = new DatagramSocket();
		InetAddress adr = InetAddress.getLocalHost();
		
		
		DatagramPacket dataPacket = new DatagramPacket(buffer, buffer.length, adr, PORT);
		socket.send(dataPacket);
		
		socket.close();
	}
}
