package com.hgsil.android.telephonedirectory;

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
    private ArrayList<String> phonenumber;
    private int count;

    NameAdapter(ArrayList<String> names,ArrayList<String> phonenumber,int count){
        this.names=names;
        this.phonenumber=phonenumber;
        this.count = count;
    }
    public NameAdapter.NameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NameHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nameitem,parent,false));
    }
    public void onBindViewHolder(NameAdapter.NameHolder holder, int position) {
        holder.name.setText("用户名"+"    "+String.valueOf(names.get(position)));
        holder.phonenumber.setText("电话号码"+"    "+String.valueOf(phonenumber.get(position)));

    }
    public int getItemCount() {
        return count;
    }

    class NameHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView phonenumber;
        public NameHolder(View itemView) {
            super(itemView);
            LinearLayout table2 = (LinearLayout) itemView.findViewById(R.id.table2);
            name =(TextView) table2.findViewById(R.id.name);
            phonenumber = (TextView) table2.findViewById(R.id.phonenumberinNameItem);

        }
    }
}

