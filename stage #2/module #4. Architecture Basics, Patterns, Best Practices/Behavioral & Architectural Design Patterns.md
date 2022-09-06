# Behavioral Design Pattern

## Strategy

In Strategy pattern, a class behavior or its algorithm can be changed at run time. In Strategy pattern, we create
objects which represent various strategies and a context object whose behavior varies as per its strategy object. The
strategy object changes the executing algorithm of the context object.
![Strategy UML](img/Strategy%20UML.png)

```java
public interface Strategy {
    public int execute(int a, int b);
}

public class ConcreteStrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyAdd's execute()");
        return a + b;
    }
}

public class ConcreteStrategySubtract implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategySubtract's execute");
        return a - b;
    }
}

public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyMultiply's execute");
        return a * b;
    }
}

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

public class Example {
    public static void main(String[] args) {
        Context context;
        // Three contexts following different strategies
        context = new Context(new ConcreteStrategyAdd());
        System.out.println(String.format("Result using add strategy: %s", context.executeStrategy(3, 4)));
        context = new Context(new ConcreteStrategySubtract());
        System.out.println(String.format("Result using subtract strategy: %s", context.executeStrategy(3, 4)));
        context = new Context(new ConcreteStrategyMultiply());
        System.out.println(String.format("Result using multiply strategy: %s", context.executeStrategy(3, 4)));
    }
}
```

Output:
> Called ConcreteStrategyAdd's execute()  
> Result using add strategy: 7  
> Called ConcreteStrategySubtract's execute  
> Result using subtract strategy: -1  
> Called ConcreteStrategyMultiply's execute  
> Result using multiply strategy: 12

## State

The state pattern is a behavioral software design pattern that allows an object to alter its behavior when its internal
state changes. This pattern is close to the concept of finite-state machines. The state pattern can be interpreted as a
strategy pattern, which is able to switch a strategy through invocations of methods defined in the pattern's interface.
The state pattern is used in computer programming to encapsulate varying behavior for the same object, based on its
internal state. This can be a cleaner way for an object to change its behavior at runtime without resorting to
conditional statements and thus improve maintainability.
![State UML](img/State%20UML.png)

```java
public interface DoorState {
    void action();

    DoorState getNextState();
}

public class OpenState implements DoorState {
    private static DoorState nextState = new ClosedState();

    @Override
    public void action() {
        System.out.println("The door was closed.");
    }

    @Override
    public DoorState getNextState() {
        return nextState;
    }
}

public class ClosedState implements DoorState {
    private static DoorState nextState = new OpenState();

    @Override
    public void action() {
        System.out.println("The door was opened.");
    }

    @Override
    public DoorState getNextState() {
        return nextState;
    }
}

public class Context {
    private DoorState currentState = new ClosedState();

    public void action() {
        currentState.action();
        DoorState nextState = currentState.getNextState();
        setCurrentState(nextState);
    }

    public void setCurrentState(DoorState currentState) {
        this.currentState = currentState;
    }
}

public class Example {
    public static void main(String[] args) {
        Context context = new Context();
        for (int i = 0; i < 5; i++) {
            context.action();
        }
    }
}
```

Output:
> The door was opened.  
> The door was closed.  
> The door was opened.  
> The door was closed.  
> The door was opened.

## Observer

The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its
dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their
methods. It is mainly used for implementing distributed event handling systems, in "event driven" software.  
The Observer pattern addresses the following problems:

- A one-to-many dependency between objects should be defined without making the objects tightly coupled.
- It should be ensured that when one object changes state, an open-ended number of dependent objects are updated
  automatically.
- It should be possible that one object can notify an open-ended number of other objects.

### Observer UML

![Observer UML](img/Observer%20UML.png)

