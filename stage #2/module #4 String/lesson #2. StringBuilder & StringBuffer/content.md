# StringBuffer (java.lang.StringBuffer)

## Overview
A thread-safe, mutable sequence of characters. A string buffer is like a **String**, but can be
modified.

```
    StringBuffer s = new StringBuffer("GeeksforGeeks");
```

| Method                                                                 | Description                                                                                                               |
|------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| StringBuffer append(boolean b)                                         | Appends the string representation of the boolean argument to the sequence.                                                |
| StringBuffer append(char c)                                            | Appends the string representation of the char argument to the sequence.                                                   |
| StringBuffer append(char[] str)                                        | Appends the string representation of the char array argument to this sequence.                                            |
| StringBuffer append(char[] str, int offset, int len)                   | Appends the string representation of a subarray of the char array argument to this sequence.                              |
| StringBuffer append(CharSequence s)                                    | Appends the specified CharSequence to this sequence.                                                                      |
| StringBuffer append(CharSequence s, int start, int end)                | Appends a subsequence of the specified CharSequence to this sequence.                                                     |
| StringBuffer append(double d)                                          | Appends the string representation of the double argument to this sequence.                                                |
| StringBuffer append(float f)                                           | Appends the string representation of the float argument to this sequence.                                                 |
| StringBuffer append(int i)                                             | Appends the string representation of the int argument to this sequence.                                                   |
| StringBuffer append(long lng)                                          | Appends the string representation of the long argument to this sequence.                                                  |
| StringBuffer append(Object obj)                                        | Appends the string representation of the Object argument.                                                                 |
| StringBuffer append(String str)                                        | Appends the specified string to this character sequence.                                                                  |
| StringBuffer append(StringBuffer sb)                                   | Appends the specified StringBuffer to this sequence.                                                                      |
| StringBuffer appendCodePoint(int codePoint)                            | Appends the string representation of the codePoint argument to this sequence.                                             |
| int capacity()                                                         | Returns the current capacity.                                                                                             |
| char charAt(int index)                                                 | Returns the char value in this sequence at the specified index.                                                           |
| int codePointAt(int index)                                             | Returns the character (Unicode code point) at the specified index.                                                        |
| int codePointBefore(int index)                                         | Returns the character (Unicode code point) before the specified index.                                                    |
| int codePointCount(int beginIndex, int endIndex)                       | Returns the number of Unicode code points in the specified text range of this sequence.                                   |
| StringBuffer delete(int start, int end)                                | Removes the characters in a substring of this sequence.                                                                   |
| StringBuffer deleteCharAt(int index)                                   | Removes the char at the specified position in this sequence.                                                              |
| void ensureCapacity(int minimumCapacity)                               | Ensures that the capacity is at least equal to the specified minimum.                                                     |
| void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)      | Characters are copied from this sequence into the destination character array dst.                                        |
| int indexOf(String str)                                                | Returns the index within this string of the first occurrence of the specified substring.                                  |
| int indexOf(String str, int fromIndex)                                 | Returns the index within this string of the first occurrence of the specified substring, starting at the specified index. |
| StringBuffer insert(int offset, boolean b)                             | Inserts the string representation of the boolean argument into this sequence.                                             |
| StringBuffer insert(int offset, char c)                                | Inserts the string representation of the char argument into this sequence.                                                |
| StringBuffer insert(int offset, char[] str)                            | Inserts the string representation of the char array argument into this sequence.                                          |
| StringBuffer insert(int index, char[] str, int offset, int len)        | Inserts the string representation of a subarray of the str array argument into this sequence.                             |
| StringBuffer insert(int dstOffset, CharSequence s)                     | Inserts the specified CharSequence into this sequence.                                                                    |
| StringBuffer insert(int dstOffset, CharSequence s, int start, int end) | Inserts a subsequence of the specified CharSequence into this sequence.                                                   |
| StringBuffer insert(int offset, double d)                              | Inserts the string representation of the double argument into this sequence.                                              |
| StringBuffer insert(int offset, float f)                               | Inserts the string representation of the float argument into this sequence.                                               |
| StringBuffer insert(int offset, int i)                                 | Inserts the string representation of the second int argument into this sequence.                                          |
| StringBuffer insert(int offset, long l)                                | Inserts the string representation of the long argument into this sequence.                                                |
| StringBuffer insert(int offset, Object obj)                            | Inserts the string representation of the Object argument into this character sequence.                                    |
| StringBuffer insert(int offset, String str)                            | Inserts the string into this character sequence.                                                                          |
| int lastIndexOf(String str)                                            | Returns the index within this string of the rightmost occurrence of the specified substring.                              |
| int lastIndexOf(String str, int fromIndex)                             | Returns the index within this string of the last occurrence of the specified substring.                                   |
| int length()                                                           | Returns the length (character count).                                                                                     |
| int offsetByCodePoints(int index, int codePointOffset)                 | Returns the index within this sequence that is offset from the given index by codePointOffset code points.                |
| StringBuffer replace(int start, int end, String str)                   | Replaces the characters in a substring of this sequence with characters in the specified String.                          |
| StringBuffer reverse()                                                 | Causes this character sequence to be replaced by the reverse of the sequence.                                             |
| void setCharAt(int index, char ch)                                     | The character at the specified index is set to ch.                                                                        |
| void setLength(int newLength)                                          | Sets the length of the character sequence.                                                                                |
| CharSequence subSequence(int start, int end)                           | Returns a new character sequence that is a subsequence of this sequence.                                                  |
| String substring(int start)                                            | Returns a new String that contains a subsequence of characters currently contained in this character sequence.            |
| String substring(int start, int end)                                   | Returns a new String that contains a subsequence of characters currently contained in this sequence.                      |
| String toString()                                                      | Returns a string representing the data in this sequence.                                                                  |
| void trimToSize()                                                      | Attempts to reduce storage used for the character sequence.                                                               |

