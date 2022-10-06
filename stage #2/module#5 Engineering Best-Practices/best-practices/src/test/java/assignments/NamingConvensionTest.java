package assignments;

import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.SneakyThrows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NamingConvensionTest {
    LocalProcessor localProcessor = new LocalProcessor();
    Class<? extends LocalProcessor> aClass = localProcessor.getClass();
    @BeforeEach
    void init () {

    }
    @Test
     void variableModifiersTest() {
        for (Field field : aClass.getDeclaredFields()) {
            assertThat(field.getModifiers()).isNotEqualTo(Modifier.PUBLIC);
            assertThat(field.getModifiers()).isNotZero();
        }
    }

    @Test
     void variableNamingTest() {
        for (Field field : aClass.getDeclaredFields()) {
            assertThat(field.getName()).doesNotContain(List.of("valueofCheap", "informationscanner", "ProcessorVersion"));
        }
    }

    @Test
     void methodNamingTest() {
        for (Method method : aClass.getDeclaredMethods()) {
            assertThat(method.getName()).doesNotContain(List.of("readfullprocessorname", "thismethodreturnstring", "listiterator"));
        }
    }

    @Test
    @SneakyThrows
     void catchTest() {
        Method method = Arrays.stream(aClass.getDeclaredMethods())
                .filter(method1 -> method1.isAnnotationPresent(ReadFullProcessorNameAnnotation.class))
                .findFirst().orElseThrow(() -> new RuntimeException("Annotation was delete"));
        assertDoesNotThrow(() -> method.invoke(localProcessor, new File("src/main/resources/text.txt")));
        assertThrows(IllegalStateException.class, () -> localProcessor.getInformationScanner().hasNext());
    }

    @Test
     void stringBuilderTest() {
        assertThat(aClass.getDeclaredFields())
                .extracting(field -> field.getType().getName())
                .contains(StringBuilder.class.getTypeName());
    }

    @Test
     void interfaceDeclarationTest() {
        assertThat(aClass.getDeclaredFields())
                .extracting(field -> field.getType().getName())
                .doesNotContainAnyElementsOf(List.of(ArrayList.class.getTypeName(), LinkedList.class.getName()));
    }

    @Test
    @SneakyThrows
     void listIterateTest() {
        List<String> stringList = new ArrayList<>();
        List<String> stringLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add(null);
            stringLinkedList.add(null);
        }
        Method method = Arrays.stream(aClass.getDeclaredMethods())
                .filter(method1 -> method1.isAnnotationPresent(ListIteratorAnnotation.class))
                .findFirst().orElseThrow(()-> new RuntimeException("Annotation was delete"));
        assertDoesNotThrow(() -> method.invoke(localProcessor, stringList));
        assertDoesNotThrow(() -> method.invoke(localProcessor, stringLinkedList));
    }
}