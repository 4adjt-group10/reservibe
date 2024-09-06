package com.reservibe.domain.generic.output;

public class OutputStatus {

    private final int code;
    private final String codeName;
    private final String message;

    public OutputStatus(int code, String codeName, String message){
        this.code = code;
        this.codeName = codeName;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getMessage() {
        return message;
    }
}
