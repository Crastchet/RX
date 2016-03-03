package question1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagrammeUDP_Recuperer {

	final static int BUFFER_SIZE = 1000;
	final static int PORT = 1500;
		

	public static void main(String[] args) throws IOException {
		
		System.out.println("Programme \"récupérer message\"");
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		DatagramSocket socket = new DatagramSocket(PORT);
		DatagramPacket dataPacket = new DatagramPacket(buffer, BUFFER_SIZE);
		
		socket.receive(dataPacket);
		socket.close();
		
		System.out.println(new String(dataPacket.getData()));

	}

}
