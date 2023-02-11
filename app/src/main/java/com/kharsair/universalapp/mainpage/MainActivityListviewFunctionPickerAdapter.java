package com.kharsair.universalapp.mainpage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.kharsair.universalapp.R;

import org.w3c.dom.Text;

public class MainActivityListviewFunctionPickerAdapter extends BaseAdapter {

    private FunctionPickerMenuItemHolder[] functionPickerMenuItems;

    private LayoutInflater layoutInflater;

    private Context appContext;

    private static final int LAYOUT_RESOURCE_ID = R.layout.activity_main_function_picker_listview_item;

    public MainActivityListviewFunctionPickerAdapter(Context appContext,
                                                     FunctionPickerMenuItemHolder[] functionPickerMenuItems) {

        layoutInflater = LayoutInflater.from(appContext);

        this.functionPickerMenuItems = functionPickerMenuItems;
        this.appContext = appContext;
    }

    @Override
    public int getCount() {
        return this.functionPickerMenuItems.length;
    }

    @Override
    public FunctionPickerMenuItemHolder getItem(int i) {
        return functionPickerMenuItems[i];
    }

    @Override
    public long getItemId(int i) {
        return functionPickerMenuItems[i].hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        FunctionPickerMenuItemHolder targetFunctionHodler = getItem(i);

        if (view == null) {

            view = layoutInflater.inflate(LAYOUT_RESOURCE_ID,
                    viewGroup, false);

            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.backgroundLayout.setOnClickListener(layoutView -> {
            Intent intent = new Intent(appContext, targetFunctionHodler.targetActivity);
            if (targetFunctionHodler.extras != null) {
                for (String key : targetFunctionHodler.extras.keySet()) {
                    intent.putExtra(key, targetFunctionHodler.extras.get(key));
                }
            }
            appContext.startActivity(intent);
        });

        viewHolder.functionName.setText(targetFunctionHodler.name);
        return view;
    }

    static class ViewHolder {

        TextView functionName;
        LinearLayoutCompat backgroundLayout;
        public ViewHolder(View view) {

            functionName = view.findViewById(R.id.activity_main_function_picker_item_textview_function_name);
            backgroundLayout = view.findViewById(R.id.activity_main_function_picker_item_linear_layout_background);

        }
    }

}
