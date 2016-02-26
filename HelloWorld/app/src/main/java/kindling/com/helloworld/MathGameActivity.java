package kindling.com.helloworld;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.TimerTask;
import java.util.Timer;

import model.kindling.Application;
import model.kindling.Question;
import model.kindling.MathQuestion;
import android.media.MediaPlayer;

public class MathGameActivity extends ActionBarActivity {
    Timer time;
    Button answer_one, answer_two, answer_three, answer_four;
    TextView question_text;
    int counter;
    String string_Counter;
    TextView timerUpdate;
    ImageView image;
    //here is where we create the question
    MathQuestion mq;
    AlertDialog helpDialog;


    public static final String question = "Question";
    public static final String answer1 = "Answer1";
    public static final String answer2 = "Answer2";
    public static final String answer3 = "Answer3";
    public static final String answer4 = "Answer4";


    protected void onCreate(Bundle savedInstanceState) {
        counter = 21;
        mq = new MathQuestion();
        mq.populateAnswers();
        mq.generateQuestionText();
        mq.setCorrectAnswer(mq.correctAnswer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathgame);
        setTitle("Math Game");
        //sound

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        question_text = (TextView) findViewById(R.id.mathGame_questionText);
        timerUpdate = (TextView) findViewById(R.id.mathGame_counter);

        answer_one = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_two = (Button) findViewById(R.id.mathGame_AnswerButton2);
        answer_three = (Button) findViewById(R.id.mathGame_AnswerButton3);
        answer_four = (Button) findViewById(R.id.mathGame_AnswerButton4);

        // update question and choice
        question_text.setText(mq.questionText);
        answer_one.setText(mq.aAnswer);
        answer_two.setText(mq.bAnswer);
        answer_three.setText(mq.cAnswer);
        answer_four.setText(mq.dAnswer);

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the first button clicked.
                if (mq.correctAnswerIndex == 0) {
                    System.out.println("NUM ONE SELECTED : TRUE");
                    popUp(true);
                    mq.correctAnswer();
                } else {
                    System.out.println("NUM ONE SELECTED : FALSE");
                    popUp(false);
                    mq.incorrectAnswer();
                }

                //getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                time.cancel();
                delayNextQuestion();
                //finish();
                //startActivity(getIntent());
            }
        });
        answer_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the second button clicked.
                if (mq.correctAnswerIndex == 1) {
                    System.out.println("NUM TWO SELECTED : TRUE");
                    popUp(true);
                    mq.correctAnswer();
                } else {
                    System.out.println("NUM TWO SELECTED : FALSE");
                    popUp(false);
                    mq.incorrectAnswer();
                }
                time.cancel();
                delayNextQuestion();
                //finish();
                //startActivity(getIntent());
            }
        });
        answer_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the third button clicked.
                if (mq.correctAnswerIndex == 2) {
                    System.out.println("NUM THREE SELECTED : TRUE");
                    popUp(true);
                    mq.correctAnswer();
                } else {
                    System.out.println("NUM THREE SELECTED : FALSE");
                    popUp(false);
                    mq.incorrectAnswer();
                }
                time.cancel();
                delayNextQuestion();
                //finish();
                //startActivity(getIntent());
            }
        });
        answer_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the  button clicked.
                if (mq.correctAnswerIndex == 3) {
                    System.out.println("NUM FOUR SELECTED : TRUE");
                    popUp(true);
                    mq.correctAnswer();
                } else {
                    System.out.println("NUM FOUR SELECTED : FALSE");
                    popUp(false);
                    mq.incorrectAnswer();
                }
                time.cancel();
                delayNextQuestion();
                //finish();
                //startActivity(getIntent());
            }
        });
        timeCounter();

    }

    // when the game is started, call this function, then count starts
    public void timeCounter() {
        time = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                counter--;
                if (counter == 0) {
                    //when counter is 0, then next game pops up
                    // mq.incorrectAnswer();
                    //time.cancel();
                    counter = 20;
                    time.cancel();
                    finish();
                }
                string_Counter = String.valueOf(counter);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (counter < 10) {
                            //System.out.println("check 1 : " + counter);
                            timerUpdate.setText("0:0" + string_Counter);
                        } else {
                            //System.out.println("check 2 : " + counter);
                            timerUpdate.setText("0:" + string_Counter);
                        }


                    }
                });


            }
        };
        time.schedule(task, 1000, 1000);
    }

    private void popUp(boolean increment) {

        if (increment) {
            //increment
            image = new ImageView(this);
            image.setImageResource(R.drawable.increment_intelligence);

        } else {
            //decrement
            image = new ImageView(this);
            image.setImageResource(R.drawable.decrement_intelligence);
        }

        AlertDialog.Builder picturePopUp = new AlertDialog.Builder(this);
        picturePopUp.setView(image);

        helpDialog = picturePopUp.create();
        helpDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        helpDialog.show();

    }

    public void delayNextQuestion() {
        Thread th = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                helpDialog.dismiss();
                finish();
                startActivity(getIntent());
            }


        };
        th.start();
    }
}