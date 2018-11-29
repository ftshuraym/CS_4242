package com.example.faisalshuraym.practice_side_bar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OrderList extends ArrayAdapter<Order> {

    private Activity context;
    private List<Order> orderList;

    // the contractor for ArrayAdapter
    public OrderList(Activity context, List<Order> orderList){
        super(context, R.layout.list_layout, orderList);
        this.context = context;
        this.orderList = orderList;
    }

    //This is override method from ArrayAdapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //get Listview from layout
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        //get list elements from layout.(orderName and orderID)
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);

        Order order = orderList.get(position);

        //set value in list element
        textViewName.setText(order.getOrderName());
        textViewId.setText(order.getOrderId());
        return listViewItem;
    }
}
