# StringBuffer (java.lang.StringBuffer)

## Overview
A thread-safe, mutable sequence of characters. A string buffer is like a **String**, but can be
modified.

```
    StringBuffer s = new StringBuffer("GeeksforGeeks");
```

| Method                                                          | Description                                                                                                               |
|-----------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| StringBuffer append(Object obj)                                 | Appends the string representation of the Object argument.                                                                 |
| StringBuffer append(StringBuffer sb)                            | Appends the specified StringBuffer to this sequence.                                                                      |
| StringBuffer appendCodePoint(int codePoint)                     | Appends the string representation of the codePoint argument to this sequence.                                             |
| int capacity()                                                  | Returns the current capacity.                                                                                             |
| StringBuffer delete(int start, int end)                         | Removes the characters in a substring of this sequence.                                                                   |
| StringBuffer deleteCharAt(int index)                            | Removes the char at the specified position in this sequence.                                                              |
| int indexOf(String str)                                         | Returns the index within this string of the first occurrence of the specified substring.                                  |
| int indexOf(String str, int fromIndex)                          | Returns the index within this string of the first occurrence of the specified substring, starting at the specified index. |
| StringBuffer insert(int index, char[] str, int offset, int len) | Inserts the string representation of a subarray of the str array argument into this sequence.                             |
| StringBuffer insert(int offset, Object obj)                     | Inserts the string representation of the Object argument into this character sequence.                                    |
| int lastIndexOf(String str)                                     | Returns the index within this string of the rightmost occurrence of the specified substring.                              |
| int lastIndexOf(String str, int fromIndex)                      | Returns the index within this string of the last occurrence of the specified substring.                                   |
| int length()                                                    | Returns the length (character count).                                                                                     |
| StringBuffer replace(int start, int end, String str)            | Replaces the characters in a substring of this sequence with characters in the specified String.                          |
| StringBuffer reverse()                                          | Causes this character sequence to be replaced by the reverse of the sequence.                                             |
| String substring(int start, int end)                            | Returns a new String that contains a subsequence of characters currently contained in this sequence.                      |
| void trimToSize()                                               | Attempts to reduce storage used for the character sequence.                                                               |

Constructors of **StringBuffer**:

| Constructor                    | Description                                                                                   | 
|--------------------------------|-----------------------------------------------------------------------------------------------|
| StringBuffer()                 | Constructs a string buffer with no characters in it and an initial capacity of 16 characters. |
| StringBuffer(CharSequence seq) | Constructs a string buffer that contains the same characters as the specified CharSequence.   |
| StringBuffer(int capacity)     | Constructs a string buffer with no characters in it and the specified initial capacity.       |
| StringBuffer(String str)       | Constructs a string buffer initialized to the contents of the specified string.               |

## String to StringBuffer
In **StringBuffer** class we can use the `append()` function which accepts **String** value and adds
it up to the current object.

```
    String s = "Hello world!";
    StringBuffer sb = new StringBuffer();
    sb.append(s);
```

This is one more simple way of creating a **StringBuffer** object from **String**. See this code as example:

```
    String string = "Hello world!";
    StringBuffer sb = new StringBuffer(string);
```

## StringBuffer to String
To convert a **StringBuffer** object into **String**, you can use the `toString()` method provided
by the **StringBuffer** class.

```
    StringBuffer sb = new StringBuffer("Hello world!");
    String advice = sb.toString();
```

# StringBuilder (java.lang.StringBuilder)

## Overview
A mutable sequence of characters. This class provides an API compatible with **StringBuffer**,
but with no guarantee of synchronization.

```
    StringBuilder str = new StringBuilder();
    str.append("GFG");
```

