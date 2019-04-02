# policyeval - Policy Evaluator and Parser
# Table of Contents
1. [Project](README.md#Project)
1. [Run](README.md#Run)
1. [Sample](README.md#Sample)
1. [Files](README.md#Files)

# Project
* The Policy Evaluator parses JSON Policy File as a list of policies. 
* The User specifies an input which is evaluated against the policies and the resulting Action becomes the output.
* The format of the policy file is as follows:
![alt text](https://i.imgur.com/5ElATsT.png "Policy File")

# Run
* The project can be executed by running a fat jar file which includes all the dependencies. The *policyeval.jar* file is present in *Executable Jars* folder.
* It can be executed using two different ways: File and Console
* File Mode: Specify three command line arguments (path to policy.json, input file path, output file path)
* Command: **java -jar policyeval.jar path_policy path_input path_output
* Console Mode: Specify just One argument (path to policy.json)
* Command: **java -jar policyeval.jar path_policy

# Sample
* Input File : 
![alt text](https://i.imgur.com/J0l4pzE.png "Input File")
* Output File:
![alt text](https://i.imgur.com/Sn8i50e.png "Input File")


# Files
1. **Policy.java:** A POJO Class to convert JSON to Java Policy Object.
2. **PolicyParser.java:** A Singleton class. Uses Jackson Library to parse list of policies into Java objects
3. **PolicyEvaluator.java:** Contains method to evaluate the user input against the policies.
4. **PolicyEvaluatorTest.java:** A Set of Unit Tests to test evaluate method
5. **Reader.java:** Interface implemented by FileReader and ConsoleReader
6. **Writer.java:** Interface implemented by FileWriter and ConsoleWriter
7. **ReaderWriterFactory.java:** Factory Class to generate Reader and Writer




## Repo directory structure

The directory structure for your repo should look like this:

    ├───.settings
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   └───resources
    │   └───test
    │       ├───java
    │       └───resources
    └───target
        ├───archive-tmp
        ├───classes
        ├───maven-archiver
        ├───maven-status
        │   └───maven-compiler-plugin
        │       ├───compile
        │       │   └───default-compile
        │       └───testCompile
        │           └───default-testCompile
        └───test-classes

Email: dramnani@usc.edu
