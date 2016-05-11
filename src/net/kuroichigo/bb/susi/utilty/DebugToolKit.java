package net.kuroichigo.bb.susi.utilty;

import net.rim.device.api.system.EventLogger;

public final class DebugToolKit {

	private static long ID = 0x0328097401L;

	private static void makeLog(String msg, int level) {
		// You can also manipulate logs here, e.g.
		// -add the Class and/or Application name
		// -truncate or remove repeat logs, etc

		// Log to phone event log
		EventLogger.logEvent(ID, msg.getBytes(), level);

		// In the debugger log to the console
		System.err.println(msg);
	}

	public static void debug(String msg) {
		makeLog(msg, EventLogger.DEBUG_INFO);
	}

	public static void warning(String msg) {
		makeLog(msg, EventLogger.WARNING);
	}

}