| Method                                                           | Description                                                                                                               |
|------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| StringBuilder append(Object obj)                                 | Appends the string representation of the Object argument.                                                                 |
| StringBuilder append(StringBuffer sb)                            | Appends the specified StringBuffer to this sequence.                                                                      |
| StringBuilder appendCodePoint(int codePoint)                     | Appends the string representation of the codePoint argument to this sequence.                                             |
| int capacity()                                                   | Returns the current capacity.                                                                                             |
| char charAt(int index)                                           | Returns the char value in this sequence at the specified index.                                                           |
| StringBuilder delete(int start, int end)                         | Removes the characters in a substring of this sequence.                                                                   |
| StringBuilder deleteCharAt(int index)                            | Removes the char at the specified position in this sequence.                                                              |
| int indexOf(String str)                                          | Returns the index within this string of the first occurrence of the specified substring.                                  |
| int indexOf(String str, int fromIndex)                           | Returns the index within this string of the first occurrence of the specified substring, starting at the specified index. |
| StringBuilder insert(int index, char[] str, int offset, int len) | Inserts the string representation of a subarray of the str array argument into this sequence.                             |
| StringBuilder insert(int offset, Object obj)                     | Inserts the string representation of the Object argument into this character sequence.                                    |
| int lastIndexOf(String str)                                      | Returns the index within this string of the rightmost occurrence of the specified substring.                              |
| int lastIndexOf(String str, int fromIndex)                       | Returns the index within this string of the last occurrence of the specified substring.                                   |
| int length()                                                     | Returns the length (character count).                                                                                     |
| StringBuilder replace(int start, int end, String str)            | Replaces the characters in a substring of this sequence with characters in the specified String.                          |
| StringBuilder reverse()                                          | Causes this character sequence to be replaced by the reverse of the sequence.                                             |
| String substring(int start)                                      | Returns a new String that contains a subsequence of characters currently contained in this character sequence.            |
| String substring(int start, int end)                             | Returns a new String that contains a subsequence of characters currently contained in this sequence.                      |
| void trimToSize()                                                | Attempts to reduce storage used for the character sequence.                                                               |

Constructors of **StringBuilder**:

| Constructor                     | Description                                                                                                      |
|---------------------------------|------------------------------------------------------------------------------------------------------------------|
| StringBuilder()                 | Constructs a string builder with no characters in it and an initial capacity of 16 characters.                   |
| StringBuilder(CharSequence seq) | Constructs a string builder that contains the same characters as the specified CharSequence.                     |
| StringBuilder(int capacity)     | Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument. |
| StringBuilder(String str)       | Constructs a string builder initialized to the contents of the specified string.                                 |

## String to StringBuilder
In **StringBuilder** class we can use the `append()` function which accepts **String** value and adds
it up to the current object.

```
    String s = "Hello world!";
    StringBuilder sb = new StringBuilder();
    sb.append(s);
```

This is one more simple way of creating a **StringBuilder** object from **String**. See this code as example:

```
    String string = "Hello world!";
    StringBuilder sb = new StringBuilder(string);
```

## StringBuilder to String
To convert a **StringBuilder** object into **String**, you can use the `toString()` method provided
by the **StringBuilder** class.

```
    StringBuilder sb = new StringBuilder("Hello world!");
    String advice = sb.toString();
```

## StringBuffer to StringBuilder
In **StringBuilder** class we can use the `append()` function which accepts **StringBuffer** value
and adds it up to the current object.

```
    StringBuffer sBuffer = new StringBuffer("Hello world!");
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(sBuffer);
```

# String vs StringBuffer vs StringBuilder
A list of differences between **StringBuffer** and **StringBuilder** is given below:

| Parameter    | String                                                      | StringBuffer                                   | StringBuilder                                    |
|--------------|-------------------------------------------------------------|------------------------------------------------|--------------------------------------------------|
| Storage      | String pool(Heap)                                           | Heap                                           | Heap                                             |
| Modifiable   | Immutable                                                   | Mutable                                        | Mutable                                          |
| Synchronized | Yes(Synchronized)                                           | Yes(Synchronized)                              | No(Asynchronous)                                 |
| Thread Safe  | Yes                                                         | Yes                                            | No                                               |
| Performance  | Fast                                                        | Slow                                           | Fast                                             |
| Java version | JDK 1.0                                                     | JDK 1.0                                        | JDK 1.5                                          |
| Syntax       | String var = "syntax";<p>String var = new String("syntax"); | StringBuffer var = new StringBuffer("Syntax"); | StringBuilder var = new StringBuilder("Syntax"); |


## Materials
<https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html>

<https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html>

<https://www.javatpoint.com/difference-between-stringbuffer-and-stringbuilder>
###
