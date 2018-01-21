package br.harlan.satisfactionsurvey.adapter;

import android.support.v4.media.RatingCompat;
import android.support.v4.widget.ImageViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class HistoricRecyclerAdapter extends  RecyclerView.Adapter<HistoricRecyclerAdapter.HistoricViewHolder>  {

    private ArrayList<EvaluationModel> evaluationModels;

    public HistoricRecyclerAdapter(ArrayList<EvaluationModel> evaluationModels){
        this.evaluationModels = evaluationModels;
    }

    @Override
    public HistoricRecyclerAdapter.HistoricViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_line_review, parent, false);
        return new HistoricViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoricRecyclerAdapter.HistoricViewHolder holder, int position) {
        if(holder!=null){
            EvaluationModel evaluationModel = evaluationModels.get(position);
            if (evaluationModel.getSatisfaction() == EvaluationModel.SATISFIED)
                holder.ivSatisfied.setImageResource(R.drawable.ic_action_sentiment_very_satisfied_light);
            else if (evaluationModel.getSatisfaction() == EvaluationModel.INDIFFERENT)
                holder.ivSatisfied.setImageResource(R.drawable.ic_action_sentiment_neutral_light);
            else holder.ivSatisfied.setImageResource(R.drawable.ic_action_sentiment_very_dissatisfied_light);
            holder.tvName.setText(evaluationModel.getName());
            holder.rbCommitment.setRating(evaluationModel.getNoteCommitment());
            holder.rbKnowledge.setRating(evaluationModel.getNoteKnowledge());
            holder.rbCommunication.setRating(evaluationModel.getNoteCommunication());
            holder.rbCordiality.setRating(evaluationModel.getNoteCordiality());
            holder.tvComments.setText(evaluationModel.getComments());
        }
    }

    @Override
    public int getItemCount() {
        return evaluationModels.size();
    }

    public void dataChange() {
        evaluationModels.clear();
    }

    public class HistoricViewHolder extends RecyclerView.ViewHolder{

        ImageView ivSatisfied;
        TextView tvName;
        RatingBar rbCommitment;
        RatingBar rbCommunication;
        RatingBar rbCordiality;
        RatingBar rbKnowledge;
        TextView tvComments;

        public HistoricViewHolder(View itemView) {
            super(itemView);
            ivSatisfied = itemView.findViewById(R.id.iv_is_satisfied);
            tvName = itemView.findViewById(R.id.tv_name_cv);
            rbCommitment = itemView.findViewById(R.id.rb_commitment_cv);
            rbCommunication = itemView.findViewById(R.id.rb_communication_cv);
            rbCordiality = itemView.findViewById(R.id.rb_cordiality_cv);
            rbKnowledge = itemView.findViewById(R.id.rb_knowledge_cv);
            tvComments = itemView.findViewById(R.id.tv_comments_cv);
        }
    }
}
