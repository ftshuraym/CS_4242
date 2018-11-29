/*
Author: Faisal Shuraym

 */

package com.example.faisalshuraym.practice_side_bar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Orders_Fragment extends Fragment {

    static ArrayList<String> ListOfItems;
    private static final String TAG = "Orders_Fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_orders, container, false);

    }

    // Here are the place that i want you to create object of like orders example of order is (2 water ,1 milk)
    // you get the idea


}