Constructors of **StringBuffer**:

| Constructor                    | Description                                                                                   | 
|--------------------------------|-----------------------------------------------------------------------------------------------|
| StringBuffer()                 | Constructs a string buffer with no characters in it and an initial capacity of 16 characters. |
| StringBuffer(CharSequence seq) | Constructs a string buffer that contains the same characters as the specified CharSequence.   |
| StringBuffer(int capacity)     | Constructs a string buffer with no characters in it and the specified initial capacity.       |
| StringBuffer(String str)       | Constructs a string buffer initialized to the contents of the specified string.               |

# StringBuilder (java.lang.StringBuilder)

## Overview
A mutable sequence of characters. This class provides an API compatible with **StringBuffer**,
but with no guarantee of synchronization.

```
    StringBuilder str = new StringBuilder();
    str.append("GFG");
```

| Method                                                                  | Description                                                                                                               |
|-------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| StringBuilder append(boolean b)                                         | Appends the string representation of the boolean argument to the sequence.                                                |
| StringBuilder append(char c)                                            | Appends the string representation of the char argument to the sequence.                                                   |
| StringBuilder append(char[] str)                                        | Appends the string representation of the char array argument to this sequence.                                            |
| StringBuilder append(char[] str, int offset, int len)                   | Appends the string representation of a subarray of the char array argument to this sequence.                              |
| StringBuilder append(CharSequence s)                                    | Appends the specified character sequence to this Appendable.                                                              |
| StringBuilder append(CharSequence s, int start, int end)                | Appends a subsequence of the specified CharSequence to this sequence.                                                     |
| StringBuilder append(double d)                                          | Appends the string representation of the double argument to this sequence.                                                |
| StringBuilder append(float f)                                           | Appends the string representation of the float argument to this sequence.                                                 |
| StringBuilder append(int i)                                             | Appends the string representation of the int argument to this sequence.                                                   |
| StringBuilder append(long lng)                                          | Appends the string representation of the long argument to this sequence.                                                  |
| StringBuilder append(Object obj)                                        | Appends the string representation of the Object argument.                                                                 |
| StringBuilder append(String str)                                        | Appends the specified string to this character sequence.                                                                  |
| StringBuilder append(StringBuffer sb)                                   | Appends the specified StringBuffer to this sequence.                                                                      |
| StringBuilder appendCodePoint(int codePoint)                            | Appends the string representation of the codePoint argument to this sequence.                                             |
| int capacity()                                                          | Returns the current capacity.                                                                                             |
| char charAt(int index)                                                  | Returns the char value in this sequence at the specified index.                                                           |
| int codePointAt(int index)                                              | Returns the character (Unicode code point) at the specified index.                                                        |
| int codePointBefore(int index)                                          | Returns the character (Unicode code point) before the specified index.                                                    |
| int codePointCount(int beginIndex, int endIndex)                        | Returns the number of Unicode code points in the specified text range of this sequence.                                   |
| StringBuilder delete(int start, int end)                                | Removes the characters in a substring of this sequence.                                                                   |
| StringBuilder deleteCharAt(int index)                                   | Removes the char at the specified position in this sequence.                                                              |
| void ensureCapacity(int minimumCapacity)                                | Ensures that the capacity is at least equal to the specified minimum.                                                     |
| void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)       | Characters are copied from this sequence into the destination character array dst.                                        |
| int indexOf(String str)                                                 | Returns the index within this string of the first occurrence of the specified substring.                                  |
| int indexOf(String str, int fromIndex)                                  | Returns the index within this string of the first occurrence of the specified substring, starting at the specified index. |
| StringBuilder insert(int offset, boolean b)                             | Inserts the string representation of the boolean argument into this sequence.                                             |
| StringBuilder insert(int offset, char c)                                | Inserts the string representation of the char argument into this sequence.                                                |
| StringBuilder insert(int offset, char[] str)                            | Inserts the string representation of the char array argument into this sequence.                                          |
| StringBuilder insert(int index, char[] str, int offset, int len)        | Inserts the string representation of a subarray of the str array argument into this sequence.                             |
| StringBuilder insert(int dstOffset, CharSequence s)                     | Inserts the specified CharSequence into this sequence.                                                                    |
| StringBuilder insert(int dstOffset, CharSequence s, int start, int end) | Inserts a subsequence of the specified CharSequence into this sequence.                                                   |
| StringBuilder insert(int offset, double d)                              | Inserts the string representation of the double argument into this sequence.                                              |
| StringBuilder insert(int offset, float f)                               | Inserts the string representation of the float argument into this sequence.                                               |
| StringBuilder insert(int offset, int i)                                 | Inserts the string representation of the second int argument into this sequence.                                          |
| StringBuilder insert(int offset, long l)                                | Inserts the string representation of the long argument into this sequence.                                                |
| StringBuilder insert(int offset, Object obj)                            | Inserts the string representation of the Object argument into this character sequence.                                    |
| StringBuilder insert(int offset, String str)                            | Inserts the string into this character sequence.                                                                          |
| int lastIndexOf(String str)                                             | Returns the index within this string of the rightmost occurrence of the specified substring.                              |
| int lastIndexOf(String str, int fromIndex)                              | Returns the index within this string of the last occurrence of the specified substring.                                   |
| int length()                                                            | Returns the length (character count).                                                                                     |
| int offsetByCodePoints(int index, int codePointOffset)                  | Returns the index within this sequence that is offset from the given index by codePointOffset code points.                |
| StringBuilder replace(int start, int end, String str)                   | Replaces the characters in a substring of this sequence with characters in the specified String.                          |
| StringBuilder reverse()                                                 | Causes this character sequence to be replaced by the reverse of the sequence.                                             |
| void setCharAt(int index, char ch)                                      | The character at the specified index is set to ch.                                                                        |
| void setLength(int newLength)                                           | Sets the length of the character sequence.                                                                                |
| CharSequence subSequence(int start, int end)                            | Returns a new character sequence that is a subsequence of this sequence.                                                  |
| String substring(int start)                                             | Returns a new String that contains a subsequence of characters currently contained in this character sequence.            |
| String substring(int start, int end)                                    | Returns a new String that contains a subsequence of characters currently contained in this sequence.                      |
| String toString()                                                       | Returns a string representing the data in this sequence.                                                                  |
| void trimToSize()                                                       | Attempts to reduce storage used for the character sequence.                                                               |

Constructors of **StringBuilder**:

| Constructor                     | Description                                                                                                      |
|---------------------------------|------------------------------------------------------------------------------------------------------------------|
| StringBuilder()                 | Constructs a string builder with no characters in it and an initial capacity of 16 characters.                   |
| StringBuilder(CharSequence seq) | Constructs a string builder that contains the same characters as the specified CharSequence.                     |
| StringBuilder(int capacity)     | Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument. |
| StringBuilder(String str)       | Constructs a string builder initialized to the contents of the specified string.                                 |

## StringBuffer vs StringBuilder
A list of differences between **StringBuffer** and **StringBuilder** is given below:

| StringBuffer | StringBuilder   |
|--------------|-----------------|
| Mutable      | Mutable         |
| Synchronized | Asynchronous    |
| Thread safe  | Not Thread Safe |
| Slow         | Fast            |
| JDK 1.0      | JDK 1.5         |


## Materials
<https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html>

<https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html>

<https://www.javatpoint.com/difference-between-stringbuffer-and-stringbuilder>
###
