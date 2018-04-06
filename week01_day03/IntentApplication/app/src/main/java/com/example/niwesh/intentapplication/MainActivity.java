package com.example.niwesh.intentapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    ImageView imageViewCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewCamera = (ImageView) findViewById(R.id.imageViewCamera);

    }

    public void onShare(View view){
        File root = Environment.getExternalStorageDirectory();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(root.getAbsolutePath()+"/DCIM/Camera/img.jpg")));
        startActivity(Intent.createChooser(share,"Share via"));
    }
//    public void dial(View view){
//        Intent i = new Intent();
//        i.setAction(Intent.ACTION_DIAL);
//        EditText et2 = (EditText) findViewById(R.id.tel);
//        i.setData(Uri.parse("tel:"+et2.getText().toString()));
//        startActivity(i);
//    }
    public void camera(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageViewCamera.setImageBitmap(imageBitmap);
        }
    }

    public void viewGallery(View view){
        Intent i = getPackageManager().getLaunchIntentForPackage("com.sec.android.gallery3d");
        startActivity(i);
    }
}
