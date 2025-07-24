package com.example.spring_solid_criteria.dto;

import java.time.Instant;

public class BaseApiResponseDto<T> {
    private T data;
    private boolean isSuccess;
    private String message;
    private int status;
    private String requestId;
    private String timestamp;

    public BaseApiResponseDto() {
        this.timestamp = Instant.now().toString();
    }

    public BaseApiResponseDto(T data, boolean isSuccess, String message, int status, String requestId) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.message = message;
        this.status = status;
        this.requestId = requestId;
        this.timestamp = Instant.now().toString();
    }

    // Getters & Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
