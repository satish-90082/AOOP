package com.logging;

public class InfoHandler extends LogHandler {
    @Override
    protected boolean canHandle() {
        return true; // INFO messages are always handled
    }

    @Override
    protected void process(String message) {
        System.out.println("[INFO] " + message);
    }
}