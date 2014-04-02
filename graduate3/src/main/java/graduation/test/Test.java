package graduation.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	private String a = "a";

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Pattern p = Pattern.compile("/(\\w*)\\.htm");
		Matcher m = p.matcher("/a.html/b.html");
		while (m.find()) {
			System.out.println(m.group(m.groupCount()));
		}
	}
}