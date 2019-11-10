package com.example.lilium.mocklog23;

import android.content.Context;
import android.content.Intent;
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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String name, paswd;

    EditText NameInput;
    EditText passwordi;
    private FirebaseAuth mAuth;
    Button Submit;

    DatabaseReference reff;
    Member member;
    ///String stjr = "fuckyou";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        ///Toast.makeText(MainActivity.this,stjr,Toast.LENGTH_LONG).show();

        NameInput = (EditText) findViewById(R.id.Nameinput);
        passwordi = (EditText) findViewById(R.id.passwordi);

        Submit = (Button) findViewById(R.id.button);

        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = NameInput.getText().toString();
                paswd = passwordi.getText().toString();

                //////////////////////////
                member.setName(NameInput.getText().toString());
                member.setPassword(passwordi.getText().toString());

                reff.push().setValue(member);
                //////////////////////////

                ////////////////////////
                mAuth.signInWithEmailAndPassword(name, paswd)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this,task.getException().getMessage()
                                    , Toast.LENGTH_LONG).show();
                        }
                    }
                });


                ////////////////////////

                ////// TOAST //////
                Context context = getApplicationContext();
                CharSequence text =     name;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //////TOAST////////
                //startActivity(new Intent(MainActivity.this, SecondActivity.class));

            }
        });
        //configurenext();
    }

  /*  private void configurenext(){
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));

            }
        });*/

    }
//}
