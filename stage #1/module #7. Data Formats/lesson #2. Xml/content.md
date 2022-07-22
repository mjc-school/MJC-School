# XML

## Overview

**XML** stands for eXtensible Markup Language and is (like the name suggests) a markup language unline **JSON** or **YML**.

**XML** is a software- and hardware-independent tool for storing and transporting data.

#### Data types used in XML:
- `boolean` 
- `integer` 
- `decimal` 
- `string` 
- `duration` 
- `dateTime` 
- `date` 
- `time`

### What is XML?
- **XML** is a markup language much like **HTML**
- **XML** was designed to store and transport data
- **XML** was designed to be self-descriptive

### The Difference Between XML and HTML:
- **XML** was designed to carry data - with focus on what data is
- **HTML** was designed to display data - with focus on how data looks
- **XML** tags are not predefined like **HTML** tags are

### Advantages:
- **XML** is a generalized language that easily allows different formats to be realized from a common syntax.
- Schemas exist for validation and creation of custom types, while namespaces avoid collisions between elements.
- XPath and XQuery facilitate complex queries into **XML** documents.

### Disadvantages:
- The **XML** language is verbose and often contains redundant syntax as you can see in the below example.
- Higher verbosity increases storage capacity and bandwidth needs.
- Not considered easily human-readable due to the descriptive nature of elements.

## Example
```
<?xml version="1.0"?>
<myInfo>
    <firstName>Sumeet</firstName>
    <lastName>Bhalla</lastName>
    <Age>100</Age>
    <Address>
        <street>100 fake St</street>
        <apartment>111</apartment>
        <city>Rogers</city>
        <state>AR</state>
    </Address>
    <string-array name="carsOwner">
        <item>ferrari</item>
        <item>lambo</item>
        <item>bmw</item>
    </string-array>
</myInfo>
```

### Comments
```
<Properties>
    <!-- This property defines the input path -->
    <Property>
        <Name>DataInPath</Name>
        <Value>data/input</Value>
    </Property>
</Properties>
```

## Materials
<https://medium.com/black-book-for-data/json-vs-yaml-vs-xml-when-to-use-what-1994d4448335>

<https://javascript.plainenglish.io/yaml-vs-json-vs-xml-what-to-choose-4c7a72417ff4>

<https://www.w3schools.com/xml/xml_whatis.asp>
###
