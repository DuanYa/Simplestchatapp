package ui.signin;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SignFrame extends JFrame {

	/**
	 * 
	 * 
	 * @author Dy
	 */
	private static final long serialVersionUID = 1L;

	public SignFrame() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int width = 600;
		int height = 400;
		int x = dim.width - width >> 1;
		int y = (dim.height - height >> 1) + 30;
		SignPanel Sp = new SignPanel();
		this.add(Sp);
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(x, y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(tk.getImage("image/qq.gif"));
		this.setTitle("µÇÂ¼Ò³Ãæ");

	}

}
