package br.harlan.satisfactionsurvey.singleton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseSingleton {
    private static DatabaseReference databaseReference;
    private FirebaseSingleton() {}

    public static DatabaseReference getDatabaseReference() {
        if (databaseReference == null)
            databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference;
    }
}