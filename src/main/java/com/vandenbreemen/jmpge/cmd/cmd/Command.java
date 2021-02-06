package com.vandenbreemen.jmpge.cmd.cmd;

public interface Command {

    /**
     * Get the command
     * @return
     */
    String getCommand();

    String handle(String arguments);

}
