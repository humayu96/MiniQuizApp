package com.example.darkdeveloper.miniquizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darkdeveloper.miniquizapp.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2 , btn3 ,btn4 ;
    TextView textView_question , textView_timer;

    DatabaseReference databaseReference;

    int total = 0;
    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);


        textView_question = findViewById(R.id.textquestion);
        textView_timer = findViewById(R.id.timetxt);

        updatequestion();
        reuqesttimer(120,textView_timer);


    }

    private void updatequestion() {

        total ++;

        if(total >10)
        {
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);

            intent.putExtra("total",String.valueOf(total));
            intent.putExtra("correct",String.valueOf(correct));
            intent.putExtra("wrong",String.valueOf(wrong));
            startActivity(intent);

        }else {

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final Question question = dataSnapshot.getValue(Question.class);

                    textView_question.setText(question.getQuestion());

                    btn1.setText(question.getOption1());
                    btn2.setText(question.getOption2());
                    btn3.setText(question.getOption3());
                    btn4.setText(question.getOption4());




                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn1.getText().toString().equals(question.getAnswer())){

                                btn1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct ++;
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        Toast.makeText(MainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();


                                    }
                                },1000);

                            } else {


                                wrong ++;
                                btn1.setBackgroundColor(Color.RED);

                                if(btn2.getText().toString().equals(question.getAnswer())){

                                    btn2.setBackgroundColor(Color.GREEN);
                                    }

                                    else if(btn3.getText().toString().equals(question.getAnswer())){

                                    btn3.setBackgroundColor(Color.GREEN);
                                    }

                                else if(btn4.getText().toString().equals(question.getAnswer())){

                                    btn4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updatequestion();
                                    }
                                },1000);


                            }
                        }
                    });







                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(btn2.getText().toString().equals(question.getAnswer())){

                                btn2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct ++;
                                        Toast.makeText(MainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));


                                    }
                                },1000);

                            } else {


                                wrong ++;
                                btn2.setBackgroundColor(Color.RED);

                                if(btn1.getText().toString().equals(question.getAnswer())){

                                    btn1.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn3.getText().toString().equals(question.getAnswer())){

                                    btn3.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn4.getText().toString().equals(question.getAnswer())){

                                    btn4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updatequestion();
                                    }
                                },1000);


                            }






                        }
                    });



                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(btn3.getText().toString().equals(question.getAnswer())){

                                btn3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct ++;
                                        Toast.makeText(MainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));


                                    }
                                },1000);

                            } else {


                                wrong ++;
                                btn3.setBackgroundColor(Color.RED);

                                if(btn1.getText().toString().equals(question.getAnswer())){

                                    btn1.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn2.getText().toString().equals(question.getAnswer())){

                                    btn2.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn4.getText().toString().equals(question.getAnswer())){

                                    btn4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updatequestion();
                                    }
                                },1000);


                            }
//                            else


                        }
                    });




                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(btn4.getText().toString().equals(question.getAnswer())){

                                btn4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct ++;
                                        Toast.makeText(MainActivity.this, "Excellent Work", Toast.LENGTH_SHORT).show();

                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));


                                    }
                                },1000);

                            } else {


                                wrong ++;
                                btn4.setBackgroundColor(Color.RED);

                                if(btn1.getText().toString().equals(question.getAnswer())){

                                    btn1.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn2.getText().toString().equals(question.getAnswer())){

                                    btn2.setBackgroundColor(Color.GREEN);
                                }

                                else if(btn3.getText().toString().equals(question.getAnswer())){

                                    btn3.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updatequestion();
                                    }
                                },1000);


                            }
//                            else

                        }
                    });





                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }



    }


    public void reuqesttimer(final int seconds , final TextView txtVi){

        new CountDownTimer(seconds * 700 + 700, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 700);
                int minutes = seconds /60;

                seconds = seconds %60;

                txtVi.setText(String.format("%02d",minutes) + ":" + String.format("%02d",seconds));

            }

            @Override
            public void onFinish() {
                txtVi.setText("Completed");
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("total" , String.valueOf(total));
                intent.putExtra("correct" , String.valueOf(correct));
                intent.putExtra("wrong",String.valueOf(wrong));
                startActivity(intent);

            }
        }.start();
    }
}
