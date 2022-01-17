package com.example.blackboard.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<ArrayList<Integer>>> matrix;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        matrix = new MutableLiveData<>();
    }

    //getter and setter
    public MutableLiveData<ArrayList<ArrayList<Integer>>> getMatrix() {
        return matrix;
    }
    public void setMatrix(MutableLiveData<ArrayList<ArrayList<Integer>>> matrix) {
        this.matrix = matrix;
    }
}
