package exo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ProtocoleUDP_Recevoir {
	
	public ProtocoleUDP_Recevoir() {}
		
	
	//http://www.liafa.jussieu.fr/~sighirea/cours/reseauxM/java.udp.html
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[1000];
	
		DatagramSocket socket = new DatagramSocket(1500);
		//socket.connect(adress);
		
		DatagramPacket dataPacket = new DatagramPacket(buffer, buffer.length);
		
		//socket.send(dataPacket);
		
		System.out.println(1);
		socket.receive(dataPacket);
		System.out.println(2);
		socket.close();
		
		
		System.out.println(new String(dataPacket.getData()));
		
	}

}
