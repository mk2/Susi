package net.kuroichigo.bb.susi.model;

public final class Reply implements Bookmarkable {

	private final String m_name;

	private final String m_date;

	private final String m_IDAndBE;

	private final String m_comment;

	public Reply(String m_name, String m_date, String m_IDAndBE,
			String m_comment) {
		super();
		this.m_name = m_name;
		this.m_date = m_date;
		this.m_IDAndBE = m_IDAndBE;
		this.m_comment = m_comment;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_date() {
		return m_date;
	}

	public String getM_IDAndBE() {
		return m_IDAndBE;
	}

	public String getM_comment() {
		return m_comment;
	}

	public boolean bookmark() {
		// TODO Auto-generated method stub
		return false;
	}

}
