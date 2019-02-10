package np.com.ashok.contactformglideandrecyclerview;

//We created this adapter to embbed the content of layout_listitem to the RecyclerView

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

//<Adapter Type>

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    //Log for Debugging
    private static final String TAG = "RecyclerViewAdapter";


    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    //ALT + INSERT to create constructer

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


        //LayoutInflater is used to manipulate Android screen using predefined XML layouts.
        // This class is used to instantiate layout XML file into its corresponding View objects.
        // It is never used directly.


        // This method is responsible for inflating the view...

        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        //Important
        //Change based on our layout

//        This method is going to be called whenever a new item is added
        Log.d(TAG, "onBindViewHolder: CALLED");



        Glide.with(mContext) //Takes the context
                .asBitmap()  //Tells glide that it is a bitmap
                .load(mImages.get(position))    //Loading the image
                .into(viewHolder.image);    //into the imageview

        viewHolder.imageName.setText(mImageNames.get(position));

        //Setting onClickListner

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on "+mImageNames.get(position));
                Toast.makeText(mContext, "Clicked on "+mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {

        //Must do this

        return mImageNames.size();
    }

    //ViewHolder Holds the View


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);




        }
    }


}
