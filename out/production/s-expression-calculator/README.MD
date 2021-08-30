# S-expression-calculator

Command line calculator takes a single argument as an expression and prints out the integer result of evaluating it. 
An expression can be in one of two forms: an integer or a function call. 
A function call take the following form: 

```
(FUNCTION EXPR EXPR).
```
Current program version supports **add** and **multiply** function calls and takes **two** expressions. Calculator is build as a scalable 
program so function calls can be added, and the number of expressions can be increased with ease, refer to section *Extending functionality*. 

## Build
To run the program in command line, follow the steps: 
```
Compile java files from calculator directory: C:\..\s-expression-calculator\src\main\java\com\calculator>javac *.java
Run program from src directory: C:\...\s-expression-calculator\src>java main.java.com.calculator.Calculator "21"
```

## Functionality
Solution is based on the assumption that numbers smaller than 0 and bigger than Integer.MAX_VALUE(i.e., 2147483647) will not be used for the input expression.
Since result of expression evaluation might exceed Integer.MAX_VALUE, long data type is used for return of the expression evaluation. 

```
Main:
Calculator Class - entry point into the program. Takes input expression and passes it further for evaluation.
InputValidation Class -  
Calculation - 
```



## Extending functionality

Add supported function calls: 

Modify methods isExpressionValid(String expression) and isExpressionFreeOfInvalidCharacters(String expression) inside InputValidation class to account for new function call during input validation stage.
Inside of the Calculation class, add new method with proposed functionality and modify calculateExpression(String expression) method to account for the new function.

Increase allowable number of expressions inside parenthesis:
Change allowedNumberOfArguments variable inside of the Calculation class to increase the number of allowable expressions inside parenthesis. By default, it is set to 3 arguments (function, expression, expression). 

## Features 

- Code clarity and abstraction: 

- Error Handling: Checking for balanced paranthesis, invalid inputs, syntax errors and more
- Extensibility: Easily add new functions in the ExpressionEvaluator Class 
- Abstraction: Using OOP for functional design 
- User experience: 



Code clarity: how easy is it to read and reason about your code? Is data and control flow obvious and easy to follow?

Abstraction: there are many similarities between the subproblems. Do you exploit the patterns and have clear delegation of responsibility, or merely copy/paste code?

Extensibility: How easy is it to add new behaviours to your code? Examples:






