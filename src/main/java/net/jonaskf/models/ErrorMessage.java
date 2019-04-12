package net.jonaskf.models;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class ErrorMessage {
    private String title;
    private String message;
    private String stackTrace;

    public ErrorMessage(String title, String message, Exception exception) {
        this.title = title;
        this.message = message;
        this.stackTrace =  exceptionToString(exception);
    }

    private String exceptionToString(Exception exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return pw.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }
}
