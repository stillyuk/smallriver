package cn.zucc.graduation.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author jiangyukun
 * @since 2014-05-10 15:56
 */
public class SystemDateFormat {
	public static DateFormat getSimpleDateFormat() {
		return new SimpleDateFormat("yyyy年MM月dd日");
	}
}
