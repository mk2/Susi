package net.kuroichigo.bb.susi.ui.component;

import net.kuroichigo.bb.susi.model.BoardCategory;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;

public class BoardCategoryLabelField extends LabelField {

	private String m_title;

	private BoardCategory m_boardCategory;

	private int m_nBoards;

	private int m_foregroundColor;

	private int m_backgroundColor;

	public BoardCategoryLabelField(BoardCategory m_cassetteCategory,
			int m_foregroundColor, int m_backgroundColor) {
		super(m_cassetteCategory.getM_title(), Manager.NON_FOCUSABLE);
		this.m_title = m_cassetteCategory.getM_title();
		;
		this.m_nBoards = m_cassetteCategory.getNCassettes();
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
		graphics.drawText(m_title + "(" + m_nBoards + ")", 0, 0);
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public BoardCategory getM_boardCategory() {
		return m_boardCategory;
	}

	public void setM_boardCategory(BoardCategory m_boardCategory) {
		this.m_boardCategory = m_boardCategory;
	}

	public int getM_nBoards() {
		return m_nBoards;
	}

	public void setM_nBoards(int m_nBoards) {
		this.m_nBoards = m_nBoards;
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
