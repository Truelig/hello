package com.tuu.test;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 文件按行读取并写到其他文件
 */
public class TxtSplite {

    public static void main(String[] args) throws Exception {
        String fileName = "/application/test.txt";
        String rootPath = "/application/part";
        //每个文件的条数
        int total=5;
        List<String> lines = Files.readAllLines(Paths.get(fileName),
                Charset.defaultCharset());
        StringBuffer stringBuffer = new StringBuffer();
        FileChannel outFileChannel;
        //目测每个文件13M大小，这里设置缓冲区20m
        ByteBuffer byteBuffer= ByteBuffer.allocateDirect(1024 * 20);
        int sum = 0;
        int name = 0;
        for (String line : lines) {
            sum++;
            stringBuffer.append(line).append("\n");
            if (sum >= total) {
                outFileChannel = FileChannel.open(Paths.get(rootPath + "/part_" + name+".txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                byteBuffer.put(stringBuffer.toString().getBytes());
                byteBuffer.flip();
                outFileChannel.write(byteBuffer);
                byteBuffer.clear();
                name++;
                sum = 0;
                stringBuffer = new StringBuffer();
            }

        }
        outFileChannel = FileChannel.open(Paths.get(rootPath + "/part_" + name+".txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        byteBuffer.put(stringBuffer.toString().getBytes());
        byteBuffer.flip();
        outFileChannel.write(byteBuffer);
        byteBuffer.clear();



    }
}
