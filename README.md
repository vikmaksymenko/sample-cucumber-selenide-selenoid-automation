Sample Cucumber Selenide UI Automation Test Framework
=====================================================

This is a project for running Cucumber Selenide automated UI tests on Selenoid containers

### Required tools
 
* JDK 8
* Maven
* Docker 

### How to run


1. Start Selenoid containers 
```
./cm selenoid start --vnc --tmpfs 128
```
2. Run tests:
```
mvn clean test
```
3. Build reports to temp folder and view:    
```
mvn allure:serve
```
4. Build reports and save to target/site
```
mvn allure:report
```


