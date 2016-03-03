package exo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tchat {
	static final int port = 7654;

	public static void main(String[] args) {
		System.out.println("On est parti");
		MulticastSocket server = null;
		InetAddress add = null;
		try {
			add = InetAddress.getByName("224.0.0.1");
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			server = new MulticastSocket(port);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			server.joinGroup(add);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TchatReception reception = new TchatReception(server);
		reception.start();

		byte[] buffer = new byte[4000];
		DatagramPacket packet;
		Scanner sc = new Scanner(System.in);
		
		while(true) { //Envoie
			System.out.println(add.getHostAddress());
			buffer = sc.nextLine().getBytes();
			packet = new DatagramPacket(buffer, buffer.length, add,port);
			packet.setAddress(add);
			try {
				server.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.reset();
		}
	}
	
	

}
