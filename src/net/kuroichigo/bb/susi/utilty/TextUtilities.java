package net.kuroichigo.bb.susi.utilty;

import java.util.Vector;

public final class TextUtilities {

	/**
	 * Split text with \n code.
	 * 
	 * @param rawText
	 * @return
	 */
	public static String[] splitText2Lines(String rawText) {
		Vector linesVector = new Vector();
		int beginIndex = 0;
		int endIndex = rawText.length();
		while (true) {
			endIndex = rawText.indexOf("\n", beginIndex);
			if (endIndex == -1)
				break;
			linesVector.addElement(rawText.substring(beginIndex, endIndex));
			beginIndex = endIndex + 1;
		}
		String[] linesString = new String[linesVector.size()];
		linesVector.copyInto(linesString);
		return linesString;
	}

}
