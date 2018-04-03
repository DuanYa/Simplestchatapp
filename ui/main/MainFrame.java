package ui.main;

import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	int width = 400;
	int height = 800;
	Toolkit tk = Toolkit.getDefaultToolkit();
	int x = tk.getScreenSize().width - 500;
	int y = 50;

	public MainFrame() throws SQLException, IOException {

		this.add(new MainPanel());
		this.setVisible(true);
		this.setSize(width, height);
		this.setLocation(x, y);

		Tr1 tr1 = new Tr1();
		tr1.start();

		// TODO Auto-generated constructor stub
	}

	class Tr1 extends Thread {
		@Override
		public void run() {

			try {
				start.Main.myServer.startWork();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
