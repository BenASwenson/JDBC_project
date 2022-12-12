# Week 4 Group Project
___
## Overview
___
The project is split into 3 phases which must be completed sequentially. 
We were given a database to read/write using JDBC (Java Database Connectivity).
Manage database connections efficiently and reliable. Furthermore, methods were created to
serialise objects to `JSON` and `XML` and vice versa.

Test Driven Development (TDD) must be utilised in the project 
with `JUnit` testing as well as logging using `Log4j2`.
___
## Database
___
The original data was created by Fusheng Wang and Carlo Zaniolo at Siemens Corporate Research. 

Giuseppe Maxia made the relational schema and Patrick Crews exported the data in relational format.

The database contains about 300,000 employee records with 2.8 million salary entries. The export data is 167 MB, which is not huge, but heavy enough to be non-trivial for testing.

The data was generated, and as such there are inconsistencies and subtle problems. Rather than removing them, we decided to leave the contents untouched, and use these issues as data cleaning exercises.
___
## General Requirements
___ 
- Must be run as Scrum projects
- Must apply SOLID & OO principles
- Must use the MVC pattern where there is a user interface
- Should use well-known design patterns where appropriate
- Must include comprehensive `JUnit` testing or equivalent
- Should begin with the creation of tests, in line with a test-driven development approach
- Must use `log4j2` for appropriate runtime logging or equivalent
- Must implement appropriate exception handling
- Must be hosted on GitHub and thoroughly documented, through a README.md file

## Phase 1
- Download and install the Employees database for MySQL - [see this installation guide](https://dev.mysql.com/doc/employee/en/employees-installation.html)
- Read from the `employees` table in the database using appropriate SQL
- Each record should be used to create a new object of a suitable class and these objects added to a suitable collection
- Implement the [Data Access Object](https://www.oracle.com/java/technologies/data-access-object.html) pattern for accessing the database and the [Data Transfer Object](https://www.baeldung.com/java-dto-pattern) pattern to decouple the database access part of the program from the front end
- Remember to close connections to the database as soon as they have been finished with
## Phase 2
- Using `Jackson` object serialization, `[ObjectMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.13/com/fasterxml/jackson/databind/ObjectMapper.html)`, write a method that stores all the employees who worked in a chosen department during a specific period in a `JSON`formatted file
    - You will need to use the `department` and `dept_emp` tables, following relationships to figure our which employees are in which department during the required period
- Similarly, write a method that stores the employees of the chosen & time period in XML using `Jackson`'s `XML` serialization features, `[XMLMapper](https://github.com/FasterXML/jackson-dataformat-xml)`
- Allow the user to choose the file name, using a `Scanner` to get the user input
- The program should polymorphically write the data in the appropriate format depending on the file extension, using the [Factory Method](https://refactoring.guru/design-patterns/factory-method) design pattern
## Phase 3

- Given a `.csv`, `.json` or `.xml` file containing new employees, add this to the database table
- This should be done polymorphically, based on the file extension
- Any corrupt or duplicated data should be added to a separate collection for further analysis - corrupt or duplicated values should be displayed to the user for review
- Valid data should be written to the database
- Sample files are provided, which may contain data errors
    - `employees01.csv`
    - `employees02.json`
    - `employees03.xml`
- Validation rules
    - `emp_no` should be only digits up to 8 characters
    - dates should be `YYYY-MM-DD`
    - dates should be in the past
    - `birth_date` should be after 1900-01-01
    - `hire_date` should be more recent than `birth_date`
    - names should only contain alpha chars, spaces and hyphens and should begin with a capital letter
    - gender should be `X`, `F` or `M`
- The original database structure doesn't allow for `X` as a value for gender, so the column definition should be altered accordingly in the table