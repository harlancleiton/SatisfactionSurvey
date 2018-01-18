package br.harlan.satisfactionsurvey.business;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.CurrentDateTime;
import br.harlan.satisfactionsurvey.database.SearchDatabase;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class SearchBusiness extends BaseBusiness {
    public SearchBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
    }

    public void registerEvaluation(EvaluationModel evaluationModel) {
        if (validateEvaluation(evaluationModel)) {
            evaluationModel.setCurrentTime(CurrentDateTime.getCurrentTime());
            evaluationModel.setCurrentDate(CurrentDateTime.getCurrentDate());
            new SearchDatabase(databaseServices).registerEvaluation(evaluationModel);
        } else
            messageServices.newToast(R.string.toast_fill_in_required_fields);
    }

    private boolean validateEvaluation(EvaluationModel evaluationModel) {
        if (evaluationModel != null) {
            if (
                    !evaluationModel.getName().isEmpty() && !evaluationModel.getName().equals("") &&
                            !evaluationModel.getEmail().isEmpty() && !evaluationModel.getEmail().equals("") &&
                            evaluationModel.getNoteKnowledge() > 0 && evaluationModel.getNoteCommitment() > 0 &&
                            evaluationModel.getNoteCommitment() > 0 && evaluationModel.getNoteCordiality() > 0
                    )
                return true;
            else return false;
        } else return false;
    }

    public void retrieveReviews(ArrayList<EvaluationModel> evaluationModels, BaseModel.OnDataChangeListener onDataChangeListener) {
        databaseServices.setOnDataChange(onDataChangeListener);
        new SearchDatabase(databaseServices).retrieveReviews(evaluationModels);
    }
}