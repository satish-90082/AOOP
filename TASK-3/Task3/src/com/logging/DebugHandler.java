package com.logging;

public class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle() {
        return true; // DEBUG messages are always handled
    }

    @Override
    protected void process(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
