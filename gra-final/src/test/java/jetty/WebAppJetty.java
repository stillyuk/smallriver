package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebAppJetty {
	public static void main(String[] args) throws Exception {
		Server server = new Server(80);
		WebAppContext app = new WebAppContext("src/main/webapp", "/gra");
		server.setHandler(app);
		server.start();
	}
}
