package com.hgsil.android.telephonedirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameHolder>{
    private ArrayList<String> names;
    private ArrayList<String> phonenumbers;
    private int count;
    private static int position;
    MyRecyclerItemClickListener myRecyclerItemClickListener;

    NameAdapter(ArrayList<String> names,ArrayList<String> phonenumber,int count){
        this.names=names;
        this.phonenumbers=phonenumber;
        this.count = count;
    }
    public NameAdapter.NameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NameHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nameitem,parent,false)
        ,myRecyclerItemClickListener);
    }
    public void onBindViewHolder(NameAdapter.NameHolder holder, int position) {
        holder.name.setText("用户名"+"    "+String.valueOf(names.get(position)));
        holder.phonenumber.setText("电话号码"+"    "+String.valueOf(phonenumbers.get(position)));

    }
    public int getItemCount() {
        return count;
    }
    public void setOnItemClickListener(MyRecyclerItemClickListener listener){
        this.myRecyclerItemClickListener = listener;
    }


    class NameHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView phonenumber;
        TextView call;
        private MyRecyclerItemClickListener myRecyclerItemClickListener;

        public NameHolder(View itemView,MyRecyclerItemClickListener myRecyclerItemClickListener) {
            super(itemView);
            this.myRecyclerItemClickListener = myRecyclerItemClickListener;
            name = (TextView)itemView.findViewById(R.id.name);
            phonenumber =(TextView)itemView.findViewById(R.id.phonenumberinNameItem);
            call =(TextView)itemView.findViewById(R.id.call);
            itemView.setOnClickListener(this);
            position++;

        }


        @Override
        public void onClick(View v) {
            if(myRecyclerItemClickListener != null){
                myRecyclerItemClickListener.onItemClick(itemView,position);
            }
        }
    }
}

