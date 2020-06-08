# Documentation
* [TypeScript (en)](https://www.typescriptlang.org/docs/handbook/basic-types.html)
* [TypeScript (rus)](http://typescript-lang.ru/docs/)
* [Basic Types](https://www.typescriptlang.org/docs/handbook/basic-types.html)
* [Interfaces](https://www.typescriptlang.org/docs/handbook/interfaces.html)
* [Functions](https://www.typescriptlang.org/docs/handbook/functions.html)
* [Literal Types](https://www.typescriptlang.org/docs/handbook/literal-types.html)
* [Unions and Intersections](https://www.typescriptlang.org/docs/handbook/unions-and-intersections.html)
* [Classes](https://www.typescriptlang.org/docs/handbook/classes.html)
* [Enums](https://www.typescriptlang.org/docs/handbook/enums.html)
* [Generics](https://www.typescriptlang.org/docs/handbook/generics.html)

npm — Node.js Package Manager
*[link to download](https://nodejs.org/en/download/)
set npm
npm install -g typescript

# To create a project:
1.	create folder
2.	create index.html 
3.	create app.ts 
4.	create tsconfig.json (tsconfig.json - https://www.typescriptlang.org/docs/handbook/tsconfig-json.html)
5.	to connect app.js to index.html (For example, <script src=”app.js”></script>)
6.	tsc fileName.ts – run project in terminal
7.	open path to index.html in the browser
(must run tsc fileName.ts in the terminal after each update)


# 1. Create a EuropeCompany project.
Create the class Employee. This class should consist of:
•	getCurrentProject - method for getting the name of the current project;
•	getName – method for getting  the name of the employee;

Create the class Company. This class should consist of:
•	an array of the Employees added to the company;
•	add - method to add a new Employee to the company;
•	getProjectList  - method to get list of employee’s projects;
•	getNameList - method to get the list of names by added Employees.
Create 2 additional classes (Frontend, Backend) which extend Employee class.
Create an object of class Company.
Create several objects Frontend and Backend employees with information about their names and projects and add them to the company, display the result of the getProjectList and getNameList methods in the console


# 2. Create an AmericanCompany project based on the EuropeCompany project.
Let’s update our project. 
Create IEmployee (with methods  getCurrentProject  and getName) interface instead of using Employee class. After that, implement this interface in Frontend and Backend classes

Create several objects of Frontend and Backend employees with information about their names and projects and add them to the Company, display the result of the getProjectList and getNameList methods in the console


# 3. Create a BritishCompany project based on the EuropeCompany project.
The Company class must be parameterized by Location — the location of the company’s office.
Create ILocation interface with the following methods:
addPerson - method which adds a person;
getPerson - method for getting a person by index;
getCount - method of counting the number of employees;
Location should implement the ILocation interface. 
Create 2 classes with different locations:
•	CompanyLocationArray class which implements ILocation interface - for storage in Array <type>;
•	CompanyLocationLocalStorage class which implements ILocation interface - for storage in localStorage.
Update class Company with using Location.

Remove Frontend and Backend classes.

Create several Companies with different locations. 
Add several employees to each company.
Display the results of the getProjectList and getNameList methods in the console.

Do not create Frontend and Backend employees, just work with the Employee class.


The Employee class does not use public properties, only public methods.