```java
public interface Observable {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}

public interface Observer {
    void handleEvent(CubeEvent event);
}

public class CubeEvent extends EventObject {

    public CubeEvent(Object source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }
}

public class Cube implements Observable {
    private int side;
    private List<Observer> observers = new ArrayList<>();

    public Cube(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        CubeEvent event = new CubeEvent(this);
        observers.forEach(observer -> observer.handleEvent(event));
    }
}

public class VolumeObserver implements Observer {
    @Override
    public void handleEvent(CubeEvent event) {
        Cube cube = event.getSource();
        int side = cube.getSide();
        int volume = side * side * side;
        System.out.println("Volume = " + volume);
    }
}

public class SurfaceSquareObserver implements Observer {
    @Override
    public void handleEvent(CubeEvent event) {
        Cube cube = event.getSource();
        int side = cube.getSide();
        int surfaceSquare = side * side * 6;
        System.out.println("Surface square = " + surfaceSquare);
    }
}

public class Example {
    public static void main(String[] args) {
        Cube cube = new Cube(3);
        cube.addObserver(new VolumeObserver());
        cube.addObserver(new SurfaceSquareObserver());
        cube.setSide(5);
        System.out.println("================================");
        cube.setSide(7);
    }
}
```

Output:
> Volume = 125  
> Surface square = 150  
> ================================  
> Volume = 343  
> Surface square = 294

## Command

Command pattern is a data driven design pattern and falls under behavioral pattern category. A request is wrapped under
an object as command and passed to invoker object. Invoker object looks for the appropriate object which can handle this
command and passes the command to the corresponding object which executes the command.

### Command UML

![Command UML](img/Command%20UML.png)

```java
public interface Command {
    void execute();
}

public class Light {
    public void turnOn() {
        System.out.println("Light is on ");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

public class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

public class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

public class LightSwitcher {
    private Command turnOnCommand;
    private Command turnOffCommand;

    public LightSwitcher(Command turnOnCommand, Command turnOffCommand) {
        this.turnOnCommand = turnOnCommand;
        this.turnOffCommand = turnOffCommand;
    }

    public void on() {
        turnOnCommand.execute();
    }

    public void off() {
        turnOffCommand.execute();
    }
}

public class Invoker {
    public static void main(String[] args) {
        Light light = new Light();
        TurnOnCommand turnOnCommand = new TurnOnCommand(light);
        TurnOffCommand turnOffCommand = new TurnOffCommand(light);
        LightSwitcher lightSwitcher = new LightSwitcher(turnOnCommand, turnOffCommand);
        lightSwitcher.on();
        lightSwitcher.off();
    }
}
```

## Template

In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can
override the method implementation as per need but the invocation is to be in the same way as defined by an abstract
class.
![Template UML](img/Template%20method%20UML.png)

```java
abstract class CheckBackground {
    public abstract void checkBank();

    public abstract void checkCredit();

    public abstract void checkLoan();

    public abstract void checkStock();

    public abstract void checkIncome();

    //work as template method
    public void check() {
        checkBank();
        checkCredit();
        checkLoan();
        checkStock();
        checkIncome();
    }
}
```

# Architectural Patterns

## Layered Pattern

Image result for layered pattern
Layered architecture patterns are n-tiered patterns where the components are organized in horizontal layers. This is the
traditional method for designing most software and is meant to be self-independent. This means that all the components
are interconnected but do not depend on each other.  
This pattern can be used to structure programs that can be decomposed into groups of subtasks, each of which is at a
particular level of abstraction. Each layer provides services to the next higher layer.  
The most commonly found 5 layers of a general information system:

- Presentation layer (also known as UI layer)
- Application layer (also known as service layer)
- Business logic layer (also known as domain layer)
- Data access layer (also known as persistence layer)
- Database layer

![Layered Pattern](img/Layered%20Pattern.png)

The most commonly used patterns for the data access layer are the DAO and Repository patterns.

## DAO (Data Access Object Pattern)

Data Access Object Pattern or DAO pattern is used to separate low level data accessing API or operations from high level
business services. Following are the participants in Data Access Object Pattern.

- **Data Access Object Interface** - This interface defines the standard operations to be performed on a model object(s)
  .
- **Data Access Object concrete class** - This class implements above interface. This class is responsible to get data
  from a
  data source which can be database / xml or any other storage mechanism.
- **Model Object or Value Object** - This object is simple POJO containing get/set methods to store data retrieved using
  DAO class.

  There are many advantages for using DAO pattern. Let’s state some of them here:

