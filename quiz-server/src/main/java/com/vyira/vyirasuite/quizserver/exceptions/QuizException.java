package com.vyira.vyirasuite.quizserver.exceptions;

public class QuizException extends Exception {
    private static final long serialVersionUID = -4332836129035835139L;
    String errMsg;
    int errCode;

    public QuizException() {
        super();
    }

    public QuizException(int errCode) {
        this.errCode = errCode;
    }

    public QuizException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public QuizException(String errMsg) {
        this.errCode = 1001;
        this.errMsg = errMsg;
    }
}
