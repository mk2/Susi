package net.kuroichigo.bb.susi.support;

import net.kuroichigo.bb.susi.i18n.SuSiResource;
import net.rim.device.api.i18n.MissingResourceException;
import net.rim.device.api.i18n.ResourceBundle;

public final class ResourceSupporter {

	private ResourceBundle m_res;

	private static ResourceSupporter m_resSup;

	private ResourceSupporter() {
		m_res = ResourceBundle.getBundle(SuSiResource.BUNDLE_ID,
				SuSiResource.BUNDLE_NAME);
	}

	synchronized public static ResourceSupporter getInstance() {
		if (m_resSup == null) {
			m_resSup = new ResourceSupporter();
		}
		return m_resSup;
	}

	public String getString(int key) {
		String retStr = "";
		try {
			retStr = m_res.getString(key);
		} catch (MissingResourceException mre) {
			mre.printStackTrace();
		}
		return retStr;
	}

	public ResourceBundle getBundle() {
		return m_res;
	}

}
