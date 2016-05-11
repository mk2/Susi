package net.kuroichigo.bb.susi.model;

import java.util.Vector;

public final class Board implements Bookmarkable {

	private String m_title;

	private String m_url;

	private Vector m_topics;

	public Board(String m_title, String m_url) {
		super();
		this.m_title = m_title;
		this.m_url = m_url;
	}

	public void setM_url(String url) {
		m_url = url;
	}

	public String getM_url() {
		return m_url;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public Vector getM_topics() {
		return m_topics;
	}

	public void setM_topics(Vector m_topics) {
		this.m_topics = m_topics;
	}

	public boolean bookmark() {
		// TODO Auto-generated method stub
		return false;
	}

}
