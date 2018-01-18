package br.harlan.satisfactionsurvey.database;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.singleton.FirebaseSingleton;

public class SearchDatabase extends BaseDatabase implements BaseDatabase.Directories {

    public SearchDatabase(IDatabaseServices databaseServices) {
        super(databaseServices);
    }

    public void registerEvaluation(EvaluationModel evaluationModel) {
        DatabaseReference databaseReference = FirebaseSingleton.getDatabaseReference();
        evaluationModel.setKey(databaseReference.push().getKey());
        databaseReference.child(evaluationModel.getClassChild()).child(evaluationModel.getKey())
                .setValue(evaluationModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                databaseServices.savedDatabase(task);
            }
        });
    }

    public void retrieveReviews(final ArrayList<EvaluationModel> evaluationModels) {
        final DatabaseReference databaseReference = EVALUATION_CHILD_COMPLETE;
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                evaluationModels.clear();
                EvaluationModel evaluationModel;
                for(DataSnapshot result : dataSnapshot.getChildren()) {
                    evaluationModel = result.getValue(EvaluationModel.class);
                    evaluationModels.add(evaluationModel);
                }
                databaseServices.recoveredRatings();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseServices.errorRetrieveReviews(databaseError.toException());
            }
        });
    }
}