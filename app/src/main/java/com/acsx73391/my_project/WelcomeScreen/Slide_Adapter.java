package com.acsx73391.my_project.WelcomeScreen;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acsx73391.my_project.R;

public class Slide_Adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public Slide_Adapter(Context context){
        this.context = context;
    }
    public int[] slide_image={
            R.drawable.eat,
            R.drawable.code,
            R.drawable.sleep
    };
    public String[] slide_heading = {
            "Welcome to visit here",
            "There are four parts",
            "Final",
    };
    public String[] slide_desc = {
            "this is my  project",
            "1.Use viewpager to change the slide, \n2.Building member system with Firebase, \n3.Building navigationbar to change fragment," +
                    "\n4.Uing recycler view which content is connecting with news api .",
            "thanks"
    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide,container,false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDesc = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDesc.setText(slide_desc[position]);
        container.addView(view);
        return view;
    }
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((RelativeLayout)object);
    }
}
