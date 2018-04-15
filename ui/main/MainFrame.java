package ui.main;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements WindowListener {

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
		this.addWindowListener(this);

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

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {

		try {
			start.Main.sql.setOutline(start.Main.myUserName);

			System.out.println("aaa");

			System.exit(-1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
