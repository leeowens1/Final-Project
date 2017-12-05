@ECHO OFF
set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;sqlite-jdbc-3.20.0.jar
set JAVA_HOME="c:\Program Files\Java\jdk1.8.0_144"


javac PracGui2.java
%JAVA_HOME%\bin\java -Xms128m -Xmx384m -classpath %CLASSPATH% PracGui2