1. While changing a persistence mechanism, service layer doesn’t even have to know where the data comes from. For
   example,
   if you’re thinking of shifting from using MySQL to MongoDB, all changes are needed to be done in the DAO layer only.
2. DAO pattern emphasis on the low coupling between different components of an application. So, the View layer have no
   dependency on DAO layer and only Service layer depends on it, even that with the interfaces and not from concrete
   implementation.
3. As the persistence logic is completely separate, it is much easier to write Unit tests for individual components. For
   example, if you’re using JUnit and Mockito for testing frameworks, it will be easy to mock the individual components
   of
   your application.
4. As we work with interfaces in DAO pattern, it also emphasizes the style of “work with interfaces instead of
   implementation” which is an excellent OOPs style of programming.
   ![DAO](img/DAO.png)

```java
public class User {
    private int id;
    private String login;
    private String password;
    private String name;

    public User() {
    }

    public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }
    //Getters, Setters, Equals, Hashcode, toString
}

public interface UserDao {
    List<User> findAll();

    Optional<User> findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    boolean deleteById(int id);
}

public class UserDaoImpl implements UserDao {
    //list is working as a database only for example
    private List<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User(1, "login1", "password1", "name1"));
        users.add(new User(2, "login2", "password2", "name2"));
        users.add(new User(3, "login3", "password3", "name3"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> optionalUser = findById(user.getId());
        if (optionalUser.isPresent()) {
            users.remove(optionalUser.get());
            users.add(user.getId() - 1, user);
        } else {
            // Only for example ! Should be thrown exception like incorrect method call
            saveUser(user);
        }
    }

    @Override
    public boolean deleteById(int id) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isPresent()) {
            users.remove(id);
            return true;
        }
        return false;
    }
}

public class Example {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        for (User user : userDao.findAll()
        ) {
            System.out.println(user);
        }
        System.out.println(" =================================================================  ");
        Optional<User> optionalUser = userDao.findById(1);
        if (optionalUser.isPresent()) {
            User userForUpdate = optionalUser.get();
            userForUpdate.setName("UPDATED");
            userDao.updateUser(userForUpdate);
        }
        for (User user : userDao.findAll()
        ) {
            System.out.println(user);
        }
    }
}
```

Output:
> User{id=1, login='login1', password='password1', name='name1'}  
> User{id=2, login='login2', password='password2', name='name2'}  
> User{id=3, login='login3', password='password3', name='name3'}  
> =================================================================  
> User{id=1, login='login1', password='password1', name='UPDATED'}  
> User{id=2, login='login2', password='password2', name='name2'}  
> User{id=3, login='login3', password='password3', name='name3'}

## Repository pattern

Repository is one of the easiest and important design pattern that you can use and see, especially when you need a layer
to deal with data access whether this data is in a database or another storage.
Where to Use:

- Between domains(entity) and Data storage
- To prevent duplicate query
- In a system where you have a lot of heavy query
- It is used for search or remove element using specification of the entity that the repository created for.

```java
public interface Repository<T> {
    void add(T t);

    List<T> findAll();

    List<T> findBySpecification(Specification specification);

    void remove(T t);
}

public interface Specification<T> {
    boolean isExist(T t);
}

public class User {
    private int id;
    private String login;
    private String password;
    private String name;

    public User() {
    }

    public User(int id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }
    //Getters, Setters, Equals, Hashcode, toString
}

public class UserRepository implements Repository<User> {
    private static UserRepository Instance = new UserRepository();
    //list is working as a database only for example
    private List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1, "login1", "password1", "name1"));
        users.add(new User(2, "login2", "password2", "name2"));
        users.add(new User(3, "login3", "password3", "name3"));
    }

    public static UserRepository getInstance() {
        return Instance;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> findBySpecification(Specification specification) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (specification.isExist(user)) {
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }
}

public class FindByIdSpecification implements Specification<User> {
    private int id;

    public FindByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean isExist(User user) {
        return user.getId() == id;
    }
}

public class FindByUserNameSpecification implements Specification<User> {
    private String name;

    public FindByUserNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isExist(User user) {
        return user.getName().equals(name);
    }
}

public class Example {
    public static void main(String[] args) {
        Repository<User> userRepository = UserRepository.getInstance();
        List<User> userList = userRepository.findAll();
        printList(userList);
        System.out.println("================================================================");
        System.out.println("Find by name, used FindByUserNameSpecification");
        List<User> findByUserName = userRepository.findBySpecification(new FindByUserNameSpecification("name1"));
        printList(findByUserName);
        System.out.println("Find by id, used FindByIdSpecification");
        List<User> findByUserId = userRepository.findBySpecification(new FindByIdSpecification(3));
        printList(findByUserId);
    }

    private static void printList(List<User> userList) {
        for (User user : userList
        ) {
            System.out.println(user);
        }
    }
}
```

