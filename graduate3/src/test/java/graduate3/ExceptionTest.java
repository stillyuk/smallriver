package graduate3;

import org.junit.Test;

public class ExceptionTest {
	@Test
	public void testException() throws Exception {
		StringBuffer s = new StringBuffer("abc");
		System.out.println(s.insert("abc".indexOf('c'), "d").toString());
	}
}
