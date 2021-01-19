package com.tuu.netty;

import com.tuu.netty.handler.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;

public class TestServer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpClientCodec",new HttpClientCodec());
        pipeline.addLast("testInBondHandler1",new TestInBondHandler1());
        pipeline.addLast("testInBondHandler2",new TestInBondHandler2());
        pipeline.addLast("testInBondHandler3",new TestInBondHandler3());
        pipeline.addLast("testOutBondHandler1",new TestOutBondHandler1());
        pipeline.addLast("testOutBondHandler2",new TestOutBondHandler2());
        pipeline.addLast("testOutBondHandler3",new TestOutBondHandler3());
    }
}
