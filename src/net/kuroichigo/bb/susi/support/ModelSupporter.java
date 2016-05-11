package net.kuroichigo.bb.susi.support;

import java.util.Vector;

import net.kuroichigo.bb.susi.io.parsers.BBSMenuHtmlParser;
import net.kuroichigo.bb.susi.model.Board;
import net.kuroichigo.bb.susi.model.BoardCategory;
import net.kuroichigo.bb.susi.model.Bookmarkable;
import net.kuroichigo.bb.susi.model.Topic;

/**
 * support class for models.<br>
 * Use singleton pattern.<br>
 * Rolls<b> holding model variables<br>
 * (near future) data writing/reading ability<br>
 * 
 * @author yuki
 * 
 */
public final class ModelSupporter {

	private static ModelSupporter m_modelSupporter;

	private Vector m_boardCategories;

	private BoardCategory m_currentBoardCategory;

	private Board m_currentBoard;

	private Topic m_currentDiscussion;

	private Vector m_bookmarks;

	private ModelSupporter() {
		m_boardCategories = new Vector();
	}

	synchronized public static ModelSupporter getInstance() {
		if (m_modelSupporter == null) {
			m_modelSupporter = new ModelSupporter();
		}
		return m_modelSupporter;
	}

	public void updateBoardCategories(String rawHTML) {
		m_boardCategories = BBSMenuHtmlParser.parse(rawHTML);
	}

	public Vector obtainBoardCategories() {
		return m_boardCategories;
	}

	public void addBookmark(Bookmarkable bookmark) {
		m_bookmarks.addElement(bookmark);
	}

	public Vector obtainBookmarks() {
		return m_bookmarks;
	}

}
