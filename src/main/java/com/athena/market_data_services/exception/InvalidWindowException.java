package com.athena.market_data_services.exception;

public class InvalidWindowException extends RuntimeException {

    public InvalidWindowException(int window) {
        super("Invalid window size: " + window + ". Window must be > 1.");
    }
}
