# READING

1. [TypeScript (en)](https://www.typescriptlang.org/docs/handbook/basic-types.html)
2. [TypeScript (rus)](http://typescript-lang.ru/docs/)
3. [Basic Types](https://www.typescriptlang.org/docs/handbook/basic-types.html)
4. [Interfaces](https://www.typescriptlang.org/docs/handbook/interfaces.html)
5. [Functions](https://www.typescriptlang.org/docs/handbook/functions.html)
6. [Literal Types](https://www.typescriptlang.org/docs/handbook/literal-types.html)
7. [Unions and Intersections](https://www.typescriptlang.org/docs/handbook/unions-and-intersections.html)
8. [Classes](https://www.typescriptlang.org/docs/handbook/classes.html)
9. [Enums](https://www.typescriptlang.org/docs/handbook/enums.html)
10. [Generics](https://www.typescriptlang.org/docs/handbook/generics.html)

# PRACTICE
## Task

1. Install [npm](https://nodejs.org/en/download/)
2. Set npm
    `npm install -g typescript`
3. Create folder
4. Create index.html 
5. Create app.ts 
6. Create tsconfig.json ([tsconfig.json](https://www.typescriptlang.org/docs/handbook/tsconfig-json.html))
7. To connect app.js to index.html (For example, `<script src=”app.js”></script>`)
8. Run project in terminal
    `tsc fileName.ts`
9. Open path to index.html in the browser (must run tsc fileName.ts in the terminal after each update)
10. Create a EuropeCompany project.
    a. Create the class Employee. This class should consist of:
        •	getCurrentProject - method for getting the name of the current project;
        •	getName – method for getting  the name of the employee;
    b. Create the class Company. This class should consist of:
        •	an array of the Employees added to the company;
        •	add - method to add a new Employee to the company;
        •	getProjectList  - method to get list of employee’s projects;
        •	getNameList - method to get the list of names by added Employees.
    c. Create 2 additional classes (Frontend, Backend) which extend Employee class.
    d. Create an object of class Company.
    e. Create several objects Frontend and Backend employees with information about their names and projects and add them to the company, display the result of the getProjectList and getNameList methods in the console.
11. Create an AmericanCompany project based on the EuropeCompany project.
    a. Let’s update our project.
    b. Create IEmployee (with methods  getCurrentProject  and getName) interface instead of using Employee class. After that, implement this interface in Frontend and Backend classes.
    c. Create several objects of Frontend and Backend employees with information about their names and projects and add them to the Company, display the result of the getProjectList and getNameList methods in the console.
12. Create a BritishCompany project based on the EuropeCompany project.
    a. The Company class must be parameterized by Location — the location of the company’s office. Create ILocation interface with the following methods:
        •	addPerson - method which adds a person;
        •	getPerson - method for getting a person by index;
        •	getCount - method of counting the number of employees;
    b. Location should implement the ILocation interface.
    c. Create 2 classes with different locations:
        •	CompanyLocationArray class which implements ILocation interface - for storage in Array <type>;
        •	CompanyLocationLocalStorage class which implements ILocation interface - for storage in localStorage.
    d. Update class Company with using Location.
    e. Remove Frontend and Backend classes.
    f. Create several Companies with different locations. 
    g. Add several employees to each company.
    h. Display the results of the getProjectList and getNameList methods in the console.
    i. Do not create Frontend and Backend employees, just work with the Employee class.
    j. The Employee class does not use public properties, only public methods.

# DEMO
## Practical part

Mentee should be able to demonstrate his test project.

## Theoretical part

Mentee should be able to answer questions during demo session.