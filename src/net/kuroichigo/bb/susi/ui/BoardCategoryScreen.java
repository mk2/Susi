package net.kuroichigo.bb.susi.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.microedition.io.HttpConnection;

import net.kuroichigo.bb.susi.i18n.SuSiResource;
import net.kuroichigo.bb.susi.io.HttpConnectionFactory;
import net.kuroichigo.bb.susi.model.Board;
import net.kuroichigo.bb.susi.model.BoardCategory;
import net.kuroichigo.bb.susi.support.ModelSupporter;
import net.kuroichigo.bb.susi.ui.component.BoardLabelField;
import net.kuroichigo.bb.susi.ui.component.BoardCategoryLabelField;
import net.kuroichigo.bb.susi.ui.component.SuSiMainScreen;
import net.rim.device.api.i18n.ResourceBundle;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class BoardCategoryScreen extends SuSiMainScreen {

	class UpdateBoardCategoriesMenuItem extends MenuItem {

		public UpdateBoardCategoriesMenuItem(ResourceBundle bundle, int id,
				int ordinal, int priority) {
			super(bundle, id, ordinal, priority);
		}

		public void run() {
			try {
				updateBoardCategories();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				Dialog.inform("UnsupportedEncodingException");
			} catch (IOException e) {
				e.printStackTrace();
				Dialog.inform("IOException");
			}
		}
	}

	private MenuItem m_updateBoardListMenuItem;

	public BoardCategoryScreen() {
		super();
		setTitle(m_resSup.getString(SuSiResource.BOARD_CATEGORY_SCREEN_TITLE));
		buildComponent();
		buildScreen();
	}

	private void buildComponent() {
		m_updateBoardListMenuItem = new UpdateBoardCategoriesMenuItem(
				m_resSup.getBundle(),
				SuSiResource.BOARD_CATEGORY_SCREEN_MENUITEM_UPDATE, 0x00010001,
				0);
	}

	private void buildScreen() {
		addMenuItem(m_updateBoardListMenuItem);
	}

	protected void updateBoardCategories() throws UnsupportedEncodingException,
			IOException {
		ModelSupporter modelSupporter = m_susiApp.getM_modelSupporter();
		StringBuffer sb = new StringBuffer();
		HttpConnection httpc = HttpConnectionFactory.getHttpConnection(m_resSup
				.getString(SuSiResource.DEFAULT_BBSMENU_URL));
		InputStreamReader isr = new InputStreamReader(httpc.openInputStream(),
				m_resSup.getString(SuSiResource.DEFAULT_JA_ENCODING));
		char[] charBuf = new char[256];
		int code = 0;
		do {
			code = isr.read(charBuf);
			sb.append(charBuf);
		} while (code != -1);
		String rawHTML = sb.toString();
		modelSupporter.updateBoardCategories(rawHTML);
		Vector boardCategories = modelSupporter.obtainBoardCategories();
		if (boardCategories.size() > 0) {
			Manager mainManager = getMainManager();
			for (int i = 0; i < boardCategories.size(); i++) {
				BoardCategory cc = (BoardCategory) boardCategories.elementAt(i);
				VerticalFieldManager vfm = new VerticalFieldManager();
				LabelField cclf = new BoardCategoryLabelField(cc, 0x00000000,
						0x00FFFFFF);
				vfm.add(cclf);
				if (cc.hasCassettes()) {
					for (int j = 0; j < cc.getNCassettes(); j++) {
						Board c = (Board) cc.getCassetteAt(j);
						final LabelField clf = new BoardLabelField(c,
								0x00000000, 0x00FFFFFF);
						vfm.add(clf);
					}
				}
				mainManager.add(vfm);
			}
		}
	}

}
