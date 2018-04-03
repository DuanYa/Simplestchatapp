package ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener, ActionListener {

	public static String thisFriend = null;

	String[] friendList;
	JList jlist;
	String myName = start.Main.myUserName;
	JLabel label = new JLabel(myName);
	JButton addf = new JButton("ÃÌº”∫√”—");

	public MainPanel() throws SQLException {

		friendList = start.Main.sql.getFriendList(start.Main.myUserName);
		jlist = new JList(friendList);
		this.setLayout(null);
		jlist.setBounds(0, 100, 400, 700);
		this.add(jlist);
		label.setBounds(20, 20, 100, 40);
		this.add(label);
		addf.setBounds(250, 70, 100, 20);
		this.add(addf);

		jlist.addMouseListener(this);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
			try {
				try {
					thisFriend = jlist.getSelectedValue().toString();
					if (start.Main.dialogframe == null) {
						start.Main.startDialogFrame(thisFriend);
					} else {
						start.Main.dialogframe.dispose();
						start.Main.startDialogFrame(thisFriend);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == addf) {
			JOptionPane.showInputDialog(addf, "aaa");
		}

	}

}
