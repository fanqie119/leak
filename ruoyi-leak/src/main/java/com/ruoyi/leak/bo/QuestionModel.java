package com.ruoyi.leak.bo;


import lombok.Data;

@Data
public class QuestionModel {

    private String question;

    public QuestionModel(String question){
        this.question = question;
    }
}
