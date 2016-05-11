package net.kuroichigo.bb.susi.io.parsers;

import java.util.Vector;

import net.kuroichigo.bb.susi.model.Board;
import net.kuroichigo.bb.susi.model.BoardCategory;
import net.kuroichigo.bb.susi.utilty.DebugToolKit;
import net.kuroichigo.bb.susi.utilty.TextUtilities;
import net.rim.device.api.util.StringUtilities;

public final class BBSMenuHtmlParser {

	// <BR><BR><B>カテゴリ名</B><BR>
	// <A HREF=http://server.domain.dom/board/>板の名前</A><br>
	// <A HREF=http://server.domain.dom/board/>板の名前</A><br>
	// ...
	// <A HREF=http://server.domain.dom/board/>板の名前</A>
	//
	// <BR><BR><B>カテゴリ名</B><BR>
	// <A HREF...

	private static String CATEGORY_HEAD_TOKEN = "<BR><BR><B>";

	private static String CAEGORY_LAST_TOKEN = "</B><BR>";

	private static String CASSETTE_HEAD_TOKEN = "<A HREF=";

	private static String CASSETTE_LAST_TOKEN_TYPE1 = "</A><br>";

	private static String CASSETTE_LAST_TOKEN_TYPE2 = "</A>";

	public static Vector parse(String rawHTML) {

		Vector cassetteCategories = new Vector();

		String[] lines = TextUtilities.splitText2Lines(rawHTML);

		BoardCategory currentCategory = null;
		for (int n = 0; n < lines.length; n++) {

			String line = lines[n].trim();

			if (StringUtilities.startsWithIgnoreCase(line, CATEGORY_HEAD_TOKEN)) {
				String titleOfCategory = line.substring(
						CATEGORY_HEAD_TOKEN.length(), line.length()
								- CAEGORY_LAST_TOKEN.length());
				currentCategory = new BoardCategory(titleOfCategory);
				DebugToolKit.warning("current category: " + titleOfCategory);
				cassetteCategories.addElement(currentCategory);
			}

			if (StringUtilities.startsWithIgnoreCase(line, CASSETTE_HEAD_TOKEN)
					&& currentCategory != null) {
				String urlAndTitleOfCassette = null;
				if (line.endsWith(CASSETTE_LAST_TOKEN_TYPE1)) {
					urlAndTitleOfCassette = line.substring(CASSETTE_HEAD_TOKEN.length(),
							line.length() - CASSETTE_LAST_TOKEN_TYPE1.length());
				} else if (line.endsWith(CASSETTE_LAST_TOKEN_TYPE2)) {
					urlAndTitleOfCassette = line.substring(CASSETTE_HEAD_TOKEN.length(),
							line.length() - CASSETTE_LAST_TOKEN_TYPE2.length());
				}
				if (urlAndTitleOfCassette != null) {
					int GTIndex = urlAndTitleOfCassette.indexOf(">");
					String url = urlAndTitleOfCassette.substring(0, GTIndex);
					String title = urlAndTitleOfCassette.substring(GTIndex + 1);
					currentCategory.addCassette(new Board(title, url));
				}
			}
		}

		return cassetteCategories;
	}
}
