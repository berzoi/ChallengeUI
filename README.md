# Simpals UI Test Automation

Automated end-to-end tests for [https://999.md/ru/](https://999.md/ru/) using BDD with Cucumber and Java.

## Scope

Tests cover:
- User login/logout
- Notification checks
- Ad draft lifecycle (create, update, delete)

## Structure

- `pages/`: Page Object classes
- `steps/`: Gherkin step definitions
- `utils/`: Helpers and configs

## Tech Stack

- **Java**, **Cucumber**, **Selenide - A powerful wrapper for Selenium that simplifies browser interactions, automatically handles most waits, and leads to more stable and concise UI tests.**
- **Maven**, **IntelliJ IDEA**

## Run Tests

**Command Line:**
mvn clean test

IntelliJ IDEA:

Open simpals.feature → Right-click to run

Notes:
Runs in non-headless mode
Assumes working test accounts & app availability
