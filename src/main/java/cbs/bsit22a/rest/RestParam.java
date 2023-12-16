package cbs.bsit22a.rest;

public record RestParam(String key, String value) {

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
