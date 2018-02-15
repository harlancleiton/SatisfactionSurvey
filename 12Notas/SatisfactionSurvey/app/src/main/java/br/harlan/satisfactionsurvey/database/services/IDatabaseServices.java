package br.harlan.satisfactionsurvey.database.services;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseException;
import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.model.EvaluationModel;

public interface IDatabaseServices {

    //region DatabaseFunctions
    /*void savedDatabase(Task<Void> task);
    void editedEvaluation(Task<Void> task);
    void recoveredRatings();
    void errorRetrieveReviews(DatabaseException toException);
    void dataChange();*/
    void saveComplete(ParseException e);
    void retrieveComplete(List<ParseObject> objects, ParseException e);
    void retrieveComplete(ParseObject object, ParseException e);
    //endregion DatabaseFunctions
}