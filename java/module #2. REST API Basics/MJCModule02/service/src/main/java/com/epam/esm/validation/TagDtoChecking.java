package com.epam.esm.validation;

import com.epam.esm.dto.TagDto;

import java.util.stream.Stream;

public class TagDtoChecking {
    public static boolean checkTAgDto (TagDto tagDto) {
        boolean result = true;
        if (tagDto.getNameTag() == null || tagDto.getNameTag().isEmpty() || tagDto.getNameTag().isBlank()) {
            result = false;
        }

        return result;
    }
}
