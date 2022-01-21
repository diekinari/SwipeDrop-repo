package com.diekinari.demo.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    public Map<String, byte[]> pictureMap; // [ fileName : it's bytes]
}
