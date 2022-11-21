## How to install

Clone git repository<br/>
URL: https://github.com/jaroslav2022/soft_industry <br/>
Then in Intellij Idea create new project `using existing sources`<br/>
And choose cloned directory

or

File->New->Project from version control<br/>
URL: https://github.com/jaroslav2022/soft_industry <br/>
click `Clone` and wait until maven resolves dependencies

## How to run

In the terminal type
```text 
mvn clean verify
```

Or right-click on the `TestRunner` class and choose `Run TestRunner`

## How to write new tests

Please refer to https://cucumber.io/docs/cucumber/step-definitions/?lang=java
<br/><br/>
### What was refactored and why

* __line 29:__
```java
response.body("title", contains("mango")));
```
changed to
```java
response.body("title", hasItem("AH Mango")));
```
Because `actual` is `java.lang.Iterable` and needs corresponding `Matcher`

* __line 34:__
```java
response.body("error", contains("True")));
```
changed to
```java
response.body("detail.error", equalTo(true)));
```
Because path is incomplete and `actual` should have corresponding `Matcher`