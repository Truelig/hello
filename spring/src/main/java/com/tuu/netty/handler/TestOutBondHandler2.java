package com.tuu.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

public class TestOutBondHandler2 extends ChannelOutboundHandlerAdapter {

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println("outBond->2");
        ctx.connect( remoteAddress, localAddress, promise);
    }

}
