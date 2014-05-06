package freemarker;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {
	@Test
	public void testfreemarker() throws Exception {
		Configuration cfg = new Configuration();
		Template template = cfg.getTemplate("mail.ftl");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("t", "t");
//		File file = new File("D:/mail.html");
		StringWriter stringWriter = new StringWriter(); 
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		BufferedWriter out = new BufferedWriter(stringWriter);
		template.process(map, out);
		System.out.println(stringWriter.toString());
//		StringReader reader = new StringReader();
		out.flush();
		out.close();
	}
}