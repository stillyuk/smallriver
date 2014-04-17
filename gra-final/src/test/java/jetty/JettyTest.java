package jetty;

import org.eclipse.jetty.server.Server;
import org.junit.Test;

public class JettyTest {

	@Test
	public void testJetty() {
		Server server = new Server();
		try {
			server.start();
		} catch (Exception e) {
		}
	}
}
