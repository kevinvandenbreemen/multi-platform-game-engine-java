package com.vandenbreemen.jmpge.driver;

import com.vandenbreemen.jmpge.cmd.CommandInterpreter;
import com.vandenbreemen.jmpge.cmd.cmd.AboutCommand;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public class StartupHandler {

    private static Semaphore setupSem = new Semaphore(1);
    private static StartupHandler handler;
    public static StartupHandler get() {
        try {
            setupSem.acquire();
            if(handler == null) {
                handler = new StartupHandler();
                handler.registerCommands();
            }
            return handler;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            setupSem.release();
        }
    }

    private void registerCommands() {
        CommandInterpreter.instance.register(new AboutCommand());
    }



}
