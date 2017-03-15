package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {

	static final int PORT = 8020;
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;

	public void listen() {

		try {
			serverSocket = new ServerSocket(PORT);

		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try{
				clientSocket = serverSocket.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			new MessageThread(clientSocket).start();
		}

	}
}
