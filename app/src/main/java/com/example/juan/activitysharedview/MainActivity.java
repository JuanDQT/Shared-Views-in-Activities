package com.example.juan.activitysharedview;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Bitmap temp;
    ImageView imageView;
    //Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Transition trans = new Explode();
        getWindow().setEnterTransition(trans);

        Transition returnTrans = new Slide();
        returnTrans.setDuration(2000);
        ((Slide)returnTrans).setSlideEdge(Gravity.LEFT);
        getWindow().setReturnTransition(returnTrans);
        getWindow().setAllowReturnTransitionOverlap(true);

        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.fuchsiaView);

        //
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Toast.makeText(MainActivity.this, "sape?", Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap(bitmap);
                temp = bitmap;

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(MainActivity.this, "no sape", Toast.LENGTH_SHORT).show();
                System.out.println("ERRORRRR "+errorDrawable);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Toast.makeText(MainActivity.this, "preparame esta", Toast.LENGTH_SHORT).show();

            }
        };
        //

        Picasso.with(this).load("https://pbs.twimg.com/profile_images/663008783552024576/UBkDHlz7.jpg").into(target);
        imageView.setTag(target);

        //imageView.setImageResource(R.mipmap.ic_launcher);


        final TextView redTextView = (TextView) findViewById(R.id.redTextView);
        final ImageView fuchsiaTextView = (ImageView) findViewById(R.id.fuchsiaView);
        //final TextView fuchsiaTextView = (TextView) findViewById(R.id.fuchsiaView);
        redTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this, new Pair(fuchsiaTextView, "fuchsiaView"),
                        new Pair(redTextView, "redView"));
                Intent intent = new Intent(MainActivity.this, SecondPe.class);

                intent.putExtra("img", temp);
                startActivity(intent, options.toBundle());
            }
        });
    }
}
