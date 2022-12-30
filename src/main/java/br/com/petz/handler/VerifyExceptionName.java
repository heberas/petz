package br.com.petz.handler;

public enum VerifyExceptionName {
    BUSINESS_EXCEPTION("Message customized for business exception"),
    EXCEPTION("Message customized for exception");
    public final String message;

    VerifyExceptionName(String message) {
        this.message = message;
    }
}