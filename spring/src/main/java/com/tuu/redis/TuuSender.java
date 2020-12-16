package com.tuu.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TuuSender {
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;

    public TuuSender() {
        try {
            socket = new Socket("192.168.11.246", 6380);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String set(String k, String v) {
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

    public String send(String command) {
        byte[] bytes = new byte[1024];
        try {
            outputStream.write(command.getBytes());
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
