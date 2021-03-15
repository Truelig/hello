package com.tuu.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class clientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接上了服务器");
        ctx.writeAndFlush(Unpooled.copiedBuffer("hi i am client...".getBytes()));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("收到服务器的消息"+(String)msg);
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("client receive msg :" + Unpooled.copiedBuffer(byteBuf).toString(CharsetUtil.UTF_8));
    }
}
