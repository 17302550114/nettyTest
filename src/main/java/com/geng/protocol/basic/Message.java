package com.geng.protocol.basic;

public class Message {
    private Header header;
    private String content;

    public Message(Header header, String content) {
        this.header = header;
        this.content = content;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;

    }

    @Override
    public String toString() {
        return "Message{" +
                "header=" + header +
                ", content='" + content + '\'' +
                '}';
    }
}
