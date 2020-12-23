package com.geng.protocol.xiangwang;

import com.geng.protocol.basic.Header;
import com.geng.protocol.basic.Message;
import com.geng.protocol.commons.XiangWang;

import javax.xml.ws.Response;

public class BP05 extends Message{

    public BP05(Header header, String content) {
        super(header, content);
    }
}
