package com.example.admin.dbtrial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class
ExampleDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sample_db";
    private static final String TABLE_NAME = "LoginDetails";

     public static final String NAME = "USER_NAME";
     public static final String PASSWORD = "PASSWORD";

   public ExampleDB(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "("
                + NAME + " TEXT,"
                + PASSWORD + " TEXT"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public void sendValuesTODB(String user,String pw) {

       SQLiteDatabase sqLiteDatabase =getWritableDatabase();


                ContentValues contentValues = new ContentValues();
                contentValues.put(NAME, user);
                contentValues.put(PASSWORD, pw);

                sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            }

  /*  public int login(String user, String pw) {
        SQLiteDatabase a = getReadableDatabase();
        Cursor cr = a.rawQuery("select * from " + TABLE_NAME + "where" + NAME + "=" + user + "and" + PASSWORD + "=" + pw + "", null);
        cr.moveToFirst();
        int count = 0;
        if (cr != null) {
            count = cr.getCount();
            return count;
        }


        return count;
    }*/



    public ArrayList<String> getRetrive() {
        ArrayList arr1 = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                arr1.add(cursor.getString(0));
                arr1.add(cursor.getString(1));
                cursor.moveToNext();
            }
        }

        return arr1;
    }
}

