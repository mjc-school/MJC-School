# Intro to OOP

## Contents
+ Design patterns
+ UML class diagram
+ Info handling task
+ Composite pattern
+ Chain of Responsibility
+ Interpreter

### Task
Implement an application that can parse text from file. Implement method that can calculate expressions in the text. 
Implement method that can build parsed text into String. The application also should be able to do three of the following operations:

+ Count sentences with equals words i.e. sentences that have two or more equal words
+ Sort sentences by lexeme count in ascending or descending order
+ In each sentence swap first and last lexeme
+ Sort lexeme inside a sentence in alphabetical order
+ Sort lexeme inside a sentence by letter count in ascending or descending order
+ Remove all words of the given length 
+ Remove all words that starts from a given letter
+ Reverse lexemes in sentences

* lexeme is either word or a mathematical expression

#### Requirements:

1. The text should be parsed into an object. This object should be a tree containing paragraphs, sentences, lexemes. The lexeme is either word or math expression. Use Composite pattern
2. Model classes should have no logic
3. You should be able to restore text from the object. Multiple spaces or table could be one space after restoration
4. Use regular expression to parse the text. In your code regular expressions should be constants.
5. Use Chain of Responsibility when parsing the text
6. Your parsers should be stateless, do not create unnecessary parser object, ideally you should have only one parser object (do not use singleton pattern).
7. You should be able to calculate math expressions . Использовать Interpreter.
8. Use Log4J2 for logging.
9. Should implements 3 additional logical operations on the text (see above)
10. No main class should be added. Use unit tests

#### Text sample

It has survived - not only (five) centuries, but also the leap into [13 x +] electronic typesetting, remaining [3 5 +] essentially [3 4 – 9 * 6 +] unchanged. It was popularised in the [ 20 1 - ] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.	

It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [71 2 * 3 +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.

It is a [5 y + 120 *] established fact that a reader will be of a page when looking at its layout.



