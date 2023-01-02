package br.com.petz.handler;

public enum ExceptionName {
    BUSINESS_EXCEPTION("Message customized for business exception"),
    EXCEPTION("System currently unavailable");
    public final String message;

    ExceptionName(String message) {
        this.message = message;
    }
}