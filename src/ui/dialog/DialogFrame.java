package ui.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import client.MyClient;

public class DialogFrame extends JFrame implements ActionListener {

	private String Address;

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension dim = tk.getScreenSize();
	int width = 700;
	int height = 600;
	int x = dim.width - width >> 1;
	int y = (dim.height - height >> 1) + 30;

	public JTextArea historyText = new JTextArea(1, 1);
	JScrollPane sp = new JScrollPane(historyText);
	JTextArea myText = new JTextArea(5, 5);
	JScrollPane mp = new JScrollPane(myText);
	JButton bt1 = new JButton("Çå³ý");
	JButton bt2 = new JButton("·¢ËÍ");
	MyClient mc;

	public DialogFrame(String friendName) throws UnknownHostException, IOException, SQLException {

		historyText.setEditable(false);
		historyText.setVisible(true);
		historyText.setLineWrap(true);
		historyText.setWrapStyleWord(true);

		myText.setEditable(true);
		myText.setVisible(true);
		myText.setLineWrap(true);
		myText.setWrapStyleWord(true);

		this.setLayout(null);
		sp.setBounds(10, 10, 670, 300);
		mp.setBounds(10, 320, 670, 200);
		DialogPanel dp = new DialogPanel();
		dp.setBounds(10, 525, 670, 30);
		dp.add(bt1);
		dp.add(bt2);

		bt1.addActionListener(this);
		bt2.addActionListener(this);

		this.add(dp);
		this.add(sp);
		this.add(mp);
		this.setTitle(friendName);
		this.setSize(width, height);
		this.setVisible(true);
		this.setLocation(x, y);

		initHistory();

		Address = start.Main.sql.getFriendAddress(friendName);
		mc = new MyClient();

	}

	public void init(String friendName) throws SQLException, UnknownHostException, IOException {

		mc.startConnection(Address);
		// TODO
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bt1) {

			myText.setText("");

			System.out.println(start.Main.dialogframe.getTitle());
			// TODO
		} else if (e.getSource() == bt2) {

			try {

				mc.sendMessage(start.Main.sql.getFriendAddress(this.getTitle()), myText.getText());
				start.Main.datamanage.addLocalHistory(this.getTitle(),
						new String(myText.getText().getBytes("GBK"), "UTF-8"), true);
				initHistory();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			myText.setText("");

		}

	}

	public void initHistory() throws IOException {

		List<String> history = start.Main.datamanage.loadChatHistory(this.getTitle());

		for (int i = history.size() - 1; i > 0; i--) {

			historyText.append(history.get(i));
			historyText.append("\n");

		}
	}

}
