package com.example.mygallery;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    Uri imageURI;
    ImageView i, i1;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = (ImageView) findViewById(R.id.pic1);
        i1 =  (ImageView) findViewById(R.id.pic2);
        t = (TextView) findViewById(R.id.urlPic);
    } // end onCreate()

    public void openGallery(View v){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    } // end openGallery()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            i.setImageURI(imageURI);
            t.setText(imageURI.toString());
            i1.setImageURI(Uri.parse(imageURI.toString()));
        } // end if
    } // end onActivityResult()
} // end MainActivity {}
