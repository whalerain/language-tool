package com.github.whalerain.javatool.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author ZhangXi
 */
public class ByteSocketServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new IdleStateHandler(5, 5, 10));
        pipeline.addLast(new FixedLengthFrameDecoder(10));
//        pipeline.addLast(new ByteArrayDecoder());

        pipeline.addLast(new ByteMessageHandler());
    }
}
