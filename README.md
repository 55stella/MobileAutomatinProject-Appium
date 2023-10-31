# Fleet Management Application

## Description

This application is a fleet management application that allows users to create, read, update, and delete vehicles and drivers. The application also allows users to assign drivers to vehicles and vice versa

## Installation

To install this application, clone the repository and run the following command in the terminal:

[//]: # (Installation steps for Appium project )


## Regression Testing
For now, regression testing is done using the automated scripts in the `tests` folder. To run the tests, run the test from regressionTest.xml file. 
The test report is generated in the `Reports` folder. 

The order of the tests run is important because certain entities like driver needs to be created and then used in the vehicle test, incident, boat and car_jetty module test.

To provide the correct data for regression test, edit the `TestData.properties` file in the `src/test/java` folder.
I will list the order in which each module will be tested and the data that needs to be provided in the `TestData.properties` file.
