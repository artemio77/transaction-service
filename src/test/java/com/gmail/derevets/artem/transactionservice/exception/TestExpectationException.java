package com.gmail.derevets.artem.transactionservice.exception;

public class TestExpectationException extends RuntimeException {

    public TestExpectationException(String s, Throwable throwable) {
        super(s, throwable);
    }
}