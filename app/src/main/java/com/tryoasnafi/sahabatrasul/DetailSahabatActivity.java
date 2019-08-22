package com.tryoasnafi.sahabatrasul;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailSahabatActivity extends AppCompatActivity {
    ImageView photo;
    TextView nameTxt, shortDescriptionTxt, descriptionTxt, bornTxt, diedTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_sahabat);

        photo = findViewById(R.id.img_item_photo);
        nameTxt = findViewById(R.id.tv_item_name);
        shortDescriptionTxt = findViewById(R.id.tv_item_short_description);
        descriptionTxt = findViewById(R.id.tv_item_description);
        bornTxt = findViewById(R.id.tv_item_born);
        diedTxt = findViewById(R.id.tv_item_died);

        //DAPETIN INTENT
        Intent i = this.getIntent();

        String images = i.getExtras().getString("IMAGES_KEY");
        String name = i.getExtras().getString("NAME_KEY");
        String shortDescription = i.getExtras().getString("SHORT_KEY");
        String description = i.getExtras().getString("DESCRIPTION_KEY");
        String born = i.getExtras().getString("BORN_KEY");
        String died = i.getExtras().getString("DIED_KEY");

        photo.setImageURI(Uri.parse(images));
        nameTxt.setText(name);
        shortDescriptionTxt.setText(shortDescription);
        descriptionTxt.setText(description);
        bornTxt.setText(born);
        diedTxt.setText(died);

        Glide.with(this)
                .load(images)
                .apply(new RequestOptions().override(150, 150))
                .into(photo);

    }
}
