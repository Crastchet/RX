package exo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class TchatReception extends Thread {
	private MulticastSocket server;
	
	public TchatReception(MulticastSocket srv) {
		this.server = srv;
	}
	
	
	public void run() {
		byte[] buffer = new byte[4000];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		String str;
		
		while(true) {
			try {
				server.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			str = new String(packet.getData());
			System.out.println("Message de " + packet.getAddress() + " : " + str);
		}
	}
}
