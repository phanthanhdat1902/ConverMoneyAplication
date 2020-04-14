package com.example.convermoneyaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MoneyAdapter extends BaseAdapter {
    List<MoneyClass> moneyAdapterList;

    public MoneyAdapter(List<MoneyClass> moneyAdapterList) {
        this.moneyAdapterList = moneyAdapterList;
    }

    @Override
    public int getCount() {
        return moneyAdapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return moneyAdapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spinner,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=convertView.findViewById(R.id.inforMoney);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        MoneyClass moneyClass=moneyAdapterList.get(position);
        viewHolder.textView.setText(moneyClass.getName());
        return convertView;
    }
}
class ViewHolder{
    TextView textView;
}
