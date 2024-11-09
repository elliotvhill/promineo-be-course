# Mentor Sessions Notes

A repository to store any questions, discussion topics, tips, or other notes from my mentor sessions with Michael Goeres _(Promineo Tech)_ during the **Back End Software Development** boot camp.

 
## Week 1

### Questions and topics to discuss

<details ><summary><strong>1. Intros</strong></summary>

* What is your background?
    * What did you study?
    
    * Have you done any other coding coursework/classes/boot camps?
    
    * Experience in other SWE areas? _(e.g. DevOps, Front End, Data Eng, etc.)_
    
    * Where have you worked? 
    
    * How'd you get into the field?

* Other hobbies?

* Open to connecting on LinkedIn and/or other platforms?

</details>

  
<details ><summary><strong>2. Time and Space Complexity, Big O Notation</strong></summary>

* Will this be discussed at all in the course?

* Any recommendations on resources? 

* Any way to practice determining time & space complexity? (i.e. something like LeetCode but for Big O?)
    * _Apart from analyzing my own code, of course_

</details>

  
<details ><summary><strong>3. Other</strong></summary>

* Anything you wish you had known going into the course?
    * _e.g. quirks of Java, code conventions, organization, etc._

* Using GitLab vs. GitHub during the course -- does it matter?
    * How about professionally?

    * Do more organizations use GitLab or something similar? GitPod? etc.
    
* Thoughts on text editors -- Eclipse vs. VS Code?

* **Open source:**
    * Suggestions for getting started & overcoming fear/imposter syndrome
    
    * How do you show off your OS work on a resume or LinkedIn, for example?

* Question about reassigning variables:
    * This code incorrectly returns `true` for both sysouts:
        <details><summary>Example 1</summary>
        
        ```Java
        public static void main(String[] args) {

            int ageRequiredToDrive = 16;
            int currentAge = 14;
            currentAge = 30;

            boolean canPersonDrive = (currentAge >= ageRequiredToDrive);

            System.out.println(canPersonDrive); // returns 'true'
            
            currentAge = 14;
            System.out.println(canPersonDrive); // returns 'true' 
            // Explanation: still returns true bc value of canPersonDrive still holds value of 'true' (bc 30 >= 16)
        }
        ```
        </details>

    * This code incorrectly returns `false` for both sysouts:

        <details><summary>Example 2</summary>

        ```Java
        public static void main(String[] args) {

            int ageRequiredToDrive = 16;
            int currentAge = 14;
            boolean canPersonDrive = (currentAge >= ageRequiredToDrive);
            
            currentAge = 30;
            System.out.println(canPersonDrive); // returns 'false'
            
            currentAge = 24;
            System.out.println(canPersonDrive); // returns 'false'
            // Explanation: again, value of canPerson drive hasn't changed -- it's still 'false' (bc 14 <= 16)
        }
        ```
        
        </details>

    * _**Answer:** the variable `canPersonDrive` is simmply never updated, which is wwhy it continues to return the same value after `currentAge` is reassigned -- we're not running any kind of function that would automatically update `canPersonDrive`; it's statically defined._

</details>


<!-- ### Meeting Notes: Nov 9, 2024

*  -->

</details>
