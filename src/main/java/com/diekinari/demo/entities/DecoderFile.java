package com.diekinari.demo.entities;

import java.io.IOException;

// wrapper class for first method
public class DecoderFile {

    private  byte[] bytes;
    private  String fileName;

    public DecoderFile(byte[] bytes, String filename) {
        this.bytes = bytes;
        this.fileName = filename;
    }


    public String getFileName() {
        return fileName;
    }


    public byte[] getBytes() throws IOException {
        return bytes;
    }




}
