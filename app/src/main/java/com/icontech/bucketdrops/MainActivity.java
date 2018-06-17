package com.icontech.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity  {

    Toolbar toolbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDialogadd();

            }
        });


    }

    private void showDialogadd() {
        DialogAdd dialog=new DialogAdd();
        dialog.show(getSupportFragmentManager(),"add");
    }


}
