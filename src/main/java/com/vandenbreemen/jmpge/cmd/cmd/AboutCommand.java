package com.vandenbreemen.jmpge.cmd.cmd;

public class AboutCommand implements Command {

    private static final String VERSION = "1.0.0";
    private static final String ABOUT = "Multi-Platform Game Engine in Java\nWritten by Kevin R. VanDenBreemen\nVersion " + VERSION;

    @Override
    public String getCommand() {
        return "ABOUT";
    }

    @Override
    public String handle(String arguments) {
        return ABOUT;
    }


}
