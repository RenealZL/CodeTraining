package com.example.bookkeepingpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookkeepingpractice.R;
import com.example.bookkeepingpractice.db.AccountRecord;

import java.util.Calendar;
import java.util.List;

public class AccountAdapter extends BaseAdapter {
    Context context;
    List<AccountRecord> mDatas;
    LayoutInflater inflater;
    int year,month,day;
    public AccountAdapter(Context context, List<AccountRecord> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mainlv,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        AccountRecord record = mDatas.get(position);
        holder.titleTv.setText(record.getTitle());
        holder.remarkTv.setText(record.getRemark());
        holder.amountTv.setText(String.valueOf(record.getAmount()));
        if (record.getYear()==year&&record.getMonth()==month&&record.getDay()==day) {
            String time = record.getTime().split(" ")[1];
            holder.timeTv.setText("今天 "+time);
        }else {
            holder.timeTv.setText(record.getTime());
        }
        return convertView;
    }

    class ViewHolder{
        TextView titleTv,remarkTv,amountTv,timeTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.item_mianlv_tv_title);
            remarkTv = view.findViewById(R.id.item_mianlv_tv_remark);
            amountTv = view.findViewById(R.id.item_mianlv_tv_amount);
            timeTv = view.findViewById(R.id.item_mianlv_tv_time);
        }
    }
}