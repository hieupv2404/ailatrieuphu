package com.group7.com.altp.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.group7.com.altp.R;
import com.group7.com.altp.highscore.HighScore;

public class AdapterHighScore extends RecyclerView.Adapter<AdapterHighScore.Viewholder> {
    private IGetH iGetH;

    public AdapterHighScore(IGetH iGetH) {
        this.iGetH = iGetH;
    }

    @Override
    public AdapterHighScore.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_highscore, parent, false);
        return new Viewholder(v);
    }


    @Override
    public void onBindViewHolder(AdapterHighScore.Viewholder holder, int position) {
        holder.tvNum.setText(position + 1 + "");
        holder.tvLevel.setText(iGetH.getItems(position).getLevelPass() + "");
        holder.tvName.setText(iGetH.getItems(position).getName());
    }

    @Override
    public int getItemCount() {
        return iGetH.getCount();
    }

    static final class Viewholder extends RecyclerView.ViewHolder {
        private TextView tvNum, tvName, tvLevel;

        public Viewholder(View itemView) {
            super(itemView);

            tvNum = itemView.findViewById(R.id.tv_num);
            tvName = itemView.findViewById(R.id.tv_name);
            tvLevel = itemView.findViewById(R.id.tv_level);
        }
    }

    public interface IGetH {
        int getCount();

        HighScore getItems(int position);
    }
}
