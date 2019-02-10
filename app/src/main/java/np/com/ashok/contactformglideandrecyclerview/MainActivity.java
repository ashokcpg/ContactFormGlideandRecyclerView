package np.com.ashok.contactformglideandrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MainActivity";   //log for debugging

    //vars

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started.");
        initImageBitmaps();
//
//        ImageView imggif = findViewById(R.id.imageGif);
//        //GIF imaGE URL
//
//        String gifURL = "https://i.imgur.com/8tfPGBa.gif";
//
//        Glide.with(this)
//                .load(gifURL)
//                .into(imggif);

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: Preparing Bitmaps");

        mImageUrls.add("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60");
        mNames.add("First Picture");

        mImageUrls.add("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60");
        mNames.add("Second Picture");

        mImageUrls.add("https://images.unsplash.com/photo-1509460913899-515f1df34fea?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60");
        mNames.add("Third Picture");

        mImageUrls.add("https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60");
        mNames.add("Fourth Picture");

        mImageUrls.add("https://images.unsplash.com/photo-1463453091185-61582044d556?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60");
        mNames.add("Fifth Picture");
        initRecyclerView();

    }

    //Method for setting Recycler View
    private void initRecyclerView()
    {
        Log.d(TAG, "initRecyclerView: init RecyclerView");

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrls,this); //Takes parameters to the constructor
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
