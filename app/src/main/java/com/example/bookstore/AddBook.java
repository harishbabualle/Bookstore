package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.models.Store;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddBook extends AppCompatActivity {
    EditText BookId,Bookname,quantity;
    TextView textView;
    ImageView img;
    Button btn1;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
//        textView = findViewById(R.id.Textview);
        img = findViewById(R.id.imageView2);
        BookId = findViewById(R.id.Bookid);
        Bookname = findViewById(R.id.Bookname);
        quantity = findViewById(R.id.Quantity);
        btn1 = findViewById(R.id.btn1);
        db = FirebaseFirestore.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookid = BookId.getText().toString();
                String bookname = Bookname.getText().toString();
                String bookquantity = quantity.getText().toString();
                addData(bookid,bookname,bookquantity);
            }
        });
    }

    private void addData(String bookid, String bookname, String bookquantity) {
        Store store = new Store(bookid,bookname,bookquantity);
        db.collection("stores")
                .add(store)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Add Book to store", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error in updating book"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
