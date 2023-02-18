package com.epam.mjc.demo.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IdSaver {

    private final static Map<String, Long> ID_MAP = new HashMap<>();

    public Long getIdByName(String name) {
        return ID_MAP.get(name);
    }

    public void putPair(String name, Long id) {
        ID_MAP.put(name, id);
    }

}
