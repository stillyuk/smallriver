package cn.zucc.graduation.service.acount;

public class Level {

	public static int computeLevel(int loginDays) {
		int level = 0;
		for (int i = 0;; i++) {
			if (loginDays >= i * 2 + 5) {
				loginDays -= i * 2 + 5;
				level++;
			} else {
				break;
			}
		}
		return level;
	}

}
