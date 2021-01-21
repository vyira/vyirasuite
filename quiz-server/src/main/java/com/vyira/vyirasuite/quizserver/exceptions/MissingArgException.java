package com.vyira.vyirasuite.quizserver.exceptions;

public class MissingArgException extends Exception{
    private static final long serialVersionUID = -7831252398104609166L;
    String errMsg;
    int errCode;

    public MissingArgException() {
        super();
    }

    public MissingArgException(int errCode) {
        this.errCode = errCode;
    }

    public MissingArgException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public MissingArgException(String errMsg) {
        this.errCode = 1001;
        this.errMsg = errMsg;
    }
}
