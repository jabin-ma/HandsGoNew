package com.soyomaker.handsgo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class AppPrefrence {

	private static final String SHOW_NUMBER_KEY = "SHOW_NUMBER";

	private static final String SHOW_COORDINATE_KEY = "SHOW_COORDINATE";

	private static final String AUTO_NEXT_KEY = "AUTO_NEXT";

	private static final String LAZI_SOUND_STRING_KEY = "LAZY_SOUND";

	private static final String AUTO_NEXT_INTERVAL_KEY = "AUTO_NEXT_INTERVAL";

	private static final String CHESS_BOARD_COLOR_KEY = "CHESS_BOARD_COLOR";

	private static final String CHESS_PIECE_STYLE_KEY = "CHESS_PIECE_STYLE";

	private static final String APP_TIPS_VERSION_KEY = "APP_TIPS_VERSION";

	private static final String APP_TIPS_HIDE_KEY = "APP_TIPS_HIDE";

	private static final String CHESS_SOURCE_KEY = "CHESS_SOURCE";

	private static int sBoardColor = -1;

	private static int sPieceStyle = -1;

	public static final void saveChessSource(Context context, int chessSource) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putInt(CHESS_SOURCE_KEY, chessSource);
		editor.commit();
	}

	public static final int getChessSource(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getInt(CHESS_SOURCE_KEY, 0);
	}

	public static final void saveAppTipsVersion(Context context, int tipsVersion) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putInt(APP_TIPS_VERSION_KEY, tipsVersion);
		editor.commit();
	}

	public static final int getAppTipsVersion(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getInt(APP_TIPS_VERSION_KEY, 0);
	}

	public static final void saveAppTipsHide(Context context, boolean hide) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putBoolean(APP_TIPS_HIDE_KEY, hide);
		editor.commit();
	}

	public static final boolean getAppTipsHide(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getBoolean(APP_TIPS_HIDE_KEY, false);
	}

	public static final void saveChessPieceStyle(Context context, int style) {
		sPieceStyle = style;

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putInt(CHESS_PIECE_STYLE_KEY, style);
		editor.commit();

	}

	public static final int getChessPieceStyle(Context context) {
		if (sPieceStyle == -1) {
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
			sPieceStyle = preferences.getInt(CHESS_PIECE_STYLE_KEY,
					AppConstants.DEFAULT_PIECE_STYLE);
		}
		return sPieceStyle;
	}

	/**
	 * 设置棋盘颜色
	 * 
	 * @param context
	 * @param color
	 */
	public static final void saveChessBoardColor(Context context, int color) {
		sBoardColor = color;

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putInt(CHESS_BOARD_COLOR_KEY, color);
		editor.commit();
	}

	/**
	 * 获取棋盘颜色
	 * 
	 * @param context
	 * @return
	 */
	public static final int getChessBoardColor(Context context) {
		if (sBoardColor == -1) {
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
			sBoardColor = preferences.getInt(CHESS_BOARD_COLOR_KEY,
					AppConstants.DEFAULT_BOARD_COLOR);
		}
		return sBoardColor;
	}

	public static void saveLazySound(Context context, boolean lazySound) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putBoolean(LAZI_SOUND_STRING_KEY, lazySound);
		editor.commit();
	}

	public static boolean getLazySound(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getBoolean(LAZI_SOUND_STRING_KEY, false);
	}

	public static void saveAutoNextInterval(Context context, String autoNextInterval) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putString(AUTO_NEXT_INTERVAL_KEY, autoNextInterval);
		editor.commit();
	}

	public static String getAutoNextInterval(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getString(AUTO_NEXT_INTERVAL_KEY, "2000");
	}

	public static void saveAutoNext(Context context, boolean autoNext) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putBoolean(AUTO_NEXT_KEY, autoNext);
		editor.commit();
	}

	public static boolean getAutoNext(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getBoolean(AUTO_NEXT_KEY, false);
	}

	public static void saveShowNumber(Context context, boolean showNumber) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putBoolean(SHOW_NUMBER_KEY, showNumber);
		editor.commit();
	}

	public static boolean getShowNumber(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getBoolean(SHOW_NUMBER_KEY, false);
	}

	public static void saveShowCoordinate(Context context, boolean showCoordinate) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = preferences.edit();
		editor.putBoolean(SHOW_COORDINATE_KEY, showCoordinate);
		editor.commit();
	}

	public static boolean getShowCoordinate(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getBoolean(SHOW_COORDINATE_KEY, false);
	}
}