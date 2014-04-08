package cn.zucc.graduation.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

	private static Properties prop = new Properties();

	static {
		try {
			InputStream is = PropUtil.class.getResourceAsStream("/file.properties");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
