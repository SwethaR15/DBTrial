package com.example.admin.dbtrial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.admin.dbtrial.ExampleDB.NAME;
import static com.example.admin.dbtrial.ExampleDB.PASSWORD;

public class Main2Activity extends AppCompatActivity {



    TextView t1;
    TextView t2;
    ArrayList<String> arrayList;
    public  static  final  String MSG_KEY="MSG_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        arrayList = new ArrayList<>();
        ExampleDB db=new ExampleDB(getApplicationContext());
                 arrayList =  db.getRetrive();
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);

      String USER_NAME= arrayList.get(0);

      String  PASSWORD = arrayList.get(1);
      t1.setText(USER_NAME);
      t2.setText(PASSWORD);

            }

}
