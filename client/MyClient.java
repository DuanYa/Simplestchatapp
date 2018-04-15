package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class MyClient {

	public static String msg1;
	public static String address1;

	public void startConnection(String address) throws UnknownHostException, IOException {

		// TODO

	}

	public void sendMessage(String address, String msg) throws InterruptedException {
		address1 = address;
		msg1 = msg;
		Tsen tsen = new Tsen();
		tsen.start();
		tsen.join();
		tsen = null;

	}

	public void addFriendRequest(String name) throws SQLException, InterruptedException {

		address1 = start.Main.sql.getFriendAddress(name);
		Tadd add = new Tadd();
		add.start();
		add.join();

	}

	class Tadd extends Thread {
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				Socket socket;
				socket = new Socket(address1, 17691);

				pw = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.write("1" + start.Main.SEPARATOR + start.Main.myUserName);
			pw.flush();
			pw.close();

		}
	}

	class Tsen extends Thread {

		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				Socket socket;
				socket = new Socket(address1, 17691);

				pw = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.write("0" + start.Main.SEPARATOR + start.Main.myUserName + start.Main.SEPARATOR + msg1);
			pw.flush();
			pw.close();
		}

	}

}
