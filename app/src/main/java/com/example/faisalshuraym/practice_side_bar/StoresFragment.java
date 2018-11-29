package com.example.faisalshuraym.practice_side_bar;

/*
Author: Faisal Shuraym

 */

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

public class StoresFragment extends Fragment {

    ListView listViewStores;
    List<Store> storeList;
    FirebaseDatabase database;
    DatabaseReference databaseStores;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //initialize layout for view
        View view = inflater.inflate(R.layout.fragment_stores, container, false);

        //firebase database initialize
        database = FirebaseDatabase.getInstance();
        databaseStores = database.getReference("Stores");

        //matching listview from layout.
        listViewStores = (ListView) view.findViewById(R.id.listView);

        //storelist initialize
        storeList = new ArrayList<>();

        //Firebase Data change Listener.
        databaseStores.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                storeList.clear();

                //Get value from firebase.
                for (DataSnapshot storeSnapshot : dataSnapshot.getChildren()){
                    Store store = storeSnapshot.getValue(Store.class);
                    storeList.add(store);
                }
                StoreList adapter = new StoreList(getActivity(), storeList);

                //set Listview Value from firebase data.
                listViewStores.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value


            }

        });

        return view;



    }
}
