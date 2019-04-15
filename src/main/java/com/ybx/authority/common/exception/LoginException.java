package com.ybx.authority.common.exception;

public class LoginException extends Exception {

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Exception exception) {
        super(message, exception);
    }

}
