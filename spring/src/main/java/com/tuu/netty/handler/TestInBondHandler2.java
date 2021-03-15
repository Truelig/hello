package com.tuu.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TestInBondHandler2 extends ChannelInboundHandlerAdapter  {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("inBond->2222");
        ctx.fireChannelActive();
    }

}
