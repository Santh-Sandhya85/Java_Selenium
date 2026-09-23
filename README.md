# Java Selenium and Cypress Tests

This project contains automated tests for the [SauceDemo](https://www.saucedemo.com/) website.

It includes:

- Java Selenium tests with TestNG
- Page Object Model classes
- Cypress end-to-end login test

## Requirements

- Java 25 or later
- Maven
- Google Chrome
- Node.js and npm

## Project Structure

```text
src/main/java/pages/       Selenium page objects
src/main/java/utils/       WebDriver setup
src/test/java/base/        Common test setup and cleanup
src/test/java/tests/       Java Selenium tests
cypress/e2e/               Cypress tests
cypress/fixtures/          Cypress test data
cypress/support/           Cypress support files
pom.xml                    Maven dependencies
package.json               Cypress dependency
cypress.config.js          Cypress configuration
```

## Run Java Selenium Tests

From the project folder, run:

```bash
mvn test
```

The Java tests use Chrome and open SauceDemo automatically.

## Run Cypress Tests

Install the Node.js dependencies:

```bash
npm install
```

Open Cypress in the interactive mode:

```bash
npx cypress open
```

Run Cypress tests in the terminal:

```bash
npx cypress run
```

## Notes

Build output in `target/` and installed packages in `node_modules/` are ignored by Git.
