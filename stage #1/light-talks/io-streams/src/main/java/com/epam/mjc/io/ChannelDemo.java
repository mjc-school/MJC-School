package main.java.com.epam.mjc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void copyWithBuffer() throws Exception {
        try (FileInputStream fis = new FileInputStream("demo1.txt");
             FileOutputStream fos = new FileOutputStream("demo_copy.txt")) {
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();
            ByteBuffer inBuffer = ByteBuffer.allocate(4096);
            ByteBuffer outBuffer = ByteBuffer.allocate(4096);
            int read = inChannel.read(inBuffer);
            while (read != -1) {
                inBuffer.flip();
                while (inBuffer.hasRemaining()) {
                    byte b = inBuffer.get();
                    outBuffer.put(b);
                }
                outBuffer.flip();
                outChannel.write(outBuffer);
                inBuffer.clear();
                outBuffer.clear();
                read = inChannel.read(inBuffer);
            }
        }
    }

    public static void transferTo() throws Exception {
        try (FileInputStream fis = new FileInputStream("demo1.txt");
             FileOutputStream fos = new FileOutputStream("demo_copy1.txt")) {
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
    }

    public static void main(String[] args) throws Exception {
        //copyWithBuffer();
        transferTo();
    }
}
