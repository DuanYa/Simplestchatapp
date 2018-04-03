package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyServer {

	ServerSocket ssc;

	public MyServer() {

	}

	public void startWork() throws IOException {
		ssc = new ServerSocket(17691);

		System.out.println("服务器开始监听。。。");

		// TODO

		while (true) {
			try {

				Socket socket0 = ssc.accept();

				BufferedReader br = new BufferedReader(new InputStreamReader(socket0.getInputStream()));
				String info = null;
				while ((info = br.readLine()) != null) {

					String[] msg0 = info.split("&&##@@separator@@##&&");
					start.Main.datamanage.addLocalHistory(msg0[0], msg0[1], false);
					if (start.Main.dialogframe != null) {
						start.Main.dialogframe.init(msg0[0]);
					}

				}
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
	}

	public void beingConnected() {

		// TODO
	}

	public void getMessage() {

		// TODO
	}

	public String getMyIp() throws UnknownHostException {

		return InetAddress.getLocalHost().getHostAddress().toString();
		// TUDO
	}

}
