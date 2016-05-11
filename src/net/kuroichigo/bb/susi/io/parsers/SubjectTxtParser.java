package net.kuroichigo.bb.susi.io.parsers;

import java.util.Vector;

import net.kuroichigo.bb.susi.model.Topic;
import net.kuroichigo.bb.susi.utilty.TextUtilities;
import net.rim.device.api.util.StringUtilities;

public final class SubjectTxtParser {

	// 9241103901.dat<>■東北地方太平洋沖地震 (3)
	// 9241103704.dat<>■　現在の電力情況(東電)、節電する? いつまで続く? (13)

	// 0000000000.dat<>スレッドタイトル (レス数)
	// 0000000000.dat<>スレッドタイトル (レス数)
	// ...

	private static String SEPARATOR = "<>";

	public static Vector parse(String rawTEXT) {
		Vector tapes = new Vector();

		String[] lines = TextUtilities.splitText2Lines(rawTEXT);

		for (int i = 0; i < lines.length; i++) {
			String key = "";
			String title = "";
			int length = -1;
			String line = lines[i].trim();
			if (StringUtilities.strEqual(line, "")) {
				continue;
			}

			int keyLastIndex = line.indexOf(SEPARATOR);
			if (keyLastIndex == -1) {
				continue;
			}
			key = line.substring(0, keyLastIndex);

			int leftBraceLastIndex = line.lastIndexOf('(');
			if (leftBraceLastIndex == -1) {
				continue;
			}
			title = line.substring(keyLastIndex + SEPARATOR.length(),
					leftBraceLastIndex);

			length = Integer.parseInt(line.substring(leftBraceLastIndex + 1,
					line.length() - 1));

			tapes.addElement(new Topic(key, title, length));
		}

		return tapes;
	}
}
