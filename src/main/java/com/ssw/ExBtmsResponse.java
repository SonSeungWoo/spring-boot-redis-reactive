package com.ssw;

import java.util.Collection;

public class ExBtmsResponse<T> {
    private int statusCode;
    private String message;
    private Collection<T> data;
    private T datum;

    private ExBtmsResponse(ExBtmsResponse.Builder<T> builder) {
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.data = builder.data;
        this.datum = builder.datum;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public Collection<T> getData() {
        return this.data;
    }

    public T getDatum() {
        return this.datum;
    }

    public static class Builder<T> {
        private int statusCode;
        private String message;
        private Collection<T> data;
        private T datum;

        public Builder(Collection<T> data) {
            this.data = data;
        }

        public Builder(T datum) {
            this.datum = datum;
        }

        public ExBtmsResponse.Builder message(BtmsCode traportCode) {
            this.statusCode = traportCode.getCode();
            this.message = traportCode.getMessage();
            return this;
        }

        public ExBtmsResponse build() {
            return new ExBtmsResponse<>(this);
        }
    }
}