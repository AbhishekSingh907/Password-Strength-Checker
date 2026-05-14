# Password Strength Checker

A Java-based application that analyzes password strength and provides detailed feedback on password security. The application uses regex patterns and Apache Commons utilities to evaluate passwords and classify them as weak, medium, or strong.

## Features

- **Real-time Password Analysis**: Check password strength instantly
- **Detailed Feedback**: Get specific reasons why a password is weak or strong
- **Regex-based Validation**: Uses pattern matching for comprehensive checks
- **Apache Commons Integration**: Leverages Apache Commons Lang for string utilities
- **Docker Support**: Easy deployment with Docker and Docker Compose
- **Interactive CLI**: User-friendly command-line interface
- **Comprehensive Testing**: Full unit test coverage

## Password Strength Criteria

The application evaluates passwords based on:

- **Length**: Minimum 6 characters (8+ recommended, 12+ for strong)
- **Uppercase Letters**: Presence of A-Z
- **Lowercase Letters**: Presence of a-z
- **Numbers**: Presence of 0-9
- **Special Characters**: Presence of !@#$%^&*()_+-=[]{}
- **Common Patterns**: Detection of common weak patterns (password, 123, etc.)
- **Repeated Characters**: Detection of 3+ repeated characters

## Strength Levels

- 🔴 **WEAK**: Score < 3 - Basic requirements not met
- 🟡 **MEDIUM**: Score 3-5 - Good but could be stronger
- 🟢 **STRONG**: Score 6+ - Excellent security

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Docker (optional, for containerized deployment)

## Installation and Usage

### Option 1: Run with Maven

1. Clone the repository:
```bash
git clone https://github.com/junevm/password-strength-checker.git
cd password-strength-checker
```

2. Build the project:
```bash
mvn clean package
```

3. Run the application:
```bash
java -jar target/password-strength-checker-1.0.0.jar
```

### Option 2: Run with Docker

1. Build and run using Docker Compose:
```bash
docker-compose up --build
```

2. Or build and run manually:
```bash
# Build the Docker image
docker build -t password-strength-checker .

# Run the container
docker run -it password-strength-checker
```

### Option 3: Run with Maven directly

```bash
mvn clean compile exec:java -Dexec.mainClass="com.passwordchecker.PasswordStrengthChecker"
```

## Running Tests

Execute the unit tests:
```bash
mvn test
```

Generate test coverage report:
```bash
mvn clean test jacoco:report
```

## Example Usage

```
╔════════════════════════════════════════════════════════════╗
║         PASSWORD STRENGTH CHECKER APPLICATION             ║
╚════════════════════════════════════════════════════════════╝

Enter a password to check its strength (or 'quit' to exit):
> MyStr0ng!P@ssw0rd

════════════════════════════════════════════════════════════
PASSWORD STRENGTH ANALYSIS
════════════════════════════════════════════════════════════
Strength Level: 🟢 STRONG (Score: 8/8)
────────────────────────────────────────────────────────────

✓ Strengths:
  • Excellent length (17 characters)
  • Contains uppercase letters
  • Contains lowercase letters
  • Contains numbers
  • Contains special characters

💡 Recommendations:
  • Your password is strong! Keep it secure.
  • Don't reuse this password on multiple sites
  • Consider using a password manager
════════════════════════════════════════════════════════════
```

## Project Structure

```
password-strength-checker/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── passwordchecker/
│   │               └── PasswordStrengthChecker.java
│   └── test/
│       └── java/
│           └── com/
│               └── passwordchecker/
│                   └── PasswordStrengthCheckerTest.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
├── SYNOPSIS.md
└── PROJECT_REPORT.md
```

## Dependencies

- **Apache Commons Lang 3.14.0**: String utilities and helper functions
- **JUnit 4.13.2**: Unit testing framework

## Documentation

- [Synopsis](SYNOPSIS.md) - Project synopsis for academic submission
- [Project Report](PROJECT_REPORT.md) - Detailed project documentation

## Contributing

This is an academic project. For issues or suggestions, please create an issue in the repository.

## License

This project is created for educational purposes.

## Author

Created as part of academic coursework.