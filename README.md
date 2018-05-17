# TriangleCheck
Author: Caio Wohnrath
Date: 05/16/2018

Challenge:
Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.


Solution:
The Solution was divided in two classes:
- TriangleCheck is the main class. It gets the user input, checks if they are valid (input are numbers - int or double) or not
and calls the classification.

- Triangle class represents the triangle classification. The classification method returns whether the triangle, represented by its parameters,
is equilateral, isosceles or scalene. In case of negative sides or sides that don't form a triangle, it raises a IllegalStateException.
As I don't need to store, process or do other things with the triangle, only classify its type, I decided to implement the classification
methods as static methods, receiving the sides as parameters, instead of making the sides class attributes.


Tests:
After I decided to implement the classification method as static and defined its parameters, I created the TriangleTest class and
I wrote tests for int success cases and main errors cases. Then, after finished the class implementation, I wrote the remaining cases
in order to cover all possibilities.
As I decided to include a second class TriangleClass as the main class later, I wrote the test cases only after its implementation.


How to compile:
mvn package


How to execute:
- Showing help
java -jar target/TriangleCheck-jar-with-dependencies.jar -h
or
java -jar target/TriangleCheck-jar-with-dependencies.jar -help

- Running Triangle Classification
java -jar target/TriangleCheck-jar-with-dependencies.jar a b c

Where a, b, c are numbers either integer or double.
Program exit will show triangle type when sides are valid, or message / exception when inputs are invalid.