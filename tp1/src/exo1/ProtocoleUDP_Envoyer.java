package exo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProtocoleUDP_Envoyer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		byte[] buffer = new byte[1000];
		buffer = "166d77ac1b46a1ec38aa35ab7e628ab5 Thibault Coilliaux feat. Mathieu Saab".getBytes();
		//166d77ac1b46a1ec38aa35ab7e628ab5		
		try {
			
			DatagramSocket socket = new DatagramSocket();
			InetAddress adr = InetAddress.getByName("172.18.12.126");
			
			DatagramPacket dataPacket = new DatagramPacket(buffer, buffer.length,adr,1500);
			socket.send(dataPacket);
			
			socket.close();
			
		} catch(IOException s) {
			s.printStackTrace();
		}
	}

}
