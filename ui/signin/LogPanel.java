package ui.signin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogPanel extends JPanel implements ActionListener {

	Icon img0 = new ImageIcon("image/denglu.gif");
	JButton button1 = new JButton("确定");
	JButton button2 = new JButton("取消");
	JTextField usernameField = new JTextField();
	JPasswordField passWordField = new JPasswordField();
	JLabel l1 = new JLabel("用户名：");
	JLabel l2 = new JLabel("密  码：");

	public LogPanel() {

		this.setLayout(null);

		l1.setBounds(160, 140, 60, 20);
		this.add(l1);
		l2.setBounds(160, 170, 60, 20);
		this.add(l2);
		button1.setBounds(180, 200, img0.getIconWidth(), img0.getIconHeight());
		this.add(button1);
		button2.setBounds(290, 200, img0.getIconWidth(), img0.getIconHeight());
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
				if (!start.Main.sql.isUserExist(usernameField.getText())) {
					try {

						start.Main.sql.logIn(usernameField.getText(), String.valueOf(passWordField.getPassword()));

					} catch (SQLException e1) {

						// TODO Auto-generated catch block

						e1.printStackTrace();

					}
					JOptionPane.showMessageDialog(null, "注册成功!", "", JOptionPane.INFORMATION_MESSAGE);
					start.Main.logframe.dispose();
					start.Main.startSignFrame();

				} else {

					JOptionPane.showMessageDialog(null, "", "该用户名已经存在！", JOptionPane.ERROR_MESSAGE);

				}
			} catch (ClassNotFoundException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();
			} catch (SQLException e1) {

				// TODO Auto-generated catch block

				e1.printStackTrace();
			}

		} else if (e.getSource() == button2) {

			start.Main.logframe.dispose();
			start.Main.startSignFrame();

		}

	}

}