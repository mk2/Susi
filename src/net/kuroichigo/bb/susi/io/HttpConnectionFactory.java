package net.kuroichigo.bb.susi.io;

import javax.microedition.io.HttpConnection;

import net.rim.device.api.io.transport.ConnectionDescriptor;
import net.rim.device.api.io.transport.ConnectionFactory;

public final class HttpConnectionFactory {

	/**
	 * Enabled connection types
	 */
	public static int[] preferedConnectionTypes = {};

	/**
	 * Disabled connection types
	 */
	public static int[] disallowedConnectionTypes = {};

	public static HttpConnection getHttpConnection(String url) {
		HttpConnection httpc = null;
		ConnectionFactory cf = new ConnectionFactory();
		cf.setTimeLimit(30000L);
		ConnectionDescriptor cd = cf.getConnection(url);
		if (cd != null) {
			httpc = (HttpConnection) cd.getConnection();
		}
		return httpc;
	}

}
