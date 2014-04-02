package graduation.core;

/**
 * @author jiangyukun
 * @since 2014-03-13
 */
public class ContextProvider {
	private static Context context;

	public static Context getContext() {
		return context;
	}

	public static void setContext(Context context) {
		ContextProvider.context = context;
	}
}
