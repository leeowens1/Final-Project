@ECHO OFF
set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;sqlite-jdbc-3.20.0.jar
set JAVA_HOME="c:\Program Files\Java\jdk1.8.0_144"

rem (how to): https://stackoverflow.com/questions/8938944/how-to-run-java-application-by-bat-file
rem it should be: java -classpath ".;sqlite-jdbc-3.20.0.jar" SalesExpress

javac PracGui2.java
%JAVA_HOME%\bin\java -Xms128m -Xmx384m -classpath %CLASSPATH% PracGui2