package com.tj24.demo.countdown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tj24.demo.R;
import com.tj24.demo.timmer.Timmer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CookStepAdapter extends RecyclerView.Adapter<CookStepAdapter.CookStepVH> {

    private List<CookStep> cookSteps = new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;
    private List<Timmer> timmers = new ArrayList<>();
    Map<String,CountDownView> map = new HashMap<>();
    public CookStepAdapter(List<CookStep> cookSteps,List<Timmer> timmers, Context mContext) {
        this.cookSteps = cookSteps;
        this.mContext = mContext;
        this.timmers = timmers;
        inflater = LayoutInflater.from(mContext);
    }

    public CookStepAdapter(List<CookStep> cookSteps, Context mContext,Map<String,CountDownView> map) {
        this.cookSteps = cookSteps;
        this.mContext = mContext;
        this.map = map;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public CookStepVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CookStepVH(inflater.inflate(R.layout.rv_steps_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull CookStepVH holder, int position) {
        CookStep cookStep = cookSteps.get(position);
        if(cookStep.getContent().contains("分钟")){
            CountDownView countDownView = new CountDownView();
            countDownView.init(cookStep.getId(),3000*(position+1),mContext,holder.container);
            map.put(cookStep.getId(),countDownView);
        }
//        Timmer timmer = timmers.get(position);
//        if(timmer.getTotalTime()==0){
//            holder.container.setVisibility(View.GONE);
//        }else {
//            timmer.setmContext(mContext);
//            timmer.setContainer(holder.container);
//            timmer.init();
//        }
        holder.tvContent.setText(cookStep.getContent());
        Glide.with(mContext).load(cookStep.getPhotoUrl()).into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return cookSteps.size();
    }

    class CookStepVH extends RecyclerView.ViewHolder{
        TextView tvContent;
        ImageView ivPhoto;
        LinearLayout container;
        public CookStepVH(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            container = itemView.findViewById(R.id.timer_container);
        }
    }
}
