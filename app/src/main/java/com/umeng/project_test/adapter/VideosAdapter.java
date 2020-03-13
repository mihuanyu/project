package com.umeng.project_test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.umeng.project_test.R;
import com.umeng.project_test.bean.ItemData;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemData.DataBeanX.DataBean> list;
    private Context context;

    public VideosAdapter(List<ItemData.DataBeanX.DataBean> list) {
        this.list = list;
    }

    public void initData(List<ItemData.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_videoitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemData.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.name.setText(dataBean.getTitle());
        holder1.name.setText(dataBean.getSubtitle());
        Glide.with(context).load(dataBean.getScene_pic_url()).into(holder1.zhuantiImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView zhuantiImg;
        TextView title;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zhuantiImg=itemView.findViewById(R.id.zhuantiImg);
            title=itemView.findViewById(R.id.title);
            name=itemView.findViewById(R.id.name);
        }
    }
}

