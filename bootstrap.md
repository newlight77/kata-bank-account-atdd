# Bootstrap

## Step 1 : initialize with springboot

```bash
curl https://start.spring.io/starter.tgz \
-d dependencies=web,actuator,lombok \
-d language=java \
-d type=maven-project \
-d baseDir=kata-bank-account-bdd \
-d groupId=com.newlight77 \ 
-d artifactId=kata-bank-account-bdd \
| tar -xzvf -
```

## Step 2 : add dependencies

```xml
		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.11.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>2.3.1</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>2.3.1</version>
			<scope>test</scope>
		</dependency>
```

## Step 3 : add build plugins

```xml
            <plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.3</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.7.0</version>
				<configuration>
					<encoding>UTF-8</encoding>
					<source>1.8</source>
					<target>1.8</target>
					<compilerArgument>-Werror</compilerArgument>
				</configuration>
			</plugin>
```

## Step 4 : add Cucumber runner and StepRefs

RunCucumberTest.java 

```java
package com.newlight77.kata.bank.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {
}
```

```java
package com.newlight77.kata.bank.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

}
```