package data;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataManage {

	public String getUsedname() {

		// TODO
		return null;
	}

	public String getUsedPassword() {

		// TODO
		return null;
	}

	public List<String> loadChatHistory(String friendName) throws IOException {

		File file = new File("C:\\chatapp\\chathistory\\" + start.Main.myUserName + "&" + friendName + ".txt");
		List<String> history = new ArrayList<String>();

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		long fileLength = rf.length();
		long pos = fileLength - 1;
		while (pos > 0) {
			int count = 0;
			pos--;
			rf.seek(pos);
			if (rf.readByte() == '\n') {
				history.add(rf.readLine());
				count++;
			}
			if (count == 15) {

				break;

			}

		}

		return history;

	}

	public void addLocalHistory(String name, String msg, boolean isSend) throws IOException {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String text;
		File file = new File("C:\\chatapp\\chathistory\\" + start.Main.myUserName + "&" + name + ".txt");
		if (isSend) {
			text = start.Main.myUserName + ":      " + dateFormat.format(calendar.getTime()).toString() + "\n" + msg
					+ "\n\n";
		} else {
			text = name + ":      " + dateFormat.format(calendar.getTime()).toString() + "\n" + msg + "\n\n";
		}

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.seek(rf.length());
		rf.writeChars(text);

	}

}
