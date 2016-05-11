package net.kuroichigo.bb.susi.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.microedition.io.HttpConnection;

import net.kuroichigo.bb.susi.i18n.SuSiResource;
import net.kuroichigo.bb.susi.io.HttpConnectionFactory;
import net.kuroichigo.bb.susi.io.parsers.SubjectTxtParser;
import net.kuroichigo.bb.susi.model.Board;
import net.kuroichigo.bb.susi.model.Topic;
import net.kuroichigo.bb.susi.ui.component.SuSiMainScreen;
import net.kuroichigo.bb.susi.ui.component.TopicLabelField;
import net.rim.device.api.compress.GZIPInputStream;
import net.rim.device.api.i18n.ResourceBundle;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;

public final class BoardScreen extends SuSiMainScreen {

	class UpdateBoardMenuItem extends MenuItem {

		public UpdateBoardMenuItem(ResourceBundle bundle, int id, int ordinal,
				int priority) {
			super(bundle, id, ordinal, priority);
		}

		public void run() {
			try {
				updateBoard();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private Board m_board;

	private MenuItem m_updateBoardMenuItem;

	private VerticalFieldManager m_mainVfm;

	public BoardScreen(Board board) {
		super();
		m_board = board;
		buildComponent();
		buildScreen();
	}

	private void buildComponent() {
		m_updateBoardMenuItem = new UpdateBoardMenuItem(m_resSup.getBundle(),
				SuSiResource.BOARD_SCREEN_MENUITEM_UPDATE, 0x00010001, 0);
	}

	private void buildScreen() {
		setTitle(m_resSup.getString(SuSiResource.BOARD_SCREEN_TITLE));
		addMenuItem(m_updateBoardMenuItem);
	}

	protected void updateBoard() throws IOException {
		String url = m_board.getM_url()
				+ m_resSup.getString(SuSiResource.DEFAULT_SUBJECT_TXT);
		HttpConnection httpc = (HttpConnection) HttpConnectionFactory
				.getHttpConnection(url);
		httpc.setRequestProperty("User-Agent", "Monazilla/1.00");
		httpc.setRequestProperty("Accept-Encoding", "gzip");
		httpc.setRequestProperty("Connection", "close");
		InputStreamReader isr = new InputStreamReader(new GZIPInputStream(
				httpc.openInputStream()),
				m_resSup.getString(SuSiResource.DEFAULT_JA_ENCODING));
		StringBuffer sb = new StringBuffer();
		char[] charBuff = new char[256];
		int code = -1;
		do {
			code = isr.read(charBuff);
			sb.append(charBuff);
		} while (code != -1);
		Vector topics = SubjectTxtParser.parse(sb.toString());
		m_board.setM_topics(topics);

		if (topics.size() > 0) {
			m_mainVfm = new VerticalFieldManager();
			getMainManager().add(m_mainVfm);
			for (int i = 0; i < topics.size(); i++) {
				Topic topic = (Topic) topics.elementAt(i);
				LabelField tlf = new TopicLabelField(topic);
				m_mainVfm.add(tlf);
			}
		}
	}

}
