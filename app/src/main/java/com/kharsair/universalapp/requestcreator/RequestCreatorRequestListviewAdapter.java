package com.kharsair.universalapp.requestcreator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RequestCreatorRequestListviewAdapter
        extends RecyclerView.Adapter<RequestCreatorRequestListviewAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private LinkedList<RequestItemHolder> existingRequests;


    public RequestCreatorRequestListviewAdapter() {

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (existingRequests == null) return 0;
        return existingRequests.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
