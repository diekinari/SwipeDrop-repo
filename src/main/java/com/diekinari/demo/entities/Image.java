package com.diekinari.demo.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Image {

    private byte[] bytes;
    private String fileName;
    private String username; // addressee

    public Image(String username, String  fileName) {
        this.fileName = fileName;
        this.username = username;
    }

    public Image(byte[] bytes) {
        this.bytes = bytes;
    }

    public Image(byte[] bytes, String username, String fileName) {
        this.bytes = bytes;
        this.username = username;
        this.fileName = fileName;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
