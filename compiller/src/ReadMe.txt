Programmer's Manual
-------------------

This documentation describes a simple programming language you can use to run common operations, as described below.

Overall, the syntax follows a familiar programming language pattern, resembling Python in some ways. Here are some key points to note:

Variables
---------
Variables are declared using the format datatype variable_name = value.

A variable can be of type num (number) or string.

For example, to declare a numeric variable and assign it a value, you would enter the following:
num y = 420


User Input
----------
The input keyword is used to prompt the user for input. The input is stored in the specified variable.

For example:
string name = input name


Arithmetic Operations
---------------------
Basic arithmetic operations (addition, subtraction, multiplication, and division) are performed using functions like add(), sub(), mult(), and div().

For example:
num addition = add(x,y)
num subtraction = sub(x,y)
num multiplication = mult(x,y)
num division = div(x,y)


Printing
--------
The print() function is used to display the values of variables or messages on the console.

For example:
print(addition)


Looping
-------
The loop(n) statement is used to create a loop that repeats the following code block n times.

For example:
loop(3) print(name)


Conditional Statements
----------------------
The if statement is used to check a condition, and if it evaluates to true, the code block following the if statement is executed.


Comments
--------
Comments can be included (and are encouraged!) to explain how your program works.
To include a comment, begin the line using the # symbol. Anything that follows will be ignored during execution.
