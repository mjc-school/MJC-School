package com.epam.esm;

import com.epam.esm.dto.TagDto;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.exception.TagAlreadyExistsException;
import com.epam.esm.mapper.TagDtoMapper;
import com.epam.esm.util.CustomErrorCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {
    @Mock
    private TagDao tagDao;
    @Mock
    private TagDtoMapper tagDtoMapper;
    @InjectMocks
    private TagService tagService;

    private List<Tag> tagList = Arrays.asList(new Tag(1, "sport"), new Tag(2, "children"), new Tag(3, "beaty"));
    private Tag expectedTag = new Tag(1, "food");
    private Tag existedTag = new Tag(2, "children");

    @Test
    void findAllTagList() {
        Mockito.when(tagDao.findAllTagList()).thenReturn(tagList);
        List<Tag> tags = tagService.findAllTagList();
        Assertions.assertNotNull(tags);
        Assertions.assertEquals(3, tags.size());

    }

    @Test
    void findTag() {
        long id = 1;
        Mockito.when(tagDao.findTag(id)).thenReturn(expectedTag);
        Tag tag = tagService.findTag(id);
        Assertions.assertNotNull(tag);
        Assertions.assertEquals(expectedTag, tag);

    }

    @Test
    void findTagException() {
        long id = 100;
        Mockito.when(tagDao.findTag(id)).thenThrow(new NoSuchResourceException(CustomErrorCode.TAG));
        Throwable throwable = Assertions.assertThrows(NoSuchResourceException.class, () -> {
            tagService.findTag(id);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());

    }

    @Test
    void testFindTag() {
        String name = expectedTag.getNameTag();
        Mockito.when(tagDao.findTag(name)).thenReturn(expectedTag);
        Tag tag = tagService.findTag(name);
        Assertions.assertNotNull(tag);
        Assertions.assertEquals(expectedTag, tag);

    }

    @Test
    void deleteTag() {
        long id = 1;
        Mockito.when(tagDao.deleteTag(id)).thenReturn(1);
        Integer number = tagService.deleteTag(id);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);
    }

    @Test
    void deleteTagException() {
        long id = 100;
        Mockito.when(tagDao.deleteTag(id)).thenThrow(new NoSuchResourceException(CustomErrorCode.TAG));
        Throwable throwable = Assertions.assertThrows(NoSuchResourceException.class, () -> {
            tagService.findTag(id);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());

    }

    @Test
    void addNewTag() {
        TagDto tagDto = new TagDto(1, "food");
        Mockito.when(tagDao.addNewTag(expectedTag)).thenReturn(expectedTag);
        Mockito.when(tagDtoMapper.changeTagDtoToTag(tagDto)).thenReturn(expectedTag);
        Tag tag = tagService.addNewTag(tagDto);
        Assertions.assertNotNull(tag);
        Assertions.assertEquals(expectedTag, tag);
    }

    @Test
    void addNewTagException() {
        TagDto tagDto = new TagDto("children");
        Mockito.when(tagDtoMapper.changeTagDtoToTag(tagDto)).thenReturn(existedTag);
        Mockito.when(tagDao.addNewTag(expectedTag)).thenThrow(new TagAlreadyExistsException(CustomErrorCode.TAG));
        Throwable throwable = Assertions.assertThrows(TagAlreadyExistsException.class, () -> {
            tagService.addNewTag(tagDto);
        });
        Assertions.assertEquals(NoSuchResourceException.class, throwable.getClass());
    }


    @Test
    void testAddNewTag() {
        Mockito.when(tagDao.addNewTag(expectedTag)).thenReturn(expectedTag);
        Tag tag = tagService.addNewTag(expectedTag);
        Assertions.assertNotNull(tag);
        Assertions.assertEquals(expectedTag, tag);
    }
}