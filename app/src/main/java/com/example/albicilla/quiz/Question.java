package com.example.albicilla.quiz;

/**
 * Created by albicilla on 2016/11/22.
 */

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

}
