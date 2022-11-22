# Data Serialization Languages

## Overview

Data serialization is a technique that translates structured data into a format that enables storage or sharing of the
digital information in a state that permits recovery of its original structure.

Choosing the data serialization format for an application should depend on factors such as human readability, the
complexity of data, and storage and speed limitations. Here are some of the common data serialization formats used to
ease the storage and sharing of data across the Internet.

|            JSON            |            YAML            |            XML             |
|:--------------------------:|:--------------------------:|:--------------------------:|
| JavaScript Object Notation | YAML Ain't Markup Language | eXtensible Markup Language | 
|      Data Interchange      |      Data Interchange      |      Markup Language       |
|            2002            |            2006            |            1996            |
|        Easy to read        |       Easier to read       |      A little complex      |
|            Fast            |            Fast            |            Slow            |
|       Map Structure        |       Map Structure        |       Tree Structure       |
|           .json            |           .yaml            |            .xml            |

### As a config file
**YAML** and **XML** work best as config files. Both provide the opportunity to add comments which are crucial when it
comes to the usage of config files. **XML** schema validation allows to ensure that the config is always in the correct
intended format which is a benefit.

**JSON** can also be used as a config file. In fact, many projects still use it as config. The only drawback is the
inability to add comments as comments. Instead, you need to add comments as an element sitting on top of the actual config.

## Materials
<https://ipcisco.com/lesson/data-serialization-languages-json-yaml-xml/>

<https://study-ccna.com/data-serialization-formats-json-yaml-xml/>

<https://www.electronicdesign.com/technologies/dev-tools/article/21800743/whats-the-difference-between-json-xml-and-yaml>

<https://medium.com/black-book-for-data/json-vs-yaml-vs-xml-when-to-use-what-1994d4448335>
###
