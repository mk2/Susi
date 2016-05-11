package net.kuroichigo.bb.susi.ui.component;

import net.kuroichigo.bb.susi.model.Board;
import net.kuroichigo.bb.susi.ui.BoardScreen;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;

public class BoardLabelField extends LabelField {

	private String m_title;

	private String m_url;

	private Board m_board;

	private int m_foregroundColor;

	private int m_backgroundColor;

	public BoardLabelField(Board m_board, int m_foregroundColor,
			int m_backgroundColor) {
		super(m_board.getM_title(), Manager.FOCUSABLE);
		this.m_board = m_board;
		this.m_title = m_board.getM_title();
		this.m_url = m_board.getM_url();
		this.m_foregroundColor = m_foregroundColor;
		this.m_backgroundColor = m_backgroundColor;
	}

	// @Override
	protected void layout(int width, int height) {
		setExtent(width, Font.getDefault().getHeight());
	}

	// @Override
	protected void paint(Graphics graphics) {
		graphics.setColor(m_foregroundColor);
		graphics.setBackgroundColor(m_backgroundColor);
		graphics.drawText(m_title, 10, 0);
	}

	// @Override
	protected boolean navigationClick(int status, int time) {
		UiApplication.getUiApplication().pushScreen(new BoardScreen(m_board));
		return super.navigationClick(status, time);
	}

	// @Override
	protected boolean navigationUnclick(int status, int time) {
		return true;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getM_url() {
		return m_url;
	}

	public void setM_url(String m_url) {
		this.m_url = m_url;
	}

	public Board getM_board() {
		return m_board;
	}

	public void setM_board(Board m_board) {
		this.m_board = m_board;
	}

	public int getM_foregroundColor() {
		return m_foregroundColor;
	}

	public void setM_foregroundColor(int m_foregroundColor) {
		this.m_foregroundColor = m_foregroundColor;
	}

	public int getM_backgroundColor() {
		return m_backgroundColor;
	}

	public void setM_backgroundColor(int m_backgroundColor) {
		this.m_backgroundColor = m_backgroundColor;
	}

}
