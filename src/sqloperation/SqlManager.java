package sqloperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlManager {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://47.94.239.238:3306/chatapp";
	static final String USER = "chatapp";
	static final String PASS = "chatadmin";
	Connection conn = null;
	Statement stmt = null;

	public SqlManager() throws ClassNotFoundException, SQLException {

		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		System.out.println("sql“—æ≠∆Ù∂Ø");

	}

	public boolean isFriendOnline(String name) throws SQLException {

		boolean a = false;
		String sql;
		sql = "SELECT username,isonline FROM chatdata WHERE username=\"" + name + "\"";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int iso = rs.getInt("isonline");
			if (iso == 1) {
				a = true;
			} else {
				a = false;
			}
		}
		return a;

	}

	public String getFriendAddress(String name) throws SQLException {

		String a = null;
		String sql = "SELECT username,myip FROM chatdata WHERE username=\"" + name + "\"";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			a = rs.getString("myip");
		}
		return a;

	}

	public String getPassword(String name) throws SQLException, ClassNotFoundException {

		String a = null;
		String sql = "SELECT username,password FROM chatdata WHERE username=\"" + name + "\"";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			return rs.getString("password");
		}
		return a;

	}

	public void setNewAddress(String name, String address) throws SQLException {

		String sql;
		sql = "UPDATE chatdata SET myip=\"" + address + "\"" + " WHERE username=\"" + name + "\"";
		stmt.executeUpdate(sql);

	}

	public void logIn(String username, String password) throws SQLException {

		String sql;
		sql = "INSERT INTO chatdata (username,password,myip,isonline,friendlist) VALUES (" + "'" + username + "'," + "'"
				+ password + "'," + "'0.0.0.0','0','1') ";
		stmt.executeUpdate(sql);

		// TODO
	}

	public String[] getFriendList(String name) throws SQLException {

		String[] list = null;
		String[] nlist = null;
		String sql, sql1;
		String flst = null;
		sql = "SELECT username,friendlist FROM chatdata WHERE username=\"" + name + "\"";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			flst = rs.getString("friendlist");

		}
		list = flst.split(",");
		nlist = new String[list.length];
		for (int i = 0; i < list.length; i++) {
			sql1 = "SELECT id,username FROM chatdata WHERE id=" + list[i];
			ResultSet rs1 = stmt.executeQuery(sql1);
			while (rs1.next()) {
				nlist[i] = rs1.getString("username");
			}

		}

		return nlist;

	}

	public int getFriendNumber() {

		// TODO
		return 0;

	}

	public boolean isUserExist(String name) throws SQLException, ClassNotFoundException {

		boolean a = false;
		String sql;
		sql = "SELECT username FROM chatdata WHERE username=\"" + name + "\"";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String name1 = rs.getString("username");
			if (name1 != null) {
				a = true;
			} else {
				a = false;
			}
		}
		return a;

	}

	public void setOnline(String name) throws SQLException {

		String sql;
		sql = "UPDATE chatdata SET isonline = TRUE WHERE username=\"" + name + "\"";
		stmt.executeUpdate(sql);

	}

	public void setOutline(String name) throws SQLException {

		String sql;
		sql = "UPDATE chatdata SET isonline = FALSE WHERE username=\"" + name + "\"";
		stmt.executeUpdate(sql);

	}

	public void agreeFriendRequest(String name) throws SQLException {

		String sql;
		sql = "SELECT friendlist FROM chatdata WHERE username=\"" + start.Main.myUserName + "\"";
		ResultSet list = stmt.executeQuery(sql);

		System.out.println(name);
		// TODO
	}

}
