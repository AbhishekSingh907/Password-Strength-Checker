# Glossary: Technical Concepts in Password Strength Checker Project

This glossary explains key technical terms, concepts, commands, and flags used in the Password Strength Checker project. Terms are organized alphabetically for easy reference.

---

## A

**Apache Commons Lang**  
A Java library providing utility classes for common operations like string manipulation. In this project, it's used for `StringUtils.isBlank()` to check for empty or whitespace-only passwords.

**Archetype**  
In Maven, a project template that generates a standard directory structure and initial files. Used with `mvn archetype:generate` to create the project's skeleton.

---

## B

**Build Tool**  
Software that automates the process of compiling, testing, and packaging code. Maven is the build tool used here for Java projects.

---

## C

**CLI (Command-Line Interface)**  
A text-based user interface for interacting with software. The Password Strength Checker uses a CLI built with Java's `Scanner` class for user input.

**Commit (Git)**  
A snapshot of changes in the repository. Created with `git commit -m "message"` to save staged changes with a description.

**Containerization**  
The process of packaging an application with its dependencies into a portable container. Docker is used for this in the project.

---

## D

**Dependency**  
An external library or module required by the project. Managed in Maven via `pom.xml` and added using `mvn dependency:add`.

**Docker**  
A platform for developing, shipping, and running applications in containers. Used to package the Java application for consistent deployment.

**Dockerfile**  
A script containing instructions to build a Docker image. The project's Dockerfile uses a multi-stage build for efficiency.

---

## E

**Executable JAR**  
A JAR file that can be run directly with `java -jar`. Created by Maven's package phase, containing the compiled classes and dependencies.

---

## G

**Git**  
A distributed version control system for tracking changes in source code. Used to manage the project's history and collaboration.

**GroupId (Maven)**  
A unique identifier for the organization or project in Maven coordinates. Set to `com.passwordchecker` in this project.

---

## I

**Image (Docker)**  
A lightweight, standalone, executable package that includes everything needed to run the application. Built from a Dockerfile.

---

## J

**JAR (Java Archive)**  
A file format for aggregating Java class files and resources. The project produces an executable JAR for distribution.

**Java**  
An object-oriented programming language used to build the core application logic, including password validation and CLI.

**JUnit**  
A testing framework for Java. Used to write and run unit tests for the password checking logic.

---

## M

**Main Class**  
The entry point of a Java application, containing the `main` method. In this project, `com.passwordchecker.PasswordStrengthChecker`.

**Maven**  
A build automation tool for Java projects, handling dependencies, compilation, testing, and packaging.

**Multi-Stage Build (Docker)**  
A Dockerfile technique using multiple `FROM` statements to optimize image size by separating build and runtime environments.

---

## P

**Pattern (Regex)**  
A sequence defining a search pattern. Used in Java with `java.util.regex.Pattern` to validate password characteristics like uppercase letters.

**pom.xml**  
Project Object Model file in Maven, defining project configuration, dependencies, and build plugins.

**Push (Git)**  
Uploading local commits to a remote repository. Done with `git push origin main` to share changes on GitHub.

---

## R

**Regex (Regular Expression)**  
A powerful tool for pattern matching in strings. Used to check for character types and common weak patterns in passwords.

**Remote Repository (Git)**  
A version of the repository hosted online (e.g., GitHub). Connected with `git remote add origin <url>`.

**Repository (Git)**  
A storage location for the project's source code and history. Initialized with `git init`.

---

## S

**Scanner (Java)**  
A class for reading user input from the console. Used in the CLI to accept password entries.

**Scoring Algorithm**  
A custom logic assigning points (0-8) based on password criteria: length, character diversity, and pattern checks.

**Staging Area (Git)**  
A temporary area where changes are prepared before committing. Files are added with `git add .`.

---

## T

**Tag (Docker)**  
A name given to a Docker image for easy reference. Set with `-t password-strength-checker` in `docker build`.

---

## U

**Unit Test**  
Automated tests verifying individual components. Written with JUnit to ensure password validation works correctly.

---

## V

**Version Control**  
A system for managing changes to code over time. Git provides distributed version control for this project.

---

## Commands and Flags

### Maven Commands

**mvn archetype:generate**  
Generates a new Maven project from a template.  
Flags:

- `-DgroupId=<id>`: Sets the project's group identifier (e.g., `com.passwordchecker`).
- `-DartifactId=<id>`: Sets the project's artifact name (e.g., `password-strength-checker`).
- `-DarchetypeArtifactId=<id>`: Specifies the template (e.g., `maven-archetype-quickstart`).
- `-DinteractiveMode=false`: Runs non-interactively.  
  Usage: Creates the initial project structure.

**mvn dependency:add**  
Adds a dependency to `pom.xml` automatically.  
Flags:

- `-DgroupId=<id>`: Group ID of the dependency (e.g., `org.apache.commons`).
- `-DartifactId=<id>`: Artifact ID (e.g., `commons-lang3`).
- `-Dversion=<ver>`: Version (e.g., `3.14.0`).
- `-Dscope=<scope>`: Scope like `test` for JUnit.  
  Usage: Updates `pom.xml` without manual editing.

**mvn clean install**  
Cleans previous builds, compiles code, runs tests, and installs to local repository. Downloads dependencies.  
Usage: Prepares the project for execution.

**mvn clean package**  
Cleans, compiles, tests, and packages into a JAR.  
Usage: Creates the executable JAR in `target/`.

**mvn exec:java**  
Runs a Java class directly from Maven.  
Flags:

- `-Dexec.mainClass=<class>`: Specifies the main class (e.g., `com.passwordchecker.PasswordStrengthChecker`).  
  Usage: Executes the application without building a JAR (requires exec plugin).

**mvn test**  
Runs unit tests.  
Usage: Validates code functionality.

### Git Commands

**git init**  
Initializes a new Git repository in the current directory.  
Usage: Sets up version control for the project.

**git remote add origin <url>**  
Adds a remote repository URL.  
Usage: Connects local repo to GitHub for pushing changes.

**git add .**  
Stages all changes in the working directory.  
Usage: Prepares files for commit.

**git commit -m "message"**  
Creates a commit with staged changes.  
Flags:

- `-m`: Specifies the commit message.  
  Usage: Saves changes with a description.

**git push origin main**  
Uploads commits to the remote repository's main branch.  
Usage: Shares code on GitHub.

### Docker Commands

**docker build -t <name> .**  
Builds a Docker image from the Dockerfile.  
Flags:

- `-t <name>`: Tags the image (e.g., `password-strength-checker`).  
  Usage: Creates a runnable container image.

**docker run -it <image>**  
Runs a container interactively.  
Flags:

- `-i`: Keeps STDIN open for input.
- `-t`: Allocates a pseudo-TTY for terminal interaction.  
  Usage: Starts the application in a container, allowing user input.

---

This glossary covers the essential concepts for understanding the project's implementation. Refer to official documentation for deeper dives into any term.
