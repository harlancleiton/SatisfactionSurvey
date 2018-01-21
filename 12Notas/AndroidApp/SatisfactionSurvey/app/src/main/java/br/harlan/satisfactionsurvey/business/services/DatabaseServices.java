package br.harlan.satisfactionsurvey.business.services;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.ParseObjectToObjectModel;

public class DatabaseServices implements IDatabaseServices {

    //region Variables
    private IMessageServices messageServices;
    private INavigationServices navigationServices;
    private BaseModel.OnDataChangeListener onDataChange;
    //endregion Variables

    public DatabaseServices(IMessageServices messageServices, INavigationServices navigationServices) {
        this.messageServices = messageServices;
        this.navigationServices = navigationServices;
    }

    @Override
    public void saveComplete(ParseException e) {
        if (e == null) {
            messageServices.newToast(R.string.evaluation_sent_sucessfully);
        } else {
            e.printStackTrace();
            Log.i("Erro enviar avaliação", e.getCode() + " - " + e.getMessage());
            messageServices.newToast(R.string.error_submitting);
        }
    }

    @Override
    public void retrieveComplete(ParseObject object, ParseException e) {

    }

    @Override
    public void retrieveComplete(List<ParseObject> objects, ParseException e) {
        Log.i("Database Services", "Retrieve Complete");
        if(e == null) {
            if (objects.get(0).getClassName().equals(BaseModel.CLASS_NAME_EVALUATION)) {
                ArrayList<EvaluationModel> evaluationModels = retrieveEvaluations(objects);
                if(evaluationModels!= null)
                    Log.i("Database Services", "Call onDataChange");
                    onDataChange.onDataChange(evaluationModels);
            }
        } else messageServices.newToast(R.string.error_retrieve_evaluations);
    }

    private ArrayList<EvaluationModel> retrieveEvaluations(List<ParseObject> objects) {
        ArrayList<EvaluationModel> evaluationModels = new ArrayList<>();
        for (ParseObject parseObject: objects){
            EvaluationModel evaluationModel = (EvaluationModel) ParseObjectToObjectModel.getObjectModel(parseObject);
            evaluationModels.add(evaluationModel);
        }
        return evaluationModels;
    }

    public void setOnDataChange(BaseModel.OnDataChangeListener onDataChange) {
        Log.i("Database Services", "Set OnDataChangeListener");
        this.onDataChange = onDataChange;
    }

    //region Methods
    //region DatabaseFunctions
    /*
    @Override
    public void savedDatabase(Task<Void> task) {
        if (task.isSuccessful())
            messageServices.newToast(R.string.evaluation_sent_sucessfully);
        else
            messageServices.newToast(R.string.error_submitting);
    }

    @Override
    public void editedEvaluation(Task<Void> task) {

    }

    @Override
    public void recoveredRatings() {
        if (onDataChange != null)
            onDataChange.onDataChange();
        else messageServices.newToast(R.string.error_display_data);
    }

    @Override
    public void errorRetrieveReviews(DatabaseException toException) {

    }

    @Override
    public void dataChange() {

    }
    */
    //endregion DatabaseFunctions
    //endregion Methods
}