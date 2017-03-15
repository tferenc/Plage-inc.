package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket client1;
	private ServerSocket client2;
	private Socket client1Socket;
	private Socket client2Socket;

	public Server() {
		try {
			client1 = new ServerSocket(8020);
			client2 = new ServerSocket(8021);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listenClient1() {
		try {
			client1Socket = client1.accept();

			InputStream in = client1Socket.getInputStream();
			ObjectInput serializator = new ObjectInputStream(in);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
