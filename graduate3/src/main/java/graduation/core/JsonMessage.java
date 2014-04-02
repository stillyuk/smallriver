package graduation.core;

/**
 * @author jiangyukun
 * @since 2014-03-27
 */
public class JsonMessage {
	private Object message;

	public JsonMessage() {
	}

	public JsonMessage(Object message) {
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
}
