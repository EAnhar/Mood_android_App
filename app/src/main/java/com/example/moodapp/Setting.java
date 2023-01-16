package com.example.moodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.cast.framework.media.ImagePicker;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import pub.devrel.easypermissions.EasyPermissions;

public class Setting extends AppCompatActivity {

    Dialog dialog ;
    ImageView profileImage  , profileImageBefore;
    final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        //    Dialogs general lines
        dialog = new Dialog(Setting.this);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT ,ViewGroup.LayoutParams.WRAP_CONTENT);

    }
    // setting dialog initialization
    public void about_Dialog (View view){
        dialog.setContentView(R.layout.dialog_about);
        dialog.show(); // Showing the dialog here
    }
    public void rate_Dialog (View view){
        dialog.setContentView(R.layout.dialog_rate);
        dialog.show(); // Showing the dialog here
    }
    public void terms_Dialog (View view){
        dialog.setContentView(R.layout.dialog_terms);
        dialog.show(); // Showing the dialog here
    }
    public void editProfile_Dialog (View view){
        dialog.setContentView(R.layout.dialog_edit_profile);
        dialog.show(); // Showing the dialog here
    }
    public void logout_dialog(View view) {
        dialog.setContentView(R.layout.dialog_logout);
        dialog.show(); // Showing the dialog here
    }


    // okay and cancel button function
    public void okay_dialog (View view){
//        Toast.makeText(Setting.this, "Okay", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
    public void cancel_dialog (View view){
//        Toast.makeText(Setting.this, "Cancel", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }



    public void Choose_Picture (View view){
        // Assign variables
        profileImage = (ImageView)findViewById(R.id.profileImage) ;
        profileImageBefore = dialog.findViewById(R.id.profileImageBefore) ;

        // pick image from galley
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    // sava new profile image and name
    public void save_Profile_Changes(View view){
        //get the new name
        EditText newName = dialog.findViewById(R.id.newName);
        //to set the new name
        TextView name = (TextView) findViewById(R.id.name);

        //set the new name in profile if a new value entered
        if(newName.getText().toString() != null) {
            name.setText(newName.getText().toString());
        }

        // set the new image in the profile
        profileImage.setImageURI(imageUri);

        Toast.makeText(Setting.this, "Changes saved", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            //show the preview of new image profile before save it
            profileImageBefore.setImageURI(imageUri);
        }
    }
    public void getUserRating (View view){
        //user review
        EditText review = (EditText) findViewById(R.id.feedback);

        //get the value of user rating
        RatingBar ratingbar =  dialog.findViewById(R.id.rating);
        String ratingNum = String.valueOf(ratingbar.getRating()); //the value

        Toast.makeText(Setting.this,"Thank You", Toast.LENGTH_LONG).show();
        dialog.dismiss();
    }
    //confirm the logout and back to start activity
    public void logout(View view){
        // from here to ?
        Intent logout = new Intent(this,MainActivity.class);
        startActivity(logout);
        //// maybe need more function for logout process//////
    }


    //////////////////////not completed /////////////////////
    public void notification_mode(View view) {
        Switch notify = findViewById(R.id.notification_mode);

        if(notify.isChecked()){
            Toast.makeText(Setting.this,"Notification ON", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Setting.this,"Notification OFF", Toast.LENGTH_LONG).show();

        }
    }
}