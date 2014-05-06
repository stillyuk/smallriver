package cn.zucc.graduation.utils;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtil {
	public static String process(Map<String, Object> map) throws Exception {
		Configuration cfg = new Configuration();
		Template template = cfg.getTemplate("mail.ftl");
		StringWriter stringWriter = new StringWriter();
		BufferedWriter out = new BufferedWriter(stringWriter);
		template.process(map, out);
		return stringWriter.toString();
	}
}