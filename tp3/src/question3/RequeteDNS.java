package question3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RequeteDNS {

	final static int BUFFER_SIZE = 1000;
	final static int PORT = 53;
	
	public static void main(String[] args) throws IOException {
		
		byte[] buffer = new byte[BUFFER_SIZE];
		buffer = "nslookup www.facebook.com".getBytes();
		
		DatagramSocket socket = new DatagramSocket();
		InetAddress adr = InetAddress.getByName("8.8.8.8");

		DatagramPacket dataPacket = new DatagramPacket(buffer, buffer.length, adr, PORT);
		socket.send(dataPacket);
		
		socket.close();
	}

}
