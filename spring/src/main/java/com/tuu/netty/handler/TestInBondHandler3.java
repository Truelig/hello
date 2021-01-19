package com.tuu.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TestInBondHandler3 extends ChannelInboundHandlerAdapter  {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("inBond->3333");
        ctx.fireChannelActive();
    }

}
