package com.acsx73391.my_project.WelcomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acsx73391.my_project.R;

public class MainActivity extends AppCompatActivity {

    public ViewPager mSlideViewPager;
    public LinearLayout mDotLayout;
    public Slide_Adapter sliderAdapter;

    public Button mNextbtn;
    public Button mBackbtn;
    public Button mSignbtn;

    public TextView[] mDots;

    public int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.mDotLayout);

        mNextbtn = findViewById(R.id.btn);
        mBackbtn = findViewById(R.id.btp);
        mSignbtn = findViewById(R.id.bts);

        sliderAdapter = new Slide_Adapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }

        });
        mBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
                if (mCurrentPage == 2){
                    mNextbtn.setText("Finish");
                }
            }
        });
        mSignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.acsx73391.my_project.FirebaseAccount.Main2Activity.class));
            }
        });


    }   public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i =0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (i == 0) {
                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(false);
                mBackbtn.setVisibility(View.INVISIBLE);
                mNextbtn.setText("Next");
                mBackbtn.setText("");
                mSignbtn.setVisibility(View.INVISIBLE);

            } else if (i == mDots.length -1) {

                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(true);
                mBackbtn.setVisibility(View.VISIBLE);
                mNextbtn.setText("Finish");
                mBackbtn.setText("Back");
                mNextbtn.setVisibility(View.INVISIBLE);
                mSignbtn.setVisibility(View.VISIBLE);

            }else {
                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(true);
                mBackbtn.setVisibility(View.VISIBLE);
                mNextbtn.setText("Next");
                mBackbtn.setText("Back ");
                mNextbtn.setVisibility(View.VISIBLE);
                mSignbtn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
