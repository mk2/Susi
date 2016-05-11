package net.kuroichigo.bb.susi.ui.component;

import net.kuroichigo.bb.susi.SuSi;
import net.kuroichigo.bb.susi.support.ResourceSupporter;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;

public abstract class SuSiMainScreen extends MainScreen {

	protected SuSi m_susiApp;

	protected ResourceSupporter m_resSup;

	public SuSiMainScreen() {
		super();
		m_susiApp = (SuSi) UiApplication.getUiApplication();
		m_resSup = m_susiApp.getM_resourceSupporter();
	}

}
