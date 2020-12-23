package com.geng.protocol.codec;

import com.geng.protocol.basic.Header;
import com.geng.protocol.basic.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class Decode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int message_length = in.readableBytes();
        if (in.readByte() != '(') {
            return;
        }
        String mobileNo = in.slice(1, 12).toString(CharsetUtil.UTF_8);
        String messageId = in.slice(13, 4).toString(CharsetUtil.UTF_8);
        String messageBody = in.slice(17, message_length - 17).toString(CharsetUtil.UTF_8);
        System.out.println(""
                + "原信息:" + in.toString(CharsetUtil.UTF_8)
                + "\n消息总长度（字节）:" + in.readableBytes()
                + "\n手机号:" + mobileNo
                + "\n命令字:" + messageId
                + "\n消息体" + messageBody
        );
        Header header = new Header(mobileNo, messageId);
        System.out.printf("ha" + header.toString() + "\n");
        Message message = new Message(header, messageBody);
        System.out.println("滴滴滴"+ message.toString());
        out.add(message);
    }
}
