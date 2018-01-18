package br.harlan.satisfactionsurvey.database.services;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseException;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.model.EvaluationModel;

public interface IDatabaseServices {

    //region DatabaseFunctions
    void savedDatabase(Task<Void> task);
    void editedEvaluation(Task<Void> task);
    void recoveredRatings();
    void errorRetrieveReviews(DatabaseException toException);
    void dataChange();
    //endregion DatabaseFunctions
}