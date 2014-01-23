package com.danilov.thequest.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Utils {
	
	public static final String APP_TAG = "[The Quest]: ";
	
	public static void Log(final String message) {
		System.out.println(APP_TAG + message);
	}
	
	public static boolean isTableExistInDB(final SQLiteDatabase database, final String tableName) {
		if (tableName == null || database == null || !database.isOpen()) {
	        return false;
	    }
	    Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[] {"table", tableName});
	    if (!cursor.moveToFirst()) {
	        return false;
	    }
	    int count = cursor.getInt(0);
	    cursor.close();
	    return count > 0;
	}

}
