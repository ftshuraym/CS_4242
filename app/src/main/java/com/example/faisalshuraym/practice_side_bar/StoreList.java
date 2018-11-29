package com.example.faisalshuraym.practice_side_bar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StoreList extends ArrayAdapter<Store> {

    private Activity context;
    private List<Store> storeList;

    public StoreList(Activity context, List<Store> storeList){
        super(context, R.layout.list_layout, storeList);
        this.context = context;
        this.storeList = storeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        Store store = storeList.get(position);
        textViewName.setText(store.getStoreName());
        textViewId.setText(store.getStoreId());
        return listViewItem;
    }
}
