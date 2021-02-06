package com.vandenbreemen.jmpge.cmd;

import com.vandenbreemen.jmpge.cmd.cmd.Command;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CommandInterpreterTest {

    private CommandInterpreter interpreter = new CommandInterpreter();

    @Test
    public void shouldHandleCommand() {
        AtomicReference<String> printed = new AtomicReference<>();
        interpreter.register(new Command() {
            @Override
            public String getCommand() {
                return "PRINT";
            }

            @Override
            public String handle(String arguments) {
                System.out.printf(arguments);
                printed.set(arguments);
                return arguments;
            }
        });
        interpreter.handle("PRINT HELLO WORLD");
        assertEquals(printed.get(), "HELLO WORLD");
    }

    @Test
    public void shouldHandleNullCommand() {
        AtomicReference<String> printed = new AtomicReference<>();
        interpreter.register(new Command() {
            @Override
            public String getCommand() {
                return "PRINT";
            }

            @Override
            public String handle(String arguments) {
                System.out.printf(arguments);
                printed.set(arguments);
                return arguments;
            }
        });
        interpreter.handle(null);
    }

    @Test
    public void shouldHandleNonExistentCommand() {
        AtomicReference<String> printed = new AtomicReference<>();
        interpreter.register(new Command() {
            @Override
            public String getCommand() {
                return "PRINT";
            }

            @Override
            public String handle(String arguments) {
                System.out.printf(arguments);
                printed.set(arguments);
                return arguments;
            }
        });
        interpreter.handle("NOSUCHCOMMAND test");
    }

}