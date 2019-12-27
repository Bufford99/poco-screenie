/**
 * Source: http://android-er.blogspot.com/2012/07/gridview-loading-photos-from-sd-card.html
 */
package com.raiyumi.pocoscreenie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PICK_IMAGE_MULTIPLE = 1;

    Button chooseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseImage = findViewById(R.id.button_chooseImage);
        chooseImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // choose image button is clicked
        if (v == chooseImage) {
           Intent intent = new Intent();
           intent.setType("image/*");

           intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // allow multiple images to be selected
           intent.setAction(Intent.ACTION_GET_CONTENT);

           startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_MULTIPLE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        try {
            // Images picked
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && data != null) {
                Toast.makeText(this, "Image picker worked!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
