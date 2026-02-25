# Design Patterns - Builder & Observer

This repository contains practical Java exercises designed to master creational and behavioral design patterns through hands-on implementation. The project demonstrates how to construct complex objects systematically using the Builder pattern and how to establish flexible notification mechanisms using the Observer pattern, both fundamental to writing maintainable and scalable software.

## Key Concepts

The exercises explore two essential design patterns from different categories. The Builder pattern belongs to the creational patterns family and provides an elegant solution for constructing complex objects step by step, separating the construction process from the object's representation. This pattern becomes particularly valuable when dealing with objects that have numerous optional parameters or configurations, eliminating the need for telescoping constructors that can become difficult to read and maintain.

The Observer pattern represents a behavioral design pattern that establishes a one-to-many dependency relationship between objects. When the observed object changes state, all registered observers receive automatic notifications. This pattern enables loose coupling between components by allowing publishers to communicate with subscribers without knowing their concrete implementations, making it ideal for implementing event-driven systems and publish-subscribe architectures.

The project emphasizes the Fluent Builder approach, which enables method chaining for more readable and expressive code construction. Additionally, the implementation incorporates progressive interfaces, a technique that restricts available options during the building process to ensure correct ordering and enforce dependencies between construction steps. This prevents invalid object states and guides developers toward proper usage patterns.

## Exercise Details

The project is structured into two progressive levels that demonstrate different aspects of design pattern implementation in real-world scenarios.

**Level 1 - Builder Pattern** focuses on designing a flexible restaurant menu system that accommodates various menu types including full menus, half menus, and children's menus. The implementation must construct menus composed of starters, main courses, desserts, and beverages while supporting specific dietary characteristics such as vegan and gluten-free options. Main courses may include supplements like extra side dishes. The system enforces construction order through progressive interfaces, preventing logical errors such as adding desserts before specifying the main course. A key constraint requires that if dessert is chosen, coffee cannot be added, and vice versa, with this mutual exclusivity enforced through interface design rather than runtime validation. The fluent builder approach ensures clear, expressive code that avoids boolean parameters in favor of descriptive method names.

**Level 2 - Observer Pattern** involves implementing a stock market notification system where a Stock Agent acts as the observable subject that monitors market changes. Multiple stock brokerage agencies serve as observers that subscribe to receive notifications whenever stock values rise or fall. The Stock Agent must maintain references to all registered observers and provide methods for subscription management, allowing observers to be added or removed dynamically during runtime. When market conditions change, the agent automatically notifies all subscribers with detailed information about the change direction and the new stock value. Each brokerage agency observer displays received notifications to demonstrate the successful propagation of market events. This implementation showcases how the Observer pattern enables decoupled communication between components, with the observable maintaining no knowledge of observer internal logic.

## Technologies Used

The project is built using Java 23 or the most recent version available as the core language. Maven serves as the build automation tool for dependency management and project compilation. JUnit 5 and JUnit 6 provide the testing framework for comprehensive unit tests that verify both functional requirements and proper pattern implementation. IntelliJ IDEA is the recommended integrated development environment for working with the project. Git is used for version control to track changes and manage the codebase effectively.

## Requirements

You will need Java SDK 23 or a recent version installed on your system to run this project. A solid understanding of Java interfaces, object-oriented programming principles, and the fundamentals of design patterns will be essential. Familiarity with unit testing concepts and test-driven development practices is beneficial for working with the test suite. IntelliJ IDEA is recommended as the development environment for optimal experience with the project structure and testing framework.

## Installation

Clone this repository to your local machine using the following command:

```bash
git clone [https://github.com/federicopratico/3.3-DesignPatterns_2.git]
```

Alternatively, if you prefer SSH authentication:

```bash
git clone git@github.com:federicopratico/3.3-DesignPatterns_2.git
```

Navigate to the project directory after cloning:

```bash
cd 3.3-DesignPatterns_2
```

Open the project in IntelliJ IDEA by selecting File > Open and choosing the project directory. The IDE will automatically detect the Maven configuration and download the necessary dependencies.

## Execution

The project is designed to be executed through IntelliJ IDEA. Each level is organized into its own package with dedicated main classes and test suites that demonstrate the pattern implementations. To run the exercises, locate the main class for the desired level within the project structure and execute it using the IDE's run configuration. The console output will display the results of menu construction for Level 1 and stock market notifications for Level 2.

To run the unit tests, right-click on the test directory or individual test classes in IntelliJ IDEA and select Run Tests. The IDE's test runner will execute all test cases and display comprehensive results showing coverage of both the Builder and Observer patterns. The test output validates that menu construction follows the correct sequence with proper validation, and that observer notifications propagate correctly to all registered subscribers. Tests verify edge cases such as attempting invalid construction sequences and dynamic observer subscription management.

## Technical Decisions

The Builder pattern implementation utilizes progressive interfaces to enforce construction order at compile time rather than relying on runtime validation. This design decision provides immediate feedback to developers when they attempt invalid construction sequences, catching errors during development rather than in production. The fluent interface design enhances code readability by making the construction process self-documenting, with method names clearly expressing intent. The mutual exclusivity between dessert and coffee is enforced through interface design, where selecting one option returns an interface that does not expose the other, preventing logical inconsistencies.

The separation between builder interfaces and the final product class ensures that once a menu is built, it becomes immutable. This immutability guarantees that menu configurations cannot be altered after construction, preventing unexpected state changes. The use of method chaining throughout the builder improves code expressiveness while maintaining type safety, as each method returns the appropriate interface for the next valid step.

The Observer pattern implementation maintains a clear separation between the observable subject and its observers through well-defined interfaces. The Stock Agent holds observer references in a collection that allows for dynamic subscription management without requiring knowledge of concrete observer implementations. This design adheres to the Dependency Inversion Principle, as both the agent and observers depend on abstractions rather than concrete classes.

The notification mechanism implements a push model where the observable sends detailed information about state changes to all observers simultaneously. This ensures consistency across all subscribers and eliminates the need for observers to query the agent for state information. The design facilitates easy extension, as new observer types can be introduced without modifying the Stock Agent class, demonstrating the Open-Closed Principle in practice.

## Study References

This project is based on foundational design pattern concepts presented in the seminal work "Design Patterns: Elements of Reusable Object-Oriented Software" by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, commonly known as the Gang of Four. This classic text provides comprehensive explanations of design patterns and their applications in object-oriented software development, serving as an essential reference for understanding the theoretical foundations behind the implementations in this project.

## Contributions

Contributions to this learning project are welcome. If you identify improvements or wish to add new pattern implementations, fork the repository and create a feature branch for your changes. Commit your modifications with clear, descriptive messages and push to your branch before opening a pull request for review.
