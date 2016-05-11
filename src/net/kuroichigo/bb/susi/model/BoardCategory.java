package net.kuroichigo.bb.susi.model;

import java.util.Vector;

public final class BoardCategory {

	private String m_title;

	private Vector m_boards;

	public BoardCategory() {
		m_title = "";
		m_boards = new Vector();
	}

	public BoardCategory(String m_title) {
		this();
		this.m_title = m_title;
	}

	public boolean hasCassettes() {
		return (m_boards.size() > 0) ? true : false;
	}

	public int getNCassettes() {
		return m_boards.size();
	}

	public Board getCassetteAt(int index) {
		return (Board) m_boards.elementAt(index);
	}

	public void addCassette(Board board) {
		m_boards.addElement(board);
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

}
