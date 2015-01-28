# JavaToyRobot
Simulation of a toy robot moving on a square tabletop written in Java.

The application can read in commands of the following form -
- PLACE X,Y,F
- MOVE
- LEFT
- RIGHT
- REPORT
- QUIT

Requirements
---------
- Java 1.7+
- Maven 3.2.5+

Compilation
---------
- Check out the source and run the following from the ToyRobot directory:
  - mvm compile

Execution
---------
- After the source is compiled, run this command from the ToyRobot directory:
  - mvn exec:java

Test
---------
- After the source is compiled, run this command from the ToyRobot directory:
  - mvn test
