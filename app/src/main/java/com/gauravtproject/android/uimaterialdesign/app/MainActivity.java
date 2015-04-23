package com.gauravtproject.android.uimaterialdesign.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {

    public static SparseArray<Bitmap> sPhotoCache = new SparseArray<Bitmap>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showPhoto(View view){
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);

        switch (view.getId()){
            case R.id.show_photo_1:
                intent.putExtra("lat", 37.6329946);
                intent.putExtra("lng", -122.4938344);
                intent.putExtra("zoom", 14.0f);
                intent.putExtra("title", "Pacifica Pier");
                intent.putExtra("description", getResources().getText(R.string.photo_detail_description));
                intent.putExtra("photo", R.drawable.photo1);
                break;
            case R.id.show_photo_2:
                intent.putExtra("lat", 37.73284);
                intent.putExtra("lng", -122.503065);
                intent.putExtra("zoom", 15.0f);
                intent.putExtra("title", "Pink Flamingo");
                intent.putExtra("description", getResources().getText(R.string.photo_detail_description));
                intent.putExtra("photo", R.drawable.photo2);
                break;
            case R.id.show_photo_3:
                intent.putExtra("lat", 36.861897);
                intent.putExtra("lng", -111.374438);
                intent.putExtra("zoom", 11.0f);
                intent.putExtra("title", "Antelope Canyon");
                intent.putExtra("description", getResources().getText(R.string.photo_detail_description));
                intent.putExtra("photo", R.drawable.photo3);
                break;
            case R.id.show_photo_4:
                intent.putExtra("lat", 36.596125);
                intent.putExtra("lng", -118.1604282);
                intent.putExtra("zoom", 9.0f);
                intent.putExtra("title", "Lone Pine");
                intent.putExtra("description", getResources().getText(R.string.photo_detail_description));
                intent.putExtra("photo", R.drawable.photo4);
                break;
        }

        ImageView imageView = (ImageView) ((View) view.getParent()).findViewById(R.id.photo);

        sPhotoCache.put(intent.getIntExtra("photo", -1),
                ((BitmapDrawable)imageView.getDrawable()).getBitmap());

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, imageView, "photo_here");

        startActivity(intent, options.toBundle());


    }
}
