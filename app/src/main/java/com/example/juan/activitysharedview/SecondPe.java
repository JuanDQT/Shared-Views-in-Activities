package com.example.juan.activitysharedview;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SecondPe extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_pe);

        System.out.println("hola?");
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("img");
        System.out.println("hola 2?");


        imageView = (ImageView) findViewById(R.id.fuchsiaView);
        //imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setImageBitmap(bitmap);
        //Picasso.with(this).load("https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS").into(imageView);

    }
}
