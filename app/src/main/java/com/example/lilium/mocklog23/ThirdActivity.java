package com.example.lilium.mocklog23;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button  reg;
    EditText mail, pass, name, usertype;
    String mailS, passS, nameS, usertypeS;
    User user;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        reg = (Button) findViewById(R.id.register);
        mail = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        name = (EditText) findViewById(R.id.editText3);
        usertype = (EditText) findViewById(R.id.editText4);

        mAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailS = mail.getText().toString();
                passS = pass.getText().toString();
                nameS = name.getText().toString();
                usertypeS = usertype.getText().toString();

                user = new User();
                reff= FirebaseDatabase.getInstance().getReference().child("User");





                mAuth.createUserWithEmailAndPassword(mailS, passS).addOnCompleteListener(ThirdActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ThirdActivity.this,"FU",Toast.LENGTH_LONG).show();

                            user.setEmail(mailS);
                            user.setName(nameS);
                            user.setUserType(usertypeS);

                            reff.push().setValue(user);

                        }else{
                            Toast.makeText(ThirdActivity.this,"FU2",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
