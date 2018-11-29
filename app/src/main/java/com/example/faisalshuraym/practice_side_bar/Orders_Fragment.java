/*
Author: Faisal Shuraym

 */

package com.example.faisalshuraym.practice_side_bar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Orders_Fragment extends Fragment {

    ListView listViewOrders;
    List<Order> orderList;
    FirebaseDatabase database;
    DatabaseReference databaseOrders;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //initialize layout for view
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        //firebase database initialize

        database = FirebaseDatabase.getInstance();
        databaseOrders = database.getReference("Orders");

        //matching listview from layout.
        listViewOrders = (ListView) view.findViewById(R.id.listView);
        //orderlist initialize
        orderList = new ArrayList<>();

        //Firebase Data change Listener.
        databaseOrders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                orderList.clear();

                //Get value from firebase.
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()){
                    Order order = orderSnapshot.getValue(Order.class);
                    orderList.add(order);
                }
                OrderList adapter = new OrderList(getActivity(), orderList);
                listViewOrders.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value


            }

        });

        return view;

    }


    @Override
    public void onStart() {
        super.onStart();


    }
}
