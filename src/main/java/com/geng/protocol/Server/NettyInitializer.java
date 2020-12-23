package com.geng.protocol.Server;

import com.geng.protocol.codec.Decode;
import com.geng.protocol.codec.Encode;
import com.geng.protocol.handler.NettyHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

public class NettyInitializer extends ChannelInitializer<SocketChannel> {

//    private  static  final Encode ENCODER = new Encode();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ByteBuf[] delimiter =  new ByteBuf[]{
            Unpooled.wrappedBuffer(new byte[]{')'}),
        };

        ChannelPipeline pipeline = socketChannel.pipeline();

        // 添加编解码器, 由于ByteToMessageDecoder的子类无法使用@Sharable注解,
        // 这里必须给每个Handler都添加一个独立的Decoder.
        pipeline.addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
        pipeline.addLast(new Encode());
        pipeline.addLast(new Decode());
        // 添加逻辑控制层
        pipeline.addLast(new NettyHandler());

    }
}
