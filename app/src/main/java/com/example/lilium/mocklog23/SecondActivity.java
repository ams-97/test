package com.example.lilium.mocklog23;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {
//DatabaseReference reff;

RecyclerView rv;
List<Member> names;

Adapter adapter;
Button nxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nxt1 = (Button) findViewById(R.id.button2);

        rv = (RecyclerView) findViewById(R.id.recycler);


        rv.setLayoutManager(new LinearLayoutManager(this));

        names = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(names);
        rv.setAdapter(adapter);


        database.getReference().child("Member").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                names.removeAll(names);
                //int i = 1;//tst
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                        Member name = snapshot.getValue(Member.class);
                        names.add(name);
                    //////TOAST////////
                    //i++;
                    //String is = Integer.toString(i);
                    //Context context = getApplicationContext();
                    //CharSequence text = is;
                    //int duration = Toast.LENGTH_LONG;

                    //Toast toast = Toast.makeText(context, text, duration);
                    //toast.show();
                    //////TOAST////////
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        nxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });



        }
    }

