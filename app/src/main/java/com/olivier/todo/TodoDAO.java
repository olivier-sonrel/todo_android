package com.olivier.todo;

import android.content.Context;
import android.database.Cursor;

public class TodoDAO extends DAO{
    public TodoDAO(Context context){ super(new TodoDBHelper(context));}

    public Todo find(Long id) {
        Todo todo = null;

        Cursor cursor = db.rawQuery("select * from " + TodoDBHelper.TODO_TABLE_NAME +
                " where " + TodoDBHelper.TODO_KEY_COLUMN_INDEX + " = ?",
                new String[] { String.valueOf(id)}
                );
        if(cursor != null && cursor.moveToFirst()){
            todo = new Todo();
            todo.setId(Integer.parseInt(cursor.getString(0)));
            todo.setName(cursor.getString(1));
            todo.setUrgency(cursor.getString(2));

            cursor.close();
        }
        return todo;
    }
}
