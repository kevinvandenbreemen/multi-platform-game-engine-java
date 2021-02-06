package com.vandenbreemen.jmpge.cmd;

import com.vandenbreemen.jmpge.cmd.cmd.Command;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CommandInterpreter {

    public static final CommandInterpreter instance = new CommandInterpreter();

    private List<Command> commands;
    private PrintStream output;

    public CommandInterpreter() {
        this.commands = new ArrayList<>();
        this.output = System.out;
    }

    public void register(Command command) {
        this.commands.add(command);
    }

    public void handle(String command) {
        if(command == null || command.trim().isEmpty()) {
            return;
        }
        String instruction = command.split("[\\s]")[0].trim();
        commands.stream().filter(cmd -> cmd.getCommand().equals(instruction)).findFirst().ifPresent(cmd -> output.println(cmd.handle(
                command.substring(instruction.length()+1)
        )));
    }
}
