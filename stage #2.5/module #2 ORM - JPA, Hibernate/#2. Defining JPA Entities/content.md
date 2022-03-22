## Materials

* 2.JPA Entities
* 2.1. Entity
* 2.2. The Entity annotations
* 2.3. Entity Relationships
* 2.4. Lazy Loading and Eager Loading

###2.1.Defining JPA Entities
####2.1. Entity
Entities in JPA are nothing but POJOs representing data that can be persisted to the database. An entity represents
a table stored in a database. Every instance of an entity represents a row in the table.

Each entity is associated with some metadata that represents the information of it. Instead of database, this metadata
is existed either inside or outside the class. This metadata can be in following forms: 

* **Annotation** - In Java, annotations are the form of tags that represents metadata. This metadata persist inside the class.
* **XML** - In this form, metadata persist outside the class in XML file.


#####2.2. The Entity annotations
All the JPA annotations are defined in the **javax.persistence** package. HHibernate Annotations are based on the JPA 2 
specification and supports all the features.

#####2.2.1. The Entity Annotation
Let's say we have a POJO called Customer which represents the data of a customer, and we would like to store it in the
database.

    public class Customer {
    // fields, getters and setters
    }
In order to do this, we should define an entity so that JPA is aware of it.
So let's define it by making use of the **@Entity** annotation. We must specify this annotation at the class level.
We must also ensure that the entity has a no-arg constructor and a primary key:

    @Entity
    public class Customer {
        // fields, getters and setters
    }
Because various JPA implementations will try subclassing our entity in order to provide their functionality, entity
classes must not be declared final.
#####2.2.2. The Id Annotation
Each JPA entity must have a primary key which uniquely identifies it. The **@Id** annotation defines the primary key. 
We can generate the identifiers in different ways which are specified by the **@GeneratedValue** annotation.

We can choose from four id generation strategies with the strategy element. **The value can be AUTO, TABLE, SEQUENCE,
or IDENTITY**.If we specify GenerationType.AUTO, the JPA provider will use any strategy it wants to generate the
identifiers.

    @Entity
    public class Customer {
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long id;
     private String name;
        // getters and setters
    }
#####2.2.3. The Table Annotation
In most cases, the name of the table in the database and the name of the entity will not be the same.
In these cases, we can specify the table name using the **@Table** annotation:

    @Entity
    @Table(name="CUSTOMER")
    public class Customer {
    
        // fields, getters and setters
    
    }
We can also mention the schema using the schema element:

     @Entity
     @Table(name="CUSTOMER", schema="SHOP")
     public class Customer {
         // fields, getters and setters
     }
Schema name helps to distinguish one set of tables from another. If we do not use the **@Table** annotation, the name
of the entity will be considered the name of the table.
#####2.2.4. The Column Annotation
We can use the **@Column** annotation to mention the details of a column in the table.
The **@Column** annotation has many elements such as name, length, nullable, and unique.

     @Entity
     @Table(name="CUSTOMER")
     public class Customer {
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
      private Long id;

      @Column(name="CUSTOMER_NAME", length=50, nullable=false, unique=false)
      private String name;
        
         // other fields, getters and setters
     }
The name element specifies the name of the column in the table. The length element specifies its length. The 
nullable element specifies whether the column is nullable or not, and the unique element specifies whether the column
is unique. If we don't specify this annotation, the name of the field will be considered the name of the column in the table.

#####2.2.5. The Transient Annotation
Sometimes, we may want to make a field non-persistent. We can use the **@Transient**  annotationto do so. It specifies 
that the field will not be persisted.For instance, we can calculate the age of a customer from the date of birth.


    @Entity
    @Table(name="CUSTOMER")
    public class Customer {
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
      private Long id;`

      @Column(name="CUSTOMER_NAME", length=50, nullable=false)
      private String name;
    
      @Transient
      private Integer age;
    
    // other fields, getters and setters
    }
As a result, the field age will not be persisted to the table.

#####2.2.6. The Enumerated Annotation
Sometimes, we may want to persist a Java enum type.
We can use the @Enumerated annotation to specify whether the enum should be persisted by name or by ordinal (default).

    public enum Gender {
    MALE,
    FEMALE
    }
    
    @Entity
    @Table(name="CUSTOMER")
    public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="CUSTOMER_NAME", length=50, nullable=false, unique=false)
    private String name;
    
    @Transient
    private Integer age;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    // other fields, getters and setters
#### 2.3.Entity Relationships
JPA defines four annotations for defining relationships between entities:
* @OneToOne
* @OneToMany
* @ManyToOne
* @ManyToMany

#### 2.3.1. One-to-one relationships
The **@OneToOne** annotation is used to define a one-to-one relationship between two entities. For example, you may have
a Customer entity that contains a customer's name, email,age, gender, but you may want to maintain additional information
about a customer (such as address) in a separate Address entity. The @OneToOne annotation
facilitates breaking down your data and entities this way.

The Customer class below has a single Address instance. The Address maps to a single Customer instance.

    @Entity
    public class Customer {
    @Id
    private Long id;
    private String email;
    @Column(name="CUSTOMER_NAME", length=50, nullable=false, unique=false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy="customerId")
    private Address adress;
    ...
    }

    @Entity
    public class Address {
    @Id
    private Long id;
    private String description;
    @OneToOne
    private Customer customer;
    ...
    }
The JPA provider uses Address's customer field to map Address to Customer. The mapping is specified in the mappedBy
attribute in the @OneToOne annotation.

#### 2.3.2.One-to-many and many-to-one relationships

The **@OneToMany** and **@ManyToOne** annotations facilitate both sides of the same relationship. Consider an example where an
Order can have only one Customer, but a Customer may have many orders. The Order entity would define a @ManyToOne
relationship with Customer and the Customer entity would define a @OneToMany relationship with Order.

    @Entity
    public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
    ...
    }

    @Entity
    public class Order {
    @Id
    private Long id;
    private Date date;
    Decimal amount;
    @ManyToOne 
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    ...
    }
    
In this case, the Customer class maintains a list of the orders made by that customer and the Order class maintains
a reference to its single customer. Additionally, the @JoinColumn specifies the name of the column in the Order table
to store the ID of the Customer.

#### 2.3.3. Many-to-many relationships
Finally, the **@ManyToMany** annotation facilitates a many-to-many relationship between entities. Here's a case where a
Order entity has multiple Items and Item can be included in different orders:

    @Entity
    public class Order {
    @Id
    private Long id;
    private Date date;
    Decimal amount;
    @ManyToMany
    @JoinTable(name="ORDER_ITEM",
    joinColumns=@JoinColumn(name="ORDER_ID"),
    inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
    private Set<Item> items = new HashSet<>();
    ...
    }

    @Entity
    public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "order")
    private Set<Order> orders = new HashSet<>();
    ...
    }
In this example, we create a new table, ORDER_ITEM, with two columns: ORDER_ID and ITEM_ID. Using the joinColumns and
inverseJoinColumns attributes tells your JPA framework how to map these classes in a many-to-many relationship.
The @ManyToMany annotation in the Item class references the field in the Order class that manages the relationship;
namely the items property.

#####2.4. Lazy Loading and Eager Loading
JPA  specification defines two major strategies of loading data (Lazy and Eager):
* **EAGER** strategy is a requirement on the persistence provider runtime that data must be eagerly fetched;
* **LAZY** strategy is a hint to the persistence provider runtime that data should be fetched lazily when it is first
  time accessed.

The Lazy loading is commonly used to defer the loading of the attributes or associations of an entity or entities until
the point at which they are needed, meanwhile the eager loading is an opposite concept in which the attributes and
associations of an entity or entities are fetched explicitly and without any need for pointing them.

    @Entity
    public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
    ...
    }

    @Entity
    public class Order {
    @Id
    private Long id;
    private Date date;
    Decimal amount;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    ...
    }