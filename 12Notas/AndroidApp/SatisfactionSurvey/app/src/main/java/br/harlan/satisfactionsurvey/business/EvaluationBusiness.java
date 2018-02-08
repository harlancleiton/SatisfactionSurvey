package br.harlan.satisfactionsurvey.business;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.services.IMessageServices;
import br.harlan.satisfactionsurvey.business.services.INavigationServices;
import br.harlan.satisfactionsurvey.database.EvaluationDatabase;
import br.harlan.satisfactionsurvey.util.CurrentDateTime;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class EvaluationBusiness extends BaseBusiness {

    public EvaluationBusiness(IMessageServices messageServices, INavigationServices navigationServices) {
        super(messageServices, navigationServices);
    }

    public void registerEvaluation(EvaluationModel evaluationModel) {
        if (validateEvaluation(evaluationModel)) {
            //evaluationModel.setCurrentTime(CurrentDateTime.getCurrentTime());
            //evaluationModel.setCurrentDate(CurrentDateTime.getCurrentDate());
            if (validadeEmail(evaluationModel.getEmail()))
                new EvaluationDatabase(databaseServices).create(evaluationModel);
            else messageServices.newToast(R.string.invalid_email);
            //new SearchDatabase(databaseServices).registerEvaluation(evaluationModel);
        } else {
            messageServices.newToast(R.string.toast_fill_in_required_fields);
        }
    }

    public void retrieveReviews(BaseModel.OnDataChangeListener onDataChangeListener) {
        if (onDataChangeListener != null)
            databaseServices.setOnDataChange(onDataChangeListener);
        new EvaluationDatabase(databaseServices).retrieveAll(BaseModel.CLASS_NAME_EVALUATION);
    }

    private boolean validadeEmail(String email) {
        if (email.contains("@") && email.contains(".") && email.length() > 4)
            return true;
        else return false;
    }

    private boolean validateEvaluation(EvaluationModel evaluationModel) {
        if (evaluationModel != null) {
            if (
                    !evaluationModel.getName().isEmpty() && !evaluationModel.getName().equals("") &&
                            !evaluationModel.getEmail().isEmpty() && !evaluationModel.getEmail().equals("") &&
                            evaluationModel.getNoteKnowledge() > 0 && evaluationModel.getNoteCommitment() > 0 &&
                            evaluationModel.getNoteCommitment() > 0 && evaluationModel.getNoteCordiality() > 0 &&
                            evaluationModel.getTypeEvaluation() != EvaluationModel.NO_SELECTION &&
                            evaluationModel.getSatisfaction() != EvaluationModel.NO_SELECTION
                    )
                return true;
            else return false;
        } else return false;
    }
}