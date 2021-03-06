package it.cnvcrew.sonar;

import android.util.Log;
import android.widget.CompoundButton;

/**
 * Created by Alessandro on 14/05/2016.
 */
public class Interest implements CompoundButton.OnCheckedChangeListener{

    private int id, category_id;
    private String name, category_name;
    private boolean is_selected, has_changed = false;

    public Interest(int id, int category_id, String name, String category_name, boolean is_selected) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.category_name = category_name;
        this.is_selected = is_selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean is_selected() {
        return is_selected;
    }

    public void setChecked(boolean checked) {
        is_selected = checked;
    }

    public int getCategory_id() { return category_id; }

    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public boolean isHas_changed() {
        return has_changed;
    }

    public void setHas_changed(boolean has_changed) {
        this.has_changed = has_changed;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + id +
                ", category id=" + category_id +
                ", name=" + name +
                ", category name=" + category_name +
                ", is_selected=" + is_selected +
                '}';
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.is_selected = isChecked;
        Log.i("is_selected set to",String.valueOf(isChecked));
        this.has_changed = !has_changed;
        Log.i("has_changed set to",String.valueOf(has_changed));
    }
}
