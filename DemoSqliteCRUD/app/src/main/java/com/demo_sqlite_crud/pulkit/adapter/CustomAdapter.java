package com.demo_sqlite_crud.pulkit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo_sqlite_crud.pulkit.R;
import com.demo_sqlite_crud.pulkit.models.Student;

import java.util.List;

/**
 * Created by Tulshiram on 11/18/2015.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Student> list;

    public CustomAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_showall_row_items, null);

            viewHolder = new ViewHolder();

            viewHolder.tv_rollno = (TextView) convertView.findViewById(R.id.tv_rollno);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = (Student) getItem(position);
        viewHolder.tv_rollno.setText(String.valueOf(student.getStudent_Rollno()));
        viewHolder.tv_name.setText(student.getStudent_Name());
        viewHolder.tv_phone.setText(student.getStudent_Phone());

        return convertView;
    }

    private class ViewHolder {
        TextView tv_rollno, tv_name, tv_phone;
    }

}
