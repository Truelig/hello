package com.tuu.redis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TuuNioSender {
    SocketChannel socketChannel;

    public TuuNioSender(){
        try {
            this.socketChannel = SocketChannel.open(new InetSocketAddress("192.168.11.246",6380));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String send(String command){
        ByteBuffer out = ByteBuffer.allocate(1024);
        ByteBuffer in = ByteBuffer.allocate(1024);
        out.put(command.getBytes());
        try {
            out.flip();
            socketChannel.write(out);
            out.clear();
            socketChannel.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(in.array(),0,in.limit());
    }
    public String set(String k,String v){
        String command = CommandHelp.command(Command.SET, k.getBytes(), v.getBytes());
        return send(command);
    }

    public String get(String k) {
        String command = CommandHelp.command(Command.GET, k.getBytes());
        return send(command);
    }

    public String insc(String k) {
        String command = CommandHelp.command(Command.INCR, k.getBytes());
        return send(command);
    }
}
