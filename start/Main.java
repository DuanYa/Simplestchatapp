package start;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import data.DataManage;
import server.MyServer;
import sqloperation.SqlManager;
import ui.dialog.DialogFrame;
import ui.main.MainFrame;
import ui.signin.LogFrame;
import ui.signin.SignFrame;

public class Main {

	public static SqlManager sql;
	public static MyServer myServer;
	public static SignFrame signframe;
	public static MainFrame mainframe;
	public static DialogFrame dialogframe;
	public static String myUserName = null;
	public static LogFrame logframe;
	public static DataManage datamanage;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		sql = new SqlManager();
		myServer = new MyServer();
		datamanage = new DataManage();
		startSignFrame();

	}

	public static void startMainFrame() throws SQLException, IOException {

		mainframe = new MainFrame();

	}

	public static void startDialogFrame(String name) throws UnknownHostException, IOException, SQLException {

		dialogframe = new DialogFrame(name);

	}

	public static void startLogFrame() {

		logframe = new LogFrame();

	}

	public static void startSignFrame() {

		signframe = new SignFrame();

	}

}
