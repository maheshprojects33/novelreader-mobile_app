package com.java.novelreader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.RecViewHolder> {


    private Context mContext;
    private ArrayList<List_Holder_Class> myArray;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }



    public Recycler_Adapter(ArrayList<List_Holder_Class> myArray, Context mContext) {
        this.myArray = myArray;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample_layout, parent, false);
        return new RecViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        List_Holder_Class current = myArray.get(position);
        holder.icon.setImageResource(current.icon);
        holder.title.setText(current.title);
        holder.author.setText(current.author);
        holder.shortDescription.setText(current.shortDescription);


    }

    @Override
    public int getItemCount() {
        return myArray.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, author;
        private MaterialCardView parent;

        RelativeLayout collapseCV, expandCV;
        ImageView upArrow, downArrow;
        TextView shortDescription;

        public RecViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            icon = itemView.findViewById(R.id.ivThumbnail);
            title = itemView.findViewById(R.id.tvBookTitle);
            author = itemView.findViewById(R.id.tvBookAuthor);
            parent = itemView.findViewById(R.id.parent);

            collapseCV = itemView.findViewById(R.id.collapseCV);
            expandCV = itemView.findViewById(R.id.expandCV);
            upArrow = itemView.findViewById(R.id.ivUpArrow);
            downArrow = itemView.findViewById(R.id.ivDownArrow);
            shortDescription = itemView.findViewById(R.id.tvShortDescription);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expandCV.setVisibility(View.VISIBLE);
                    downArrow.setVisibility(View.INVISIBLE);
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expandCV.setVisibility(View.GONE);
                    downArrow.setVisibility(View.VISIBLE);

                }
            });


            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if( position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });




        }
    }
}
