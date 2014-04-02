package graduation.core;

import java.io.File;

public class FileUtil {
	public static final String PUBLIC_RESOURCE = "C:" + File.separatorChar + "My Project File Dir" + File.separatorChar + "public";
	public static final String FILE_UPLOAD_PATH = "C:" + File.separatorChar + "My Project File Dir";
	public static final String FILE_DOWNLOAD_PATH = "C:" + File.separatorChar + "My Project File Dir";
	public static final String FILE_USER_HOME = "C:" + File.separatorChar + "My Project File Dir";

	public static boolean mkUserDir(String username) {
		File dir = new File(FILE_USER_HOME + File.separatorChar + username);
		if (dir.exists()) {
			return false;
		}
		dir.mkdir();
		return true;
	}
}
