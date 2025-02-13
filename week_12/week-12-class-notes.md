# Week 12 Class Notes

Class notes from week 12 curriculum, JUnit testing.

### Why do we unit test?

-   Unit testing allows us to exercise our code in various ways.
-   We cannot trust users to always do the right thing.
-   When we have to change or add new code, we can have some assurance with our unit tests.

### Types of unit testing and methods

-   Unit testing is a software development practice that involves testing the smallest parts of an application, called units.
-   Test Driven Development (TDD) is a software development methodology that emphasizes writing tests before writing the actual code.
-   Behavior Driven Development (BDD) is a software development methodology that emphasizes writing tests to test sets of behavior
-   Functional testing is a type of software testing that verifies if a software application or system works as intended.

#### JUnit/Unit test example: 

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class MyUnitTest {
    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);
    }
}
```