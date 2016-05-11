package net.kuroichigo.bb.susi.ui.component;

import net.kuroichigo.bb.susi.model.Topic;
import net.kuroichigo.bb.susi.ui.TopicScreen;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;

public final class TopicLabelField extends LabelField {

	private String m_title;

	private String m_key;

	private int m_length;

	private Topic m_topic;

	private int m_foregroundColor;

	private int m_backgroundColor;

	public TopicLabelField(Topic m_topic) {
		super(m_topic.getM_title(), Manager.FOCUSABLE);
		this.m_title = m_topic.getM_title();
		this.m_key = m_topic.getM_key();
		this.m_length = m_topic.getM_length();
		this.m_topic = m_topic;
	}

	// @Override
	protected void layout(int width, int height) {
		setExtent(width, Font.getDefault().getHeight());
	}

	// @Override
	protected void paint(Graphics graphics) {
		graphics.drawText(m_title + "(" + m_length + ")", 0, 0);
	}

	public int getM_length() {
		return m_length;
	}

	public void setM_length(int m_length) {
		this.m_length = m_length;
	}

	// @Override
	protected boolean navigationClick(int status, int time) {
		UiApplication.getUiApplication().pushScreen(new TopicScreen(m_topic));
		return true;
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

	public String getM_key() {
		return m_key;
	}

	public void setM_key(String m_key) {
		this.m_key = m_key;
	}

	public Topic getM_topic() {
		return m_topic;
	}

	public void setM_topic(Topic m_topic) {
		this.m_topic = m_topic;
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
