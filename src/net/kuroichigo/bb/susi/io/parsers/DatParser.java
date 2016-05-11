package net.kuroichigo.bb.susi.io.parsers;

public final class DatParser {

	// 名前<>E-mail<>日付とIDとBE<>本文<>スレッドタイトル
	// 名前<>E-mail<>日付とIDとBE<>本文<>
	// 名 </b>fusianasan.2ch.net<b>前<>E-mail<>日付とIDとBE<>本文<>
	// 名前 </b>◆ozOtJW9BFA <b><>E-mail<>日付とIDとBE<>本文<>
	// キャップ ★<>E-mail<>日付とIDとBE<>本文<>
	// 名前 </b>◆ozOtJW9BFA <b>＠キャップ ★<>E-mail<>日付とIDとBE<>本文<>
	// あぼーん<>あぼーん<>あぼーん<>あぼーん<>あぼーん
	// ...

	// 名前<>メール欄<>日付、ID<>本文<>スレタイトル(1行目のみ存在する)\n

	// datは2008年現在、
	// 1行目が、
	// 名前<>メール欄<>年/月/日（曜） 時:分:秒.下二桁（無い板もある） ID:hogehoge0<> 本文 <>スレタイ
	// 2行目以降が、
	// 名前<>メール欄<>年/月/日（曜） 時:分:秒.下二桁（無い板もある） ID:hogehoge0<> 本文 <>

	public static void parse(String rawTEXT) {

	}

}
