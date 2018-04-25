package com.example.materialtest;

/**
 * Created by mengqiqin on 17/4/8.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

    private static final String TAG = "PlanAdapter";

    private Context mContext;

    private List<Plan> mPlanList;

    private MyItemClickListener mListener;

    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mListener = listener;
    }


    public interface MyItemClickListener {
        public void onItemClick(View v, int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        ImageView planImage;
        TextView planName;

        private MyItemClickListener mListener;

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getPosition());
            }
        }

        public ViewHolder(View view, MyItemClickListener listener) {
            super(view);
            cardView = (CardView) view;
            planImage = (ImageView) view.findViewById(R.id.plan_image);
            planName = (TextView) view.findViewById(R.id.plan_name);

            view.setOnClickListener(this);
            this.mListener = listener;
        }
    }

    public PlanAdapter(List<Plan> planList) {
        mPlanList = planList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.plan_item, parent, false);
        final ViewHolder holder = new ViewHolder(view, mListener);
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
               // Plan plan = mPlanList.get(position);
//                Intent intent = new Intent(mContext, PlanActivity.class);
//                intent.putExtra(PlanActivity.PLAN_NAME, plan.getName());
//                intent.putExtra(PlanActivity.PLAN_IMAGE_ID, plan.getImageId());
//                mContext.startActivity(intent);
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Plan plan = mPlanList.get(position);
        holder.planName.setText(plan.getName());
        Glide.with(mContext).load(plan.getImageId()).into(holder.planImage);
    }

    @Override
    public int getItemCount() {
        return mPlanList.size();
    }

}
