## Intellij Idea

Notes:
1. For students that recently started studying java, skip debugging part
2. For more experienced students skip IDE basics

Plan:
1. Introduction
    1. Knowing features allows you to write better code and do it much faster
    2. Intellij Idea has lots of features, we can't go through them today, so I selected some of them that I use frequently
    3. All these features are present in Community edition, and this edition is enough for work
2. IDE basics
    1. Project files to the left, working area to the right
    2. You can hide project (`-` sign)
    3. `Structure` - view methods and fields of a current class
    4. Run a hello world app with button to the left
    5. Rerun it with the button on top
    6. Show gradle tasks
        1. Clean - refresh project folder
        2. Build - refresh project folder
    7. Show command line - `gradlew clean`, `dir`
3. Hot keys
    1. `Alt + Enter` - at the end of the line, on varibale name
    2. `Ctrl + W` - selects the next valid expression in increasing sections. Select `if` blocks and nested method calls, show that you don't have to count brackets
    3. Basic text manipulation
        1. work for selected text or whole line - `Ctrl + C`, `Ctrl + V`, `Ctrl + X`, `Ctrl + D` (duplicate line)
        2. `Ctrl + Y` - delete line
        3. `Ctrl + Shift + V` - see buffer history
    4. `Shift + F6` - rename class, method, variable
    5. `Ctrl + /` - comments or uncomments current line or selected text block
    6. Find and replace
        1. `Ctrl + F` - show all 3 flags (case sensitive, words, regex search)
        2. `Ctrl + R`
        3. `Ctrl + Shift + F`
        4. `Ctrl + Shift + R`
    7. `Shift + Shift` - search everywhere. Show search of `ArrayList` and Plugins
    8. Refactoring
        1. `Ctrl + Alt + M` - extract ternary operation to a method
        2. `Ctrl + Alt + P` - extract `a` as a method param
        3. `Ctrl + Alt + C` - extract 2 as a constant
        4. `Ctrl + Alt + V` - extract nested method call to a variable
    9. `Ctrl + B` - go to definition. Show on variable, interface, constructor call, method call. Then show backward functionality, that shows all uses of a selected method
    10. `Alt + F7` - show all usages 
    11. `Alt + Insert` - mainly used for getters/setters, equals/hashCode/toString. Also useful to generate delegates
    12. `Ctrl + Alt + O` - optimize imports. Add redundant import and clean it
    13. `Ctrl + Alt + L` - reformat file
    14. How to start using hot keys, if there are so many of them - start using them one by one, for example study a new hotkey once a week
4. Live templates - <Demo_01> short abbreviations used for code generation
    1. `psvm`
    2. `fori`
    3. `sout`
    4. Open live templates menu, show template expression language. You can create your own templates if you write the same boilerplate code often. You can find guide to the expression language on jetbrains site
5. Debugging - <Demo_01>
    1. Why sout debugging doesn't work
        1. Not all code is editable
        2. Hard to read many souts
        3. Some code paths take to long to get to, and sout debugging requires many restarts of an app to add new souts
        4. Hands up everyone who used it at least once
    2. Explain demo code
    3. Simple debugging point - beginning of the `doComputations` method
        1. Debugging window - stacktrace, variables window, control pane
    4. Conditional point - `input == 0`
        1. Boolean condition
        2. N-th enter
        3. Expiring point 
6. Inspections
    1. Theory
        1. Static analysis of your code, which means that it uses only source files without running them
        2. There are many categories, some are enabled by default, some are disabled. You can change this setting, but defaults are reasonable
    2. Possible bugs - <Demo_01> string comparison with ==, when you should use `equals` method instead
    3. Performance <Demo_02> 
        1. bulk operation - they are faster than multiple operations with single element, because of possible internal optimizations
        2. string concat in loop
    4. Control flow - <Demo_03> redundant if
7. Plugins - open menu and show few selected plugins