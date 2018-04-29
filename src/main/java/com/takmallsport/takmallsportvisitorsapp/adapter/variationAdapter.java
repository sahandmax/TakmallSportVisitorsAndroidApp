package com.takmallsport.takmallsportvisitorsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.variation;

import java.util.ArrayList;

/**
 * Created by sahand on 4/23/18.
 */

public class variationAdapter extends RecyclerView.Adapter<variationAdapter.ViewHolder> {

    ArrayList<variation> values;
    Context context;
    onClickListener mOnClickListener;


    public variationAdapter(ArrayList<variation> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_variation,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        variation variation = values.get(position);
        if (variation.isStock())
            holder.checkBox.setChecked(true);
        else
            holder.checkBox.setChecked(false);

        holder.textView_color.setText(context.getString(R.string.color_is_)
                .replace("%color%" , variation.getColor().getName()));

        holder.textView_size.setText(context.getString(R.string.size_is_)
                .replace("%size%" , variation.getSize().getName()));

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_color;
        TextView textView_size;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            textView_color = itemView.findViewById(R.id.textView_color);
            textView_size = itemView.findViewById(R.id.textView_size);
            checkBox = itemView.findViewById(R.id.checkBox);
            checkBox.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickListener.onClick(view,getAdapterPosition(),getItemViewType());
        }
    }


    public void setOnClickListener (onClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public interface onClickListener {
        void onClick(View view , int position , int viewType);
    }

}
