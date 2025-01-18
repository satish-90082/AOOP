package com.logging;

public abstract class LogHandler {
    protected LogHandler nextHandler;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(String message) {
        if (canHandle()) {
            process(message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }

    protected abstract boolean canHandle();

    protected abstract void process(String message);
}