Output:
> User{id=1, login='login1', password='password1', name='name1'}  
> User{id=2, login='login2', password='password2', name='name2'}  
> User{id=3, login='login3', password='password3', name='name3'}  
> ================================================================  
> Find by name, used FindByUserNameSpecification  
> User{id=1, login='login1', password='password1', name='name1'}  
> Find by id, used FindByIdSpecification  
> User{id=3, login='login3', password='password3', name='name3'}

## MVC (Model-view-controller pattern)

Model–view–controller (MVC) is a software architectural pattern commonly used for developing user interfaces that
divide the related program logic into three interconnected elements. This is done to separate internal representations
of information from the ways information is presented to and accepted from the user.
Traditionally used for desktop graphical user interfaces (GUIs), this pattern became popular for designing web
applications. Popular programming languages have MVC frameworks that facilitate the implementation of the pattern.
This pattern divides an interactive application in to 3 parts as:

- model — contains the core functionality and data
- view — displays the information to the user (more than one view may be defined)
- controller — handles the input from the user

This is done to separate internal representations of information from the ways information is presented to, and
accepted from, the user. It decouples components and allows efficient code reuse.  
In addition to dividing the application into these components, the model–view–controller design defines the interactions
between them.

- The model is responsible for managing the data of the application. It receives user input from the controller.
- The view renders presentation of the model in a particular format.
- The controller responds to the user input and performs interactions on the data model objects. The controller receives
  the input, optionally validates it and then passes the input to the model.

MVC is a framework for thinking about programming, and for organizing your program’s files. To signify the idea that
your code should be organized by its function, developers will create folders for each part of MVC. (The idea that apps
should be divided based on the function of each part of the code is sometimes referred to as separation of concerns.) If
you’ve looked at Codecademy’s Ruby on Rails course, you might have noticed that there is a folder for each part of MVC
within every Rails app it introduces.
MVC gives you a starting place to translate your ideas into code, and it also makes coming back to your code easier,
since you will be able to identify which code does what. In addition, the organizational standard MVC promotes makes it
easy for other developers to understand your code.
Thinking about how code interacts with other code is a significant part of programming, and learning to collaborate with
other developers is an important skill.
![MVC](img/MVC.svg)
Usage:

- Architecture for World Wide Web applications in major programming languages.
- Web frameworks such as Django and Rails.

```java
public class Student {
    private String name;
    private int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}

public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

public class MVCPatternDemo {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Student model = retrieveStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
```

Output:
> Student:  
> Name: Robert  
> Roll No: 10  
> Student:  
> Name: John  
> Roll No: 10

## Client-Server pattern

This pattern consists of two parties; a server and multiple clients. The server component will provide services to
multiple client components. Clients request services from the server and the server provides relevant services to those
clients. Furthermore, the server continues to listen to client requests.  
Usage:

- ClientOnline applications such as email, document sharing and banking.

![Client-Server](img/Client-server.png)

## Event bus pattern

This pattern primarily deals with events and has 4 major components; event source, event listener, channel and event
bus. Sources publish messages to particular channels on an event bus. Listeners subscribe to particular channels.
Listeners are notified of messages that are published to a channel to which they have subscribed before.

Usage:

- Android development
- Notification services
  ![Event bus](img/Event%20bus.png)