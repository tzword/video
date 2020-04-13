package com.tzword.demo.dto;

public class ResponseDto {
    private String resultCode;
    private String resultMessage;
    private Long timestamp;
    private ResponseBusinessDto resultData;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ResponseBusinessDto getResultData() {
        return resultData;
    }

    public void setResultData(ResponseBusinessDto resultData) {
        this.resultData = resultData;
    }
}
