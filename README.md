# Getting started ebay Cucumber BDD Serenity Project

### The project directory structure
The project has build scripts for Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + test
    + java                        Test runner, Page Objects, Cucumber Step Definition, Serenity Definition and supporting code
    + resources
      + features                  Feature files
```

### Prerequisite tools required
```Gherkin
1. Gradle
2. Java greater than 1.8
```

### How to execute Cucumber BDD Cases
```Gherkin
1. Unzip the project using any zip extractor tool
2. If using macOS, open terminal at project root location and run
  gradle clean test aggregate
3. After execution completes, validate serenity report in folder 
  target>site>serenity>index.html by opening in any browser
```


