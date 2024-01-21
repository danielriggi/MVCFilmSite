<img src="images/dalle_project_picture.png" alt="Movie Film on Computer Screen" width="400" height="375">

# MVCFilmSite
Created by Daniel Riggi and Ieshia Parker

## Project Overfiew
Allow users to manage film records using a comprehensive C.R.U.D. (Create, Read, Update, Delete) functionality. Built with Spring MVC and the DAO (Data Access Object) pattern, this application streamlines film data management and retrieval, providing a seamless user experience.

## Key Features 

- **View Film Details**: Users can retrieve and display film information by entering a Film's ID.

- **Add New Films**: Easily add new films by inputting film properties, securely saved to the database.

- **Edit Existing Films**: Update film records, modifying any property (excluding the film's ID).

- **Delete Films**: Remove films from the database, with error handling for complications.

- **Search Films**: Find films by keywords or patterns in titles or descriptions.

# Tech Used
- **Programming Languages:**
    - Java 8 (version 1.8.0_391)
- **IDEs:**
    - Visual Studio Code 1.84.2 (https://code.visualstudio.com/)
    - Spring Tool Suite (STS) (https://spring.io/tools)
- **Version Control:**
    - Git 2.32.1 (https://git-scm.com/)
- **Database Management:**
    - MySQL (version 5.7.39)
- **Build Tool:**
    - Gradle
- **Web Framework:**
    - Spring MVC
- **View Technology:**
    - JavaServer Pages (JSP)

## Lessons Learned

### Spring MVC Framework

- **MVC Architecture**: Understanding the Model-View-Controller pattern helped us organize our code and separate concerns effectively.

- **Controllers**: We learned to design controllers to handle HTTP requests, manage user input, and route requests to appropriate components.

- **Dependency Injection**: Utilizing Spring's dependency injection simplified component management and enhanced modularity.

### JSP Functionality

- **Dynamic Content**: JSPs empowered us to create dynamic web content by embedding Java code within HTML.

- **Reusability**: We leveraged custom JSP tags and components to ensure code reusability and maintainability.

- **Templating**: Implementing JSP templates allowed for consistent design and layout across the application.

### Backend Database Integration

- **Database Design**: Properly structuring the database schema facilitated efficient data storage and retrieval.

- **Data Access Layer (DAO)**: Implementing the DAO pattern with JDBC enabled seamless interaction with the database.

- **Transactions**: Managing database transactions ensured data consistency and integrity in complex operations.

- **Error Handling**: We developed robust error-handling mechanisms to provide user feedback and facilitate debugging.

### Command Objects and Inversion of Control

- **Command Objects**: Using command objects simplified form handling and validation, enhancing user interactions.

- **Inversion of Control (IoC)**: IoC container in Spring simplified component management and promoted loosely coupled code.

