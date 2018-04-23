package com.example.niwesh.recyclerviewapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Niwesh on 4/22/2018.
 */

public class PostUpdateDialog extends Dialog implements View.OnClickListener{

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public Activity activity;
    public Dialog dialog;

    ImageView imgView;
    File f;
    Uri file ;
    String path;
    ImageView imgCamera, imgBrowse;

    public PostUpdateDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.post_update);

        path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/mypicture.jpg";
        imgCamera = (ImageView) findViewById(R.id.post_image_camera);
        imgBrowse = (ImageView) findViewById(R.id.post_image_browse);

        // If we don’t have the appropriate permissions, we disable the camera click until we do.
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            imgCamera.setEnabled(false);
            ActivityCompat.requestPermissions(getOwnerActivity(), new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }

        imgView = (ImageView) findViewById(R.id.post_image);
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public boolean isShowing() {
        return super.isShowing();
    }

    // Check permission of the camera Intent & External Storage
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                imgCamera.setEnabled(true);
            }
        }
    }

    public void camera(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void gallery(View view){
        Intent i = new Intent();
        // Activity Action for the intent : Pick an item from the data, returning what was selected.
        i.setAction(Intent.ACTION_PICK);
        i.setType("image/*");
        // Start the Gallery Intent activity with the request_code 2
        activity.startActivityForResult(i,2);
    }

    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Intent object data automatically store the selected file path from the Image Gallery from your device storage
       //super.onActivityResult(requestCode, resultCode, data);
     //  activity.onActivityResult(requestCode, resultCode, data);
        ImageView iView=(ImageView)findViewById(R.id.post_image);
        // Logic to from specified file path
      /*  if(requestCode==1 && resultCode==RESULT_OK){ // For Clicking Camera button
           // Set the captured image to the ImageView Component
              // iView.setImageURI(Uri.fromFile(f));
               iView.setImageURI(file);
        }*/
        // Logic to get from Bundle
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            iView.setImageBitmap(imageBitmap);
        }
        else if(requestCode==2){ // For Clicking Gallery button
            // Set the selected image from the device image gallery to the ImageView component
            iView.setImageURI(data.getData());
        }

    }
}
