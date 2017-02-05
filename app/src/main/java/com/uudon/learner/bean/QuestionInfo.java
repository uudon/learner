package com.uudon.learner.bean;

/**
 * Created by Administrator on 2016/12/27.
 */

public class QuestionInfo {

    public String questionId; // 试题主键
    public String questionTitle; // 试题题目
    public String QuestionType; // 试题类型
    public String analysis; // 试题分析
    public String correctAnswer; // 正确答案
    public String optionA; // 答案A
    public String optionB; // 答案B
    public String optionC; // 答案C
    public String optionD; // 答案D
    public String optionE; // 答案E
    public String questionScore; // 分值
    public String questionHasPic; // 是否是图片题0是1否
    public String isSelect; // 是否是选择状态
    public String QuestionFor; // （0模拟试题，1竞赛试题）

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionFor() {
        return QuestionFor;
    }

    public void setQuestionFor(String questionFor) {
        QuestionFor = questionFor;
    }

    public String getQuestionType() {
        return QuestionType;
    }

    public void setQuestionType(String questionType) {
        QuestionType = questionType;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
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

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public String getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(String questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionHasPic() {
        return questionHasPic;
    }

    public void setQuestionHasPic(String questionHasPic) {
        this.questionHasPic = questionHasPic;
    }

    public String getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
    }
}
