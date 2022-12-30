package br.com.petz.handler;

public enum ExceptionName {
    BUSINESS_EXCEPTION("Message customized for business exception"),
    EXCEPTION("Message customized for exception");
    public final String message;

    ExceptionName(String message) {
        this.message = message;
    }
}