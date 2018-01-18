package br.harlan.satisfactionsurvey.view;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.adapter.HistoricRecyclerAdapter;
import br.harlan.satisfactionsurvey.business.SearchBusiness;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class HistoricFragment extends BaseFragment {

    //region Variables
    private ProgressBar progressBar;
    private ArrayList<EvaluationModel> evaluationModels;
    private RecyclerView recyclerView;
    private HistoricRecyclerAdapter recyclerAdapter;
    //endregion Variables

    public HistoricFragment() {
        super(R.layout.fragment_historic);
    }

    //region Methods
    @Override
    protected void initializeComponents(View rootView) {
        progressBar = rootView.findViewById(R.id.pb_loading_historic);
        evaluationModels = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.rc_historic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter = new HistoricRecyclerAdapter(evaluationModels);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    protected void addEvents() {
        new SearchBusiness(messageServices, navigationServices).retrieveReviews(evaluationModels, new BaseModel.OnDataChangeListener() {
            @Override
            public void onDataChange() {
                progressBar.setVisibility(View.GONE);
                recyclerAdapter.notifyDataSetChanged();
            }
        });
    }
    //endregion Methods
}