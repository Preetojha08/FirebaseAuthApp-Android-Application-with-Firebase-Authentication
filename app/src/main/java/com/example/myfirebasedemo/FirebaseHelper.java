package com.example.myfirebasedemo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    private final DatabaseReference databaseReference;

    public FirebaseHelper() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
    }

    public void registerUser(User user, FirebaseCallback callback) {
        String userId = databaseReference.push().getKey();
        if (userId == null) {
            callback.onFailure("Unable to generate user ID.");
            return;
        }

        databaseReference.child(userId).setValue(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onFailure(task.getException() != null ?
                                task.getException().getMessage() : "Unknown error occurred.");
                    }
                });
    }

    public interface FirebaseCallback {
        void onSuccess();

        void onFailure(String errorMessage);
    }
}
