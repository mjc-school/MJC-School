package com.epam.esm.validation;

import com.epam.esm.dto.TagDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagDtoCheckingTest {

    @Test
    void checkTAgDto() {
        TagDto dto = new TagDto("like");
        boolean result = TagDtoChecking.checkTAgDto(dto);
        Assertions.assertTrue(result);
    }

    @Test
    void checkTAgDtoFalse() {
        TagDto dto = new TagDto("");
        TagDto dto1 = new TagDto(null);
        TagDto dto2 = new TagDto("   ");
        boolean result = TagDtoChecking.checkTAgDto(dto);
        boolean result1 = TagDtoChecking.checkTAgDto(dto1);
        boolean result2 = TagDtoChecking.checkTAgDto(dto2);
        Assertions.assertFalse(result);
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);

    }
}