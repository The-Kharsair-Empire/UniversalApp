package com.kharsair.universalapp.mainpage;

import java.util.HashMap;

public class FunctionPickerMenuItemHolder {

    public String name;
    public Class<?> targetActivity;

    public HashMap<String, Class<?>> extras;

    public FunctionPickerMenuItemHolder(String name, Class<?> targetActivity, HashMap<String, Class<?>> extras) {
        this.name = name;
        this.targetActivity = targetActivity;
        this.extras = extras;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
