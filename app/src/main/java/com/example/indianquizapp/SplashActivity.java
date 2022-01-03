package com.example.indianquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {


    public static ArrayList<Modelclass> list;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_main);


        list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Modelclass modelclass = dataSnapshot.getValue(Modelclass.class);
                    list.add(modelclass);
                }

                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        list.add(new Modelclass("Approximately what fraction of the world’s population lives in India?", "1/6", "1/10", "1/50", "1/3", "1/6"));
//        list.add(new Modelclass("Which of the following countries does not share a land border with India?", "Myanmar", "Afghanistan", "China", "Bhutan", "Afghanistan"));
//        list.add(new Modelclass("Approximately what fraction of the world’s population lives in India?", "Peak of heaven", "Abode of snow", "Rocky mountains", "The high one", "Abode of snow"));
//        list.add(new Modelclass("Which Indian city is home to the Taj Mahal?", "Mumbai", "Chennai", "Agra", "Delhi", "Agra"));
//        list.add(new Modelclass("What is the name of the tallest mountain in India?", "Damāvand", "Kanchenjunga", "Elbrus", "Everest", "Kanchenjunga"));
//        list.add(new Modelclass("Which of the following cities has the largest population?", "Kolkata", "Hyderabad", "Mumbai", "Chennai", "Mumbai"));
//        list.add(new Modelclass("Roughly what percent of Indians work in agriculture?", "33%", "80%", "10%", "50%", "50%"));
//        list.add(new Modelclass("Which mountains form the eastern and western edges of the Deccan plateau?", "Eastern and Western Ghats", "Hindu Kush", "Urals", "Himalayas", "Eastern and Western Ghats"));
//        list.add(new Modelclass("What is the name of the boundary that separated India from Pakistan, set in 1947?", "Radcliffe Line", "Plimsoll Line", "Durand Line", "Green Line", "Radcliffe Line"));
//        list.add(new Modelclass("The name of which Indian union territory means a Hundred Thousand Islands in Sanskrit?", "Lakshadweep", "Puducherry", "Delhi", "Chandigarh", "Lakshadweep"));
//        list.add(new Modelclass("On which of these rivers was the Hirakud dam built?", "Ganga", "Godavari", "Mahanadi", "Kaveri", "Mahanadi"));
//        list.add(new Modelclass("In which Indian town does the Alaknanda and Bhagirathi rivers unite to form the river Ganga?", "Haridwar", "Eluru", "Devaprayag", "Bokaro", "Devaprayag"));
//        list.add(new Modelclass("Which of these mountains is the highest peak of peninsular India?", "Anai Peak", "Anai Peak", "Kalsubai Peak", "Doddabetta Peak", "Anai Peak"));
//        list.add(new Modelclass("The name of which state in India means “peerless” in the now extinct Ahom language?", "Assam", "Uttarakhand", "Bihar", "Chhattisgarh", "Assam"));
//        list.add(new Modelclass("In which mountain range is the Kargil sector situated?", "Pir Panjal Range", "Zaskar Range", "Satpura Range", "Aravalli Range", "Zaskar Range"));
//        list.add(new Modelclass("Which place in India forms the southernmost point of the subcontinent?", "Kochi", "Cape Comorin", "Indira Point", "Palk Strait", "Cape Comorin"));
//        list.add(new Modelclass("In which northeastern Indian state is the Surma river known as the Barak river?", "Mizoram", "Goa", "Manipur", "Sikkim", "Manipur"));
//        list.add(new Modelclass("Name the city formerly called Allahabad that was founded in 1583 by the Mughal emperor Akbar.", "Surat", "Agra", "Prayagraj", "Fatehpur Sikri", "Prayagraj"));
//        list.add(new Modelclass("Which Indian state has no coastline and no international frontiers?", "Chhattisgarh", "Uttar Pradesh", "Madhya Pradesh", "Jharkhand", "Madhya Pradesh"));
//        list.add(new Modelclass("“Abode of the Clouds” is the meaning of the name of which Indian state?", "Uttarakhand", "Meghalaya", "Karnataka", "Kerala", "Meghalaya"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
//                startActivity(intent);
            }
        }, 1500);
    }
}