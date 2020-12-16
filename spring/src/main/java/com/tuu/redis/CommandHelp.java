package com.tuu.redis;

public class CommandHelp {
    private static final String STAR = "*";
    private static final String LENGTH = "$";
    private static final String LINE = "\r\n";
    public static String command(Command command,byte[]... bytes){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(STAR).append(bytes.length+1).append(LINE);
        stringBuffer.append(LENGTH).append(command.toString().length()).append(LINE);
        stringBuffer.append(command).append(LINE);
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(LENGTH).append(bytes[i].length).append(LINE);
            stringBuffer.append(new String(bytes[i])).append(LINE);
        }

        return stringBuffer.toString();
    }
}
