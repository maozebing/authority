package com.ybx.authority.common.exception;

public class CostomException extends Exception {

    public CostomException() {
        super();
    }

    public CostomException(String message) {
        super(message);
    }

    public CostomException(String message, Exception exception) {
        super(message, exception);
    }

}
