package com.takmallsport.takmallsportvisitorsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.change;

import java.util.ArrayList;

/**
 * Created by sahand on 4/28/18.
 */

public class reportAdapter extends RecyclerView.Adapter<reportAdapter.ViewHolder> {

    ArrayList<change> values;
    Context context;
    private onClickListener mOnClickListener;

    public reportAdapter(ArrayList<change> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_report , parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        change change = values.get(position);

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView_delete;
        TextView textView_report;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView_delete = itemView.findViewById(R.id.cardView_delete);
            textView_report = itemView.findViewById(R.id.textView_report);
            cardView_delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickListener.Click(view , getAdapterPosition() , getItemViewType());
        }
    }

    public void SetOnclickListener(onClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public interface  onClickListener {
        void Click(View view , int Position, int ViewType);
    }
}
