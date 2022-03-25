package com.example.volleyfeatchdatajsonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myadapter extends RecyclerView.Adapter<myadapter.myViewholder>{
  Datum[] data;
  Context context;

    public myadapter(Datum[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
       Datum datum = data[position];
       holder.tv.setText(datum.getName());
        Glide.with(holder.image.getContext()).load("http://172.18.4.209/android_db_pool/images/"+datum.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myViewholder extends RecyclerView.ViewHolder{
      ImageView image;
      TextView tv;
        public myViewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageholder);
            tv=itemView.findViewById(R.id.theader);

        }
    }
}
