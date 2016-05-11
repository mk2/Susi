package net.kuroichigo.bb.susi;

import net.kuroichigo.bb.susi.support.ModelSupporter;
import net.kuroichigo.bb.susi.support.ResourceSupporter;
import net.kuroichigo.bb.susi.ui.BoardCategoryScreen;
import net.rim.device.api.ui.UiApplication;

/**
 * This class extends the UiApplication class, providing a graphical user
 * interface.
 */
public class SuSi extends UiApplication {

	private ModelSupporter m_modelSupporter;

	private ResourceSupporter m_resourceSupporter;

	/**
	 * Entry point for application
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 */
	public static void main(String[] args) {
		// Create a new instance of the application and make the currently
		// running thread the application's event dispatch thread.
		SuSi theApp = new SuSi();
		theApp.enterEventDispatcher();
	}

	/**
	 * Creates a new SuSi object
	 */
	public SuSi() {
		m_modelSupporter = ModelSupporter.getInstance();
		m_resourceSupporter = ResourceSupporter.getInstance();
		// Push a screen onto the UI stack for rendering.
		pushScreen(new BoardCategoryScreen());
	}

	public ModelSupporter getM_modelSupporter() {
		return m_modelSupporter;
	}

	public ResourceSupporter getM_resourceSupporter() {
		return m_resourceSupporter;
	}
}
