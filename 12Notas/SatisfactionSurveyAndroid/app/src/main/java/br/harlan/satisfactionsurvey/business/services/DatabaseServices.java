package br.harlan.satisfactionsurvey.business.services;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseException;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.BaseModel;

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

    //region Methods
    //region DatabaseFunctions
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

    public void setOnDataChange(BaseModel.OnDataChangeListener onDataChange) {
        this.onDataChange = onDataChange;
    }
    //endregion DatabaseFunctions
    //endregion Methods
}