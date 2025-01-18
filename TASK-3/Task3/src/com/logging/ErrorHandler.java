package com.logging;


public class ErrorHandler extends LogHandler {
    @Override
    protected boolean canHandle() {
        return true; // ERROR messages are always handled
    }

    @Override
    protected void process(String message) {
        System.out.println("[ERROR] " + message);
    }
}
