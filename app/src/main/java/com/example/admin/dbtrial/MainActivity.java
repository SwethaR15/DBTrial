package com.example.admin.dbtrial;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextInputEditText b1,b2;
    String user,pw;
    Button lg;
    Button rt;
    boolean value=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
         b1=(TextInputEditText)findViewById(R.id.un);
         b2=(TextInputEditText)findViewById(R.id.pd);
         rt=(Button)findViewById(R.id.rtr);
        Button lg=(Button)findViewById(R.id.lng);

       lg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(b1.getText()!=null&&b2.getText()!=null){
                   user=b1.getText().toString().trim();
                   pw=b2.getText().toString().trim();
                   value=true;

               }
               if(value) {
                   ExampleDB db = new ExampleDB(getApplicationContext());
                   db.sendValuesTODB(user,pw);

               }
Intent i=new Intent(MainActivity.this,Main3Activity.class);
               startActivity(i);


           }
       });
rt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);

    }
});



    }
}

