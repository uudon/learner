package com.uudon.learner.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

import static android.R.attr.y;

/**
 * Created by Administrator on 2016/12/29.
 */

public class SimpleQuestionInfo extends BmobObject implements Serializable {

    private static final long serialVersionUID = -2490136624590237240L;

    private String title;//题目
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;//正确答案
    private int id;//唯一键
    private boolean isDone;//是否做过 true 做过  false 没做过
    private String analysis;
    private int optionType;
    private String pictureUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getOptionType() {
        return optionType;
    }

    public void setOptionType(int optionType) {
        this.optionType = optionType;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public boolean isCorrectAnswer(String selectAnswer) {
        if(selectAnswer.equals(correctAnswer)){
            return true;
        }else if(selectAnswer.equals(correctAnswer)){
            return true;
        }else if(selectAnswer.equals(correctAnswer)){
            return true;
        }else if(selectAnswer.equals(correctAnswer)){
            return true;
        }else{
            return false;
        }
    }
}
