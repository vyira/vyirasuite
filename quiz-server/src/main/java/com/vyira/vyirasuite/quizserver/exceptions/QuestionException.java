package com.vyira.vyirasuite.quizserver.exceptions;

public class QuestionException extends Exception{
    private static final long serialVersionUID = -7898238106758069548L;
    String errMsg;
    int errCode;

    public QuestionException() {
        super();
    }

    public QuestionException(int errCode) {
        this.errCode = errCode;
    }

    public QuestionException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public QuestionException(String errMsg) {
        this.errCode = 1001;
        this.errMsg = errMsg;
    }
}
