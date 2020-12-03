package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.models.Store;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class RetrieveBook extends AppCompatActivity {
 TextView textView;
 Button btn1;
 FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_book);
        textView =findViewById(R.id.Textview);
        btn1 = findViewById(R.id.button);
        db=FirebaseFirestore.getInstance();
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getData();
        }
    });
    }
    public void getData()
    {
        db.collection("stores")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful())
                        {
                            String bookdetails="";
                            for(DocumentSnapshot document : task.getResult())
                            {
                                Store store = document.toObject(Store.class);
                                bookdetails+="BOOK ID : "+store.getBookId()+
                                        "\nBOOK NAME : "+store.getBookName()+
                                        "\nBOOK Quantity :"+store.getBookQuantity()+"\n";
                            }
                            textView.setText(bookdetails);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
