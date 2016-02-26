package model.kindling;

import java.util.Random;

/**
 * Created by Jay on 4/26/2015.
 */
public class MathQuestion extends Question {

    public MathQuestion(){
        super();
    }

    public void populateAnswers() //will  set all answers to random
    {
        Random randy = new Random();
        int rand1, rand2, rand3, rand4;
        rand1 = randy.nextInt(100);
        rand2 = randy.nextInt(100);
        rand3 = randy.nextInt(100);
        rand4 = randy.nextInt(100);

        aAnswer = Integer.toString(rand1);
        bAnswer = Integer.toString(rand2);
        cAnswer = Integer.toString(rand3);
        dAnswer = Integer.toString(rand4);

    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        Random randy = new Random();

        int index = randy.nextInt(4);
        correctAnswerIndex = index;
        if(index == 0){
            aAnswer = correctAnswer;
        }
        else if (index == 1){
            bAnswer = correctAnswer;
        }
        else if (index == 2){
            cAnswer = correctAnswer;
        }
        else if (index == 3) {
            dAnswer = correctAnswer;
        }
        else{
            System.out.println("Error index issue");
        }
    }

    //the option text with the correctanswer
    public void generateQuestionText() {

        Random randy = new Random();
        int rand1, rand2;
        int result;
        rand1 = randy.nextInt(10);
        rand2 = randy.nextInt(10);
        //set the correctAnswer for the problem
        result = rand1*rand2;
        correctAnswer = Integer.toString(result);
        //set the questionText for the problem
        String q = "What is " + rand1 + " X " + rand2 + "?";
        questionText = q;
    }
}