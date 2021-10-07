package com.example.parcial_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashBoard extends Activity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private TextView lblSalir;
    private TextView lblAmigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        lblAmigos = findViewById(R.id.lblAmigos);
        lblSalir = findViewById(R.id.lblSalir);

        lblSalir.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(this,LoginActivity.class));
        });
        lblAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAmigos();
            }
        });
    }
    private void openAmigos() {
    Intent intent = new Intent(this, Amigos.class);
    startActivity(intent);
    }

}
