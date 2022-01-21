package com.diekinari.demo.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    public Map<String, Picture> fileMap; // [username : [his Picture object]]

}
