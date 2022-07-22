# JSON

## Overview
**JSON** stands for JavaScript Object Notation and is the most common data serialization language that is commonly used for
transmitting data in web applications, but it can be used for a variety of other applications as well.

It is basically a key-value pair much like a hashmap in java.

#### Data types used in JSON:
- `Numbers` 
- `Strings` 
- `Objects` 
- `Arrays`

### What is JSON?
- **JSON** is a lightweight data-interchange format 
- **JSON** is plain text written in JavaScript object notation 
- **JSON** is used to send data between computers 
- **JSON** is language independent *

### Advantages:
- In contrast to **XML**, far more human-readable due to a more compact syntax.
- Simpler syntax with limited markup.
- Quick for systems and languages to parse.
- JSONPath, like XPath, is available for complex queries.

### Disadvantages:
- No namespace, comment, or attribute support. 
- Simple structures may not support complex configurations.

### JSON vs XML
**XML** is much more difficult to parse than **JSON**.

**JSON** is parsed into a ready-to-use JavaScript object.

#### JSON is Like XML
- Both **JSON** and **XML** are "self describing" (human readable)
- Both **JSON** and **XML** are hierarchical (values within values)
- Both **JSON** and **XML** can be parsed and used by lots of programming languages 
- Both **JSON** and **XML** can be fetched with an XMLHttpRequest

#### JSON is Unlike XML
- **JSON** doesn't use end tag
- **JSON** is shorter
- **JSON** is quicker to read and write
- **JSON** can use arrays

## Example
```
{
    "properties":[
        {
            "name": "DataInPath",
            "value": "data/input"
        },
        {
            "name": "DataOutPath",
            "value": "data/output"
        }
    ]
}
```

### Comments
```
{
    "properties": {
        "name": "DataInPath",
        "value": "data/input",
        "comments": "This property defines the input path"
    }
}
```

## Materials
<https://www.w3schools.com/js/js_json_intro.asp>

<https://javascript.plainenglish.io/yaml-vs-json-vs-xml-what-to-choose-4c7a72417ff4>

<https://medium.com/black-book-for-data/json-vs-yaml-vs-xml-when-to-use-what-1994d4448335>
###
