package com.android.studentmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.studentmanager.R;
import com.android.studentmanager.bean.Teacher;

import java.util.List;

public class TeacherAdapter extends android.widget.BaseAdapter {
    private Context context;
    private List<Teacher> list;

    public void setList(List<Teacher> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    /**
     * 添加一个teacher，放在最后，也可以重载方法
     */
    public void addTeacher(Teacher teacher) {
        this.list.add(teacher);
        notifyDataSetChanged();
    }


    public TeacherAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return list == null ? 0 : list.size();//判断是否是空，空的话就显示0条，不是的话就显示列表的大小
    }

    @Override
    public Object getItem(int position) {//可以不理这个方法
        //方便使用也可以这么做
        return list.get(position);//获取position个item的javabean
//        return null;
    }

    @Override
    public long getItemId(int position) {//可以不理这个方法
        return position;
    }

    /**
     * 这个是有经过优化的
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_teacher, null);
            holder = new Holder();
            convertView.setTag(holder);
            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvAccount = convertView.findViewById(R.id.tv_account);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Teacher teacher = list.get(position);
        holder.tvName.setText("教师名字：" + teacher.getName());
        holder.tvAccount.setText("教师账号：" + teacher.getAccount());
        return convertView;
    }

    class Holder {
        public TextView tvName;
        public TextView tvAccount;
    }

    /**
     * 这个是没有经过优化的
     */
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_teacher, null);
//        TextView tvAccount = view.findViewById(R.id.tv_account);
//        TextView tvName = view.findViewById(R.id.tv_name);
//        Teacher teacher = list.get(position);
//        tvAccount.setText(teacher.getAccount());
//        tvName.setText(teacher.getName());
//        return view;
//    }


}