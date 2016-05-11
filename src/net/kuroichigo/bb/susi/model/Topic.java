package net.kuroichigo.bb.susi.model;

import java.util.Vector;

/**
 * Tape like "thread in online bulletin board system".
 * 
 * @author yuki
 * 
 */
public final class Topic implements Bookmarkable {

	private String m_key;

	private String m_title;

	private int m_length;

	private Vector m_replies;

	public Topic(String m_key, String m_title, int m_length) {
		super();
		this.m_key = m_key;
		this.m_title = m_title;
		this.m_length = m_length;
	}

	public String getM_key() {
		return m_key;
	}

	public void setM_key(String m_key) {
		this.m_key = m_key;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public int getM_length() {
		return m_length;
	}

	public void setM_length(int m_length) {
		this.m_length = m_length;
	}

	public Vector getM_replies() {
		return m_replies;
	}

	public void setM_replies(Vector m_replies) {
		this.m_replies = m_replies;
	}

	public boolean bookmark() {
		// TODO Auto-generated method stub
		return false;
	}

}
