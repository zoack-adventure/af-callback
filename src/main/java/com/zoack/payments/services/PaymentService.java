package com.zoack.payments.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zoack.payments.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class PaymentService {
    public static final String TRANSACTIONS_REF="transactions";
    String returned = "";
    public String saveCallbackDetails(Transaction transaction) throws InterruptedException, ExecutionException {
        DatabaseReference paymentRef = FirebaseDatabase.getInstance()
                .getReference(TRANSACTIONS_REF)
                .child(transaction.getRequestMetadata().get("UID"))
                .child(transaction.getRequestMetadata().get("PaymentID"))
                .child(TRANSACTIONS_REF)
                .child(transaction.getRequestMetadata().get("TransactionID"));
        transaction.setDate(new Date());

        paymentRef.setValue(transaction, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                returned = ref.toString();
            }
        });
        return returned;
    }
}
