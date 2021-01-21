package com.vyira.vyirasuite.quizserver.exceptions;

public class NotFoundException extends Exception {
    private static final long serialVersionUID = -2631372967481908960L;
    String errMsg;
    int errCode;

    public NotFoundException() {
        super();
    }

    public NotFoundException(int errCode) {
        this.errCode = errCode;
    }

    public NotFoundException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public NotFoundException(String errMsg) {
        this.errCode = 1001;
        this.errMsg = errMsg;
    }
}
