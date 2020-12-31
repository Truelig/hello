package com.tuu.test;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Test3 {


    public static void main(String[] args) throws Exception {
        Date start = new Date();
        FileChannel inFileChannel = FileChannel.open(Paths.get("/root/miaodi.zip"), StandardOpenOption.READ);
        FileChannel outFileChannel = FileChannel.open(Paths.get("/root/8.zip"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 3);
        while (inFileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outFileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        Date end = new Date();
        System.out.println((end.getTime() - start.getTime()));
        outFileChannel.close();
        inFileChannel.close();
    }
}
