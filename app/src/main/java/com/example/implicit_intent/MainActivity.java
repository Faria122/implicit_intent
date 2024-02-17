package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1_cam;
    Button b2_con;
    Button b3_bro;
    Button b4_gal;
    Button b5_di;
    EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1_cam = findViewById(R.id.b1_camera);
        b2_con = findViewById(R.id.b2_contact);
        b3_bro = findViewById(R.id.b3_browse);
        b4_gal = findViewById(R.id.b4_gallery);
        b5_di = findViewById(R.id.b5_dial);
        data = findViewById(R.id.etText_data);
//----Camera Section
       b1_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent();
                // ii.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                ii.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(ii);

            }
        });
        // longclick e new task hbe - event handling
        /*b1_cam.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent ii = new Intent();
                // ii.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                ii.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivity(ii);
                Toast.makeText(getApplicationContext(),"I am long click",Toast.LENGTH_LONG).show();
                return false;

            }
        });

    // event handling
        b1_cam.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Toast.makeText(getApplicationContext(),"Dont Touch",Toast.LENGTH_LONG).show();


                return false;
            }
        });*/



        //----Contact Section
        b2_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("content://contacts/people/"));  // uri likhte hbe- shb mbl e same
                startActivity(ii);

            }
        });
   // Gallery
        b4_gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("content://media/external/images/media/"));  // uri likhte hbe- shb mbl e same

                startActivity(ii);

            }
        });


        // Browser
        b3_bro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);

                String url = data.getText().toString();
                ii.setData(Uri.parse("http://www."+url));

                startActivity(Intent.createChooser(ii,"Title"));

            }
        });

        // Dial pad
        b5_di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);

                String url = data.getText().toString();
                ii.setData(Uri.parse("tel:"+url));

                startActivity(ii);

            }
        });















    }
}