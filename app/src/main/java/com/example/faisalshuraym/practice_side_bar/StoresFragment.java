package com.example.faisalshuraym.practice_side_bar;

/*
Author: Faisal Shuraym

 */

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StoresFragment extends Fragment{

    ListView listViewStores;
    List<Store> storeList;
    FirebaseDatabase database;
    DatabaseReference databaseStores;
    double latitude,longitude = 0;
    Location locationResult = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //initialize layout for view
        View view = inflater.inflate(R.layout.fragment_stores, container, false);
        Activity act = this.getActivity();


        //firebase database initialize
        database = FirebaseDatabase.getInstance();
        databaseStores = database.getReference("Stores");
        

        //matching listview from layout.
        listViewStores = (ListView) view.findViewById(R.id.listView);

        //storelist initialize
        storeList = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        String url ="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=30.83334,-83.28032&radius=1500&type=restaurant&key=APIKEYHERE";
        

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            StoreList adapter = new StoreList(getActivity(), storeList);
                            TextView text = getView().findViewById(R.id.test_Response);
                            JSONArray results = response.getJSONArray("results");
                            String s = "";
                            for(int i = 0; i < results.length(); i++){
                                JSONObject obj = (JSONObject)results.get(i);
                                Store store = new Store(""+i,obj.getString("name"));
                                storeList.add(store);
                            }
                            listViewStores.setAdapter(adapter);
                        }
                        catch(JSONException e){
                            TextView text = getView().findViewById(R.id.test_Response);
                            text.setText("JSON ERROR");
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TextView text = getView().findViewById(R.id.test_Response);
                        text.setText("JSON ERROR");
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);


        return view;



    }
}
