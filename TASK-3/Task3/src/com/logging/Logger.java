package com.logging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void processCommands() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command command = iterator.next();
            command.execute("Processing log...");
            iterator.remove(); // Remove command after execution
        }
    }
}

