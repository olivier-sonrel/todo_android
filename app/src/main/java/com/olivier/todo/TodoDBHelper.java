package com.olivier.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "todo.db";

    private static final String TODO_KEY = "id";
    private static final String TODO_NAME = "name";
    private static final String TODO_URGENCY = "urgency";

    private static final String TODO_TABLE_NAME = "Todo";

    public static final int TODO_KEY_COLUMN_INDEX = 0;
    public static final int TODO_NAME_COLUMN_INDEX = 1;
    public static final int TODO_URGENCY_COLUMN_INDEX = 2;

    public TodoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
