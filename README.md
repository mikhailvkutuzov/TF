# TF
A main idea is to simplify reading of web tests by implimenting a special library of web components  upon WebDriver and try to avoid installing some drivers special for web browsers. 

0. clone this project to your machine. 
1. do mvn install in the project root.
2. create your own maven project and add a dependency on
    <groupId>com.testing</groupId>
    <artifactId>TF</artifactId>
    <version>1.0-SNAPSHOT</version>
3. implement your own TestSuits likewise a TestSuit implemented in TF's unit tests
