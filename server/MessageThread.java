package server;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

public class MessageThread extends Thread {

	Socket socket = null;

	public MessageThread(Socket clientSocket) {
		this.socket = clientSocket;
	}

	@Override
	public void run() {

		InputStream in = null;
		ObjectInput ser = null;

		try {
			in = socket.getInputStream();
			ser = new ObjectInputStream(in);

			Message message = null;

			while (true) {
				message = (Message) ser.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
