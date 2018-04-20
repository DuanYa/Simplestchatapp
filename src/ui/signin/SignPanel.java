package ui.signin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignPanel extends JPanel implements ActionListener {

	Icon img0 = new ImageIcon("image/denglu.gif");
	Icon img1 = new ImageIcon("image/xiangdao.gif");
	JButton button1 = new JButton(img0);
	JButton button2 = new JButton(img1);
	JTextField usernameField = new JTextField();
	JPasswordField passWordField = new JPasswordField();
	JLabel l1 = new JLabel("用户名：");
	JLabel l2 = new JLabel("密  码：");

	public SignPanel() {

		this.setLayout(null);

		l1.setBounds(160, 140, 60, 20);
		this.add(l1);
		l2.setBounds(160, 170, 60, 20);
		this.add(l2);
		button1.setBounds(180, 200, img0.getIconWidth(), img0.getIconHeight());
		this.add(button1);
		button2.setBounds(290, 200, img1.getIconWidth(), img1.getIconHeight());
		this.add(button2);
		usernameField.setBounds(220, 140, 120, 20);
		this.add(usernameField);
		passWordField.setBounds(220, 170, 120, 20);
		this.add(passWordField);

		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1) {
			try {
				try {
					if (start.Main.sql.isUserExist(usernameField.getText())) {
						if (String.valueOf(passWordField.getPassword())
								.equals(start.Main.sql.getPassword(usernameField.getText()))) {

							System.out.println("successful");
							try {
								start.Main.sql.setNewAddress(usernameField.getText(), start.Main.myServer.getMyIp());
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							start.Main.sql.setOnline(usernameField.getText());
							start.Main.myUserName = usernameField.getText();
							start.Main.signframe.dispose();
							start.Main.startMainFrame();

						} else {
							System.out.println("密码错误！");
						}

					} else {
						JOptionPane.showMessageDialog(null, "", "用户名不存在！", JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == button2) {

			start.Main.signframe.dispose();
			start.Main.startLogFrame();

			// TODO
		}

	}

}
