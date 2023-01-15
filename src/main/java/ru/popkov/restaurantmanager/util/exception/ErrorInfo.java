package ru.popkov.restaurantmanager.util.exception;

public class ErrorInfo {

    private final String url;
    private final String detail;

    public ErrorInfo(String url, String detail) {
        this.url = url;
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public String getDetail() {
        return detail;
    }
}
