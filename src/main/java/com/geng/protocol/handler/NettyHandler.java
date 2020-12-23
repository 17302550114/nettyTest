package com.geng.protocol.handler;

import com.geng.protocol.basic.Header;
import com.geng.protocol.basic.Message;
import com.geng.protocol.commons.XiangWang;
import com.geng.protocol.xiangwang.AP05;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {



        String mesaaageId = message.getHeader().getMessageId();
        Message messageResonse = null;
        switch (mesaaageId) {
            case XiangWang.终端注册: {//接收到终端注册包，返回终端应答
                AP05 ap05 = new AP05(new Header(message.getHeader().getMobileNo(), XiangWang.注册应答), null);
                System.out.println("接收到终端注册包");
                messageResonse = ap05;
                break;
            }
            case XiangWang.终端心跳:{
                System.out.printf("接收到终端心跳");
                break;
            }
            case XiangWang.等时连续上报位置消息:{
                System.out.printf("收到上报位置消息");
                break;
            }
            default:
                break;
        }
        ctx.pipeline().writeAndFlush(message);
    }
}
