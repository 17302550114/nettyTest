package com.geng.protocol.basic;

public class Header {

    //手机号
    private String mobileNo;

    //消息类型
    private String messageId;


    public Header(String mobileNo, String mesaaageId) {
//        this.version = version;
        this.mobileNo = mobileNo;
        this.messageId = mesaaageId;
    }


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Header{" +
                "mobileNo='" + mobileNo + '\'' +
                ", mesaaageId='" + messageId + '\'' +
                '}';
    }
}
