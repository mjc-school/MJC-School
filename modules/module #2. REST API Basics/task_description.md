# Rest API Basics

The goal of this task is to build simple REST service. 

You will learn modern web applications architecture and technologies used to develop them.

## Sub-module #1

Sub-module description

### Task #1

#### Business requirements

General model requirements:
* At least two entities.
* Entities are in many-to-many relationship.
* **Main entity** has at least 6 meaningful fields.

Suggested model:

* Gift Certificate:
  * name
  * description
  * price
  * date of creation
  * date of modification
  * duration in days <ins>(expiration period)</ins>

The system should expose REST API to perform the following operations:
* CRUD operations for **main entity**.
  * If <ins>new secondary objects</ins> are passed during creation/modification of main entity –they should be persisted in DB.
* CRD operations for **secondary entity**.
* Filter **main entity objects** (all params are *optional* and ***can be used in conjunction***).
  * <ins>*by*</ins> **secondary entity field**.
  * <ins>*search*</ins> by part of **text field**(*should be implemented using DB function call*).
  * <ins>*sort*</ins> by **date field/text field**.
  
### Materials (Videos & Links)

* Some video link
* Some other video link
* Some link to external training
* Some link to resource
