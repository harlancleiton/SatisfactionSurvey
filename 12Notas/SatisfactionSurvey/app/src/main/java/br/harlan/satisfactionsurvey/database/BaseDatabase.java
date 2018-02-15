package br.harlan.satisfactionsurvey.database;

import com.google.firebase.database.DatabaseReference;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.singleton.FirebaseSingleton;

public class BaseDatabase {
    protected IDatabaseServices databaseServices;

    public BaseDatabase(IDatabaseServices databaseServices) {
        this.databaseServices = databaseServices;
    }

    public interface Directories {
        //String USER_CHILD = "users";
        //String CURRENT_USER_ID = FirebaseSingleton.getFirebaseAuth().getCurrentUser().getUid();
        String EVALUATION_CHILD = "evaluations";
        DatabaseReference EVALUATION_CHILD_COMPLETE = FirebaseSingleton.getDatabaseReference().child(EVALUATION_CHILD);
    }
}
