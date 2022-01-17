package com.example.blackboard;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;

import java.util.ArrayList;

public class bindingAdapter {
    @BindingAdapter("buildMatrix")
    public static void buildMatrix(View view, ArrayList<ArrayList<Integer>> matrix){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) view.getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.d("TAG001", "build: "+width+"-"+height);

        int column = matrix.get(0).size();
        int row = matrix.size();

    }
}
