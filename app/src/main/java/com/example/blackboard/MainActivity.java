package com.example.blackboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.blackboard.databinding.ActivityMainBinding;
import com.example.blackboard.viewmodels.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG001";
    private Integer height=null,width=null;
    private float dpX=0f,dpY=0f;
    private ArrayList<ArrayList<Float>> matrix = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();
    private int fx=0,fy=0;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainBinding.setModel(mainActivityViewModel);
        LinearLayout root = mainBinding.linearLayout;
        relativeLayout = mainBinding.relativeLayout;

        Log.d(TAG, "onCreate: raw"+getScreenWidth()+"-"+getScreenHeight());
        Log.d(TAG, "onCreate: dp"+dpWidth()+"-"+dpHeight());




        ((View)root).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        drawLine(x,y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //drawLine(x,y);
                        break;
                }
                ((View)root).invalidate();
                return true;
            }
        });



    }

    private void drawLine(int x, int y) {
        Log.d(TAG, "drawLine: ");
        if (fx==0 && fy==0){
            fx=x;
            fy=y;
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        int X = x-fx;
        int Y = 5;

                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(X,Y));
        linearLayout.setBackgroundColor(Color.RED);
        linearLayout.setY(y);
        relativeLayout.addView(linearLayout);
        relativeLayout.invalidate();
    }

    private void changeBackground(int x ,int y) {


    }




    //getter and setter
    private int getScreenWidth(){
        if (width==null){
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            width = displayMetrics.widthPixels;
        }
        return width;
    }
    private int getScreenHeight(){
        if (height==null){
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            height = displayMetrics.heightPixels;
        }
        return height;
    }
    private float dpHeight(){
        if (dpY==0f){
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics ();
            display.getMetrics(outMetrics);

            float density  = getResources().getDisplayMetrics().density;
            dpY = outMetrics.heightPixels / density;
        }
        return dpY;
    }
    private float dpWidth(){
        if (dpX==0f){
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics ();
            display.getMetrics(outMetrics);

            float density  = getResources().getDisplayMetrics().density;
            dpX = outMetrics.widthPixels / density;
        }
        return dpX;
    }



}