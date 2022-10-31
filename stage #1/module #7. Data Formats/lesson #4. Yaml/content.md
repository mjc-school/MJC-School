# YAML

## Overview

**YAML** is a digestible data serialization language often used to create configuration files with any programming
language. Designed for human interaction, **YAML** is a strict superset of **JSON**, another data serialization
language. But because it's a strict superset, it can do everything that **JSON** can and more.

#### Data types used in YAML:
- `Numbers`
- `Strings`
- `Null values`
- `Boolean`
- `Dates` and `timestamps`
- `Sequences`
- `Nested values`

### Advantages:
- The syntax is highly human-readable. 
- Compact syntax, which uses Python-style indentation to denote structure.

### Disadvantages:
- The indentation format is prone to syntax and validation errors. 
- Portability with certain types may not exist due to a lack of features across all languages. 
- Debugging is difficult, due to the declarative nature of **YAML**. 
- Breakpoints and similar functionality do not exist.

### YAML vs JSON
| YAML                                                                                   | JSON                                                   |
|----------------------------------------------------------------------------------------|--------------------------------------------------------|
| Comments are denoted with a hash/number sign.                                          | Comments are not allowed.                              |
| Hierarchy is denoted by using double space characters. Tab characters are not allowed. | Objects and Arrays are denoted in braces and brackets. |
| String quotes are optional but it supports single and double quotes.                   | Strings must be in double quotes.                      |
| Root node can be any of the valid data types.                                          | Root node must either be an array or an object.        |

## Example
```
myInfo:
    firstName: Sumeet
    lastName: Bhalla
    Age:100
    Address:
        street:100 fake St
        apartment":111
        city":Rogers
        state:AR
    carsOwner:
        - ferrari
        - lambo
        - bmw
```

### Comments
```
property:
    #This property defines the input path
    - name: DataInPath
      value: data/input
```

## Materials
<https://medium.com/black-book-for-data/json-vs-yaml-vs-xml-when-to-use-what-1994d4448335>

<https://javascript.plainenglish.io/yaml-vs-json-vs-xml-what-to-choose-4c7a72417ff4>

<https://www.geeksforgeeks.org/what-is-the-difference-between-yaml-and-json/>
###
