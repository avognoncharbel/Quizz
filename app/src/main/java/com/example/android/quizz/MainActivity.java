package com.example.android.quizz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {
    String answer1 ="Barack", answer2="1939", answer5="Brasil", answer6="50";
    boolean answer4_1=false, answer4_2=true,answer4_3=false;//Answers for question #4
    boolean answer7_1=true, answer7_2=true,answer7_3=false;//Answers for question #7
    boolean answer8_1=true, answer8_2=true,answer8_3=false;//Answers for question #8




    int score =0;

    int rightAnswers =0;
    int wrongAnswers =0;
    int clickcount=0;
    String finalMessage="Mr/Miss : ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
We  make here a click listener on the Submit Button, to make sure that it is pressed only
one time.
@param clickcount is used to count how many time the button has been pressed
@matchAnswers() is used for the count of the answers.
 */
        Button submitAll = (Button)findViewById(R.id.submitButton);
        submitAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                clickcount=clickcount+1;
                if(clickcount==1)
                {

                    matchAnswers();


                }
                else
                {


                    Toast.makeText(getApplicationContext(),"Sorry ! You already have one submitted answer. This is your attempt Nbr :"+clickcount, Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });





    }


    //getChecked verify if a checkbox is checked
    public boolean  getChecked(int Ressource){
        return ((CheckBox)findViewById(Ressource)).isChecked();

    }




//onRadioCliked return the value of the checked Radio within the Radiogroup



    public void displayScore(){
//Displays the score on the score_TextView field
        TextView scr = (TextView)findViewById(R.id.score_textView);
        scr.setText(String.valueOf(score));
    }



    public void checkAnswer(String typedAnswer, String realAnswer ){
//checkAnswer compares the Strings (answers)in the Edittext to the righ answers(stored in variables)
//then update the Score field.
//@param typedAnswer is the answer typed by the user
//@param realAnswer is the answer stored in our program
//@param answerId is the Id of typed answer


        if(typedAnswer.equals(realAnswer)){

            score+=5;
            rightAnswers+=1;
            displayScore();
        }
        else {
            displayScore();
            wrongAnswers+=1;
        }
    }
    public void checkAnswer(boolean checkedAnswer1,boolean checkedAnswer2,
                                    boolean checkedAnswer3, boolean realAnswer1,boolean realAnswer2,
                                    boolean realAnswer3)
    //This Version of  checkAnswer compares the checkBoxes (answers) to the right answers(stored in variables)
//then update the Score field.
//@param checkedAnswer1{2,3} is the answer checked by the user
//@param realAnswer is the answer stored in our program
//

    {
        if(checkedAnswer1==realAnswer1 && checkedAnswer2==realAnswer2 && checkedAnswer3== realAnswer3){

            score+=5;
            rightAnswers+=1;
            displayScore();

        }
        else {
            wrongAnswers+=1;

            displayScore();

        }
    }
    public void checkAnswer(boolean radio){
        //This Version of  checkAnswer compares the radiobuttons (answers) to the right answers(stored in variables)
//then update the Score field.
//@param radio is always on state true and reflect that the right radio Button is pressed
//


        if (radio){

            score+=5;
            rightAnswers+=1;
            displayScore();
        }
        else {


            wrongAnswers+=1;
            displayScore();
        }

    }



    public void matchAnswers(){
        EditText user = (EditText)findViewById(R.id.userName_Text);
        String userName=(user.getText()).toString();
        EditText phone = (EditText)findViewById(R.id.userPhone_Text);
        String userPhone=(phone.getText()).toString();

/*
matchAnswers() uses checkAnswer() to match the  different typed answers to the right answers.
 */


        /***************************************************
         * *************************************************
         * *************************************************
         * *************EDITEXTs***********************
         * *************************************************
         * *************************************************
         * *************************************************/

        Editable answr1 = ((EditText)findViewById(R.id.answer1)).getText();
        Editable answr2 = ((EditText)findViewById(R.id.answer2)).getText();
        Editable answr5 = ((EditText)findViewById(R.id.answer5)).getText();
        Editable answr6 = ((EditText)findViewById(R.id.answer6)).getText();

        checkAnswer(answr1.toString(),answer1);
        checkAnswer(answr2.toString(),answer2);
        checkAnswer(answr5.toString(),answer5);
        checkAnswer(answr6.toString(),answer6);

        /***************************************************
         * *************************************************
         * *************************************************
         * *************CHECKBOXES***********************
         * *************************************************
         * *************************************************
         * *************************************************/

        CheckBox ckbx4_1 = (CheckBox)findViewById(R.id.check_answer4_1);
        CheckBox ckbx4_2 = (CheckBox)findViewById(R.id.check_answer4_2);
        CheckBox ckbx4_3 = (CheckBox)findViewById(R.id.check_answer4_3);
        boolean ch4_1 = ckbx4_1.isChecked();
        boolean ch4_2 = ckbx4_2.isChecked();
        boolean ch4_3 = ckbx4_3.isChecked();


        CheckBox ckbx7_1 = (CheckBox)findViewById(R.id.check_answer7_1);
        CheckBox ckbx7_2 = (CheckBox)findViewById(R.id.check_answer7_2);
        CheckBox ckbx7_3 = (CheckBox)findViewById(R.id.check_answer7_3);
        boolean ch7_1 = ckbx7_1.isChecked();
        boolean ch7_2 = ckbx7_2.isChecked();
        boolean ch7_3 = ckbx7_3.isChecked();


        CheckBox ckbx8_1 = (CheckBox)findViewById(R.id.check_answer8_1);
        CheckBox ckbx8_2 = (CheckBox)findViewById(R.id.check_answer8_2);
        CheckBox ckbx8_3 = (CheckBox)findViewById(R.id.check_answer8_3);


        boolean ch8_1 = ckbx8_1.isChecked();
        boolean ch8_2 = ckbx8_2.isChecked();
        boolean ch8_3 = ckbx8_3.isChecked();


        checkAnswer(ch4_1,ch4_2,ch4_3,answer4_1,answer4_2,answer4_3);
        checkAnswer(ch7_1,ch7_2,ch7_3,answer7_1,answer7_2,answer7_3);
        checkAnswer(ch8_1,ch8_2,ch8_3,answer8_1,answer8_2,answer8_3);


        /***************************************************
         * *************************************************
         * *************************************************
         * *************RADIO BUTTONS***********************
         * *************************************************
         * *************************************************
         * *************************************************/


        //We only need to check on the right answer within the radiogroup
        RadioButton radio = (RadioButton)findViewById(R.id.answer3_yes);
        boolean radioState3= radio.isChecked();

        checkAnswer(radioState3);


        /**
         * Summarize the text result
         */
        finalMessage += userName+ " You have " +rightAnswers +"  Right Answers and " + wrongAnswers
                +" Wrong Answers. You will receive a copy of the text in your mail address. Tank you for playing ." ;
        Toast.makeText(this,finalMessage,Toast.LENGTH_SHORT).show();

/*
* Please refer to this page http://www.technotalkative.com/android-sending-sms-from-android-application/
      to see this tutorial how to send SMS. I tried intents but it didnt work
* */
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(userPhone, null, finalMessage, null, null);

    }




}
