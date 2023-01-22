package com.kharsair.universalapp.mainpage;

public class FunctionPickerMenuItemHolder {

    public String name;
    public Class<?> targetActivity;

    public FunctionPickerMenuItemHolder(String name, Class<?> targetActivity) {
        this.name = name;
        this.targetActivity = targetActivity;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
