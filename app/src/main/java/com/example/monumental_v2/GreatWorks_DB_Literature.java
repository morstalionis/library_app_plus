package com.example.monumental_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class GreatWorks_DB_Literature extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Literature.db";
    private static final int  DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "LiteratureList";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "book_title";
    private static final String COLUMN_AUTHOR = "book_author";
    private static final String COLUMN_YEAR = "book_year";
    private static final String COLUMN_EXCERPT = "book_excerpt";

    GreatWorks_DB_Literature(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_YEAR + " TEXT, " +
                COLUMN_EXCERPT + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addlit(String book_title, String book_author, String book_year, String book_excerpt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, book_title);
        cv.put(COLUMN_AUTHOR, book_author);
        cv.put(COLUMN_YEAR, book_year);
        cv.put(COLUMN_EXCERPT, book_excerpt);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Add Entry Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String title, String author, String year, String excerpt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv_update = new ContentValues();
        cv_update.put(COLUMN_TITLE, title);
        cv_update.put(COLUMN_AUTHOR, author);
        cv_update.put(COLUMN_YEAR, year);
        cv_update.put(COLUMN_EXCERPT, excerpt);

        long result = db.update(TABLE_NAME, cv_update, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteItem(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Delete!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }
}
