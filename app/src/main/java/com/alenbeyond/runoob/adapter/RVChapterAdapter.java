package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.greendao.bean.RunoobChapter;
import com.alenbeyond.runoob.listenter.OnItemClickListener;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public class RVChapterAdapter extends RecyclerView.Adapter<RVChapterAdapter.Viewholder> {

    private Context context;
    private List<RunoobChapter> datas;

    public RVChapterAdapter(Context context, List<RunoobChapter> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.adapter_item_chapter, null);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {

        if (onItemClickListener != null) {
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(v, position);
                }
            });
        }

        holder.tvTitle.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public View rootView;

        public Viewholder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            rootView = itemView;
        }
    }
}
