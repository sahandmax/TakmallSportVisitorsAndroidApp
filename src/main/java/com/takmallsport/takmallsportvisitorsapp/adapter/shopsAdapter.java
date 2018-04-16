package com.takmallsport.takmallsportvisitorsapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.shops;

import java.util.ArrayList;

/**
 * Created by sahand on 4/10/18.
 */

public class shopsAdapter extends RecyclerView.Adapter<shopsAdapter.ViewHolder> {
    ArrayList<shops> shop;
    Context context;
    OnClickListener onClickListener;

    public shopsAdapter(ArrayList<shops> shop, Context context) {
        this.shop = shop;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_shop, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        shops shop = this.shop.get(position);
        holder.textView_shopName.setText(shop.getName());
    }

    @Override
    public int getItemCount() {
        return shop.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_shopName;
        CardView cardview;
        public ViewHolder(View itemView) {
            super(itemView);
            textView_shopName = itemView.findViewById(R.id.textView_shopName);
            cardview = itemView.findViewById(R.id.cardview);
            cardview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(view,getItemViewType(),getAdapterPosition());
        }
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(View view,int ViewType , int AdapterPosition);
    }
}
