# Java 6: Weekly Curriculum & Videos

### Table of contents

1. [Debugging](#1-debugging)
2. [Unit Tests](#2-unit-tests)


## 1. Debugging

**Debugging** can be described as diagnosing problems in code:  finding what is causing a problem, and fixing those problems! A **bug** in a program is something that causes the program to fail to do what it is designed to do. The term **debugging** comes from taking **bugs** out of code, literally removing the **bugs** from a program.

The term **debug** is anecdotally attributed to U.S. Navy Rear Admiral Grace Hopper. The story is told that in 1945, she coined the term **debug** when she and her colleagues found a problem in Mark II computer; when they opened up the machine, they found and removed an actual moth. Although the term **bug** had been used since the 19th century to describe a mechanical malfunction, Grace Hopper was actually the first to use **bug** to talk about a computer problem, and to talk about **debugging** a computer.

Check out _[Grace Murray Hopper (1906-1992): A legacy of innovation and service](https://news.yale.edu/2017/02/10/grace-murray-hopper-1906-1992-legacy-innovation-and-service)_ in the YaleNews to get more information on the influence and accomplishments of this remarkable person, and to learn a bit more about the history of computing.

#### Important vocabulary:

- **debugger**: a computer program that helps find and correct errors in other computer programs.

- **breakpoint**: a signal that informs the **debugger** to temporarily suspend execution of the program at a certain point in the code.

Of course, a Java programmer can use `System.out.println()` to inspect variables, displaying values in the Console, which can be really useful. However a **debugger** allows a programmer to set one or more breakpoints anywhere in the code, and when you run your program in **debug-mode**, the code will stop at the breakpoint that has been set. The program is still running at that point, which means that the programmer can tell the debugger to step line by line through the code, step into method calls, stop over method calls, and most importantly, inspect variables in real time.  

Integrated Development Environments (IDE) like **Eclipse** provide **debuggers**. IDEs are applications that facilitate the development of other applications. The intent is to encompass all programming tasks in one application, including **debugging**. 

The following instructions will aid in the use of the **Eclipse IDE debugger**:

- To define one or more **breakpoints** in your source code where you suspect the problem is happening. To set a **breakpoint**, right-click in the left margin when editing your code in Eclipse IDE, and select **_Toggle Breakpoint_**.   

- To run your Java code in **debug-mode** within the Eclipse IDE, choose:  
    _**Run** --> **Debug As** --> **Java Application**_

* The **Debug Perspective** offers new views to allow better troubleshooting, including **Debug View**, **Breakpoints View**, **Variables View**, **Expressions View**, and more.  

- Definitely **_switch_** the perspective to the Debug Perspective to take advantage of these different views.

- Add variables to **Expressions View** to examine variables as your program executes or as you step through the code.


### Resources:

- [Debugging with Eclipse IDE](https://www.eclipse.org/community/eclipse_newsletter/2017/june/article1.php)
- [Eclipse IDE Debugging Help](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftasks%2Ftask-running_and_debugging.htm&cp=1_3_6)
- [Eclipse IDE Debugging Tips and Tricks](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftips%2Fjdt_tips.html&cp=1_5_6&anchor=debugging_section)


## 2. Unit Tests


### Unit Tests

As software developers, we develop or write software. The steps that are often followed in the Software Development Process are as follows:

### Steps to Developing Software:

- Decide/Plan how to solve a task or request -- remember to break the task into smaller pieces (units) to be solved

- Write the code to solve the task by first writing code to solve each smaller piece of the solution

- Compile and/or Run the code that has been written.

    - **Test** and **Debug** the code: 

        - **Test**: Make sure the code works as designed.  

        - **Debug**: Track Down and Fix any flaws in the code that you wrote.

- Document exactly what has been coded and how it works.

**Testing** code is essential to ensure that the code executes exactly as it was designed. Check that the result or output of the program is exactly what is expected. When a result is not what is expected, a developer needs to **debug** their code.  

**Debugging** is the process of tracking down problems in the code and fixing the problems to make the code execute as expected. Once you correct the issues, continue to run any tests that you have written to confirm that the code still works.

**Unit Testing** is one of the most effective ways to test code. The code is broken into **Units**--smaller pieces of functionality--and those units are tested extensively. This is one way that a software developer can find issues in their initial implementation, and then, as the code is modified, ensure that nothing has broken a previously correct implementation.


### Resources:

- [JUnit5 Website](https://junit.org/junit5/)
- [JUnit5 UserGuide](https://junit.org/junit5/docs/current/user-guide/)
