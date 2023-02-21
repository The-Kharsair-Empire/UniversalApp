package com.kharsair.universalapp.mainpage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kharsair.universalapp.R;

public class MainActivityListviewFunctionPickerAdapter
        extends RecyclerView.Adapter<MainActivityListviewFunctionPickerAdapter.ViewHolder> {

    private final FunctionPickerMenuItemHolder[] functionPickerMenuItems;
    private final LayoutInflater layoutInflater;
    private final Context appContext;

    private static final int LAYOUT_RESOURCE_ID = R.layout.main_function_picker_listview_item;

    public MainActivityListviewFunctionPickerAdapter(Context appContext,
                                                     FunctionPickerMenuItemHolder[] functionPickerMenuItems) {

        layoutInflater = LayoutInflater.from(appContext);

        this.functionPickerMenuItems = functionPickerMenuItems;
        this.appContext = appContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(LAYOUT_RESOURCE_ID,
                parent, false);

        return new MainActivityListviewFunctionPickerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        FunctionPickerMenuItemHolder targetFunctionHolder = functionPickerMenuItems[position];

        viewHolder.backgroundLayout.setOnClickListener(layoutView -> {
            Intent intent = new Intent(appContext, targetFunctionHolder.targetActivity);
            if (targetFunctionHolder.extras != null) {
                for (String key : targetFunctionHolder.extras.keySet()) {
                    intent.putExtra(key, targetFunctionHolder.extras.get(key));
                }
            }
            appContext.startActivity(intent);
        });

        viewHolder.functionName.setText(targetFunctionHolder.name);
    }

    @Override
    public int getItemCount() {
        return this.functionPickerMenuItems.length;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        TextView functionName;
        LinearLayoutCompat backgroundLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            functionName = itemView.findViewById(R.id.activity_main_function_picker_item_textview_function_name);
            backgroundLayout = itemView.findViewById(R.id.activity_main_function_picker_item_linear_layout_background);
        }
    }

}
