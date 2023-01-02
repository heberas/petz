package br.com.petz.handler;

public enum ExceptionName {
    ID_NOT_FOUND_EXCEPTION("No record exist for given id"),
    EXCEPTION("System currently unavailable");
    public final String message;

    ExceptionName(String message) {
        this.message = message;
    }
}