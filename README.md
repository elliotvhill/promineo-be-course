# Mentor Sessions Notes

A repository to store any questions, discussion topics, tips, or other notes from my mentor sessions with Michael Goeres _(Promineo Tech)_ during the **Back End Software Development** boot camp.

_[Course Syllabus](https://github.com/elliotvhill/promineo-be-course/blob/main/week_0/2023PTBESyllabus.pdf)_

## Week 7

### Questions

#### Open Class MySQL questions part 1 — `JOIN` example:
- Why isn't the `AS` keyword needed when using table aliases?
    
    ```sql
    SELECT ci.city, co.country FROM city ci
    INNER JOIN country co USING (country_id)
    WHERE ci.city LIKE 'Ab%';
    ```

## Week 5

### Questions and topics to discuss

- OOP:
    - I still have a really hard time wrapping my head around this, and figuring out how to describe/explain it (i.e. in an interview situation).
    - Why _wouldn't_ one use OOP these days?
    - I honestly don't understand why _such huge_ emphasis is placed on it-- i.e. _always_ specifically called out in job descriptions, etc. It seems like pretty intuitive principles...?
- Exceptions:
    - If you handle an unchecked exception...does that mean it's now a _checked_ exception...?


## Week 4

### Questions and topics to discuss

- Method overloading _(again)_:
    - Referenced in Java Docs [when discussing StringBuilder](https://docs.oracle.com/javase/tutorial/java/data/buffers.html#:~:text=The%20principal%20operations%20on%20a%20StringBuilder%20that%20are%20not%20available%20in%20String%20are%20the%20append()%20and%20insert()%20methods%2C%20which%20are%20overloaded%20so%20as%20to%20accept%20data%20of%20any%20type.)
    - What is the use case for overloading a method?
- `new ArrayList<>()` vs `new ArrayList<String>()` -- just for stronger typing?

## Week 3

### Questions and topics to discuss

- Increment `counter` variable from within `sysout`:

    ```java
    int[] gradesArray = {100, 97, 80, 85, 79};
    int counter = 1;
            System.out.println("Grades:");
            for (int grade : gradesArray) {
                System.out.println((counter++) + ": " + grade);
            }
    ```

- `ArrayIceCreamOrder` example menu application ([link](https://learn.promineotech.com/mod/book/view.php?id=20014&chapterid=1943))
    - Default constructor vs other constructors? Is it that we need to define separate constructors for all user cases _(i.e. if user does not input values for each variable)_?
        - Is this an example of _overloading_ a method? Please explain
    - Getters & setters

<details><summary><strong>Lab 3 questions</strong></summary>

- Question 12: "_calculate the sum_ of all the letters" -- what does this mean? Should we _concatenate_ all the letters? Or count how many are in the strings combined?

- Method question 16: using a for loop with an if statement seems verbose... why doesnt using a ternary work? e.g. something like this:

    ```java
    public static boolean stringExists(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            boolean stringMatch = arr[i].equals(str);
            stringMatch == true ? true : false;
        }
    }
    // Throws "System error on token: invalid '==' operator"
    ```
- Question 19: strange output

    <details><summary><em>Code:</em></summary>

    ```java
        // 19. Write and test a method that takes an array of Strings and
        // returns an array of int where each element
        // matches the length of the string at that position
            String[] teams = {"Chelsea", "Arsenal", "Ipswich", "West Ham"};
            stringLengths(teams);

        // Method 19:
            public static int[] stringLengths(String[] arr) {
                int[] lengths = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    lengths[i] = arr[i].length();
                }
                System.out.println(lengths); // Output: [I@251a69d7
                return lengths;
            }
    ```
        
        
    </details>

    - **Explanation:** have to use `.toString()` method to print arrays to console

</details>
    
<details><summary><strong>Open Class lessons questions</strong></summary>
    
- Open Class lesson Methods part 1:
    - What is the use case for overloading a method? Why use the same method name? Couldn't that potentially be confusing?
- Open Class lesson Methods part 2:
    - Question 13: sumOfDigits Method -- I just don't get the math
- Open Class Arrays part 1:
    - States that declaring the length of an array is _optional_ -- I thought it was _required_?
        - ...Or are they just referring to declaring with an Array initializer vs. a `new` constructor?
    - Aren't arrays immutable in Java? _**Answer:** No, values can be exchanged; **length** cannot, though_

</details>


## Week 2

### Questions and topics to discuss

<details><summary><strong>Lab week02 question 6</strong></summary>

**Question 6:**

```java
// 6. Cookie Distribution:
		// Note: You will evenly distribute all of the cookies to the children
		// and as the adult you get to keep the remaining cookies for yourself.
		
		// a. Create two variables called numberOfCookies and numberOfChildren.
		// b. Initialize the two variables to integer values.
		// b. Use a conditional to print the following based on the following
		// conditions:
		// i. If there are 0 cookies remaining, print "Sad Face"
		// ii. If there are less than 2 cookies, print "Yes!"
		// iii. If there are less than 5 cookies, print "Whoohoooo!"
		// iv. If there are 5 or more cookies, print "Jackpot!"
```

**My solution:**

```java
int numberOfCookies = 18;
		int numberOfChildren = 14;
		
		int result = numberOfCookies % numberOfChildren;
		
		if (result == 0) {
			System.out.println("Sad Face");
		} else if (result < 2) {
			System.out.println("Yes!");
		} else if (result < 5) {
			System.out.println("Whoohoooo!");
		} else {
			System.out.println("Jackpot!");
		}

// My Questions:
//		Q: Can we assume cookies remain whole?
//		i.e. if cookies cannot be divided evenly
//		among children, does adult keep _all_ cookies?
		
//		Q: For time/space optimization, does it make sense to use memory 
//		or to repeat the calculation w/o using extra storage?
```


</details>


<details><summary><strong>Other code questions</strong></summary>

- What does the Java error `dead code` mean?
    > _In Eclipse, "dead code" is code that will never be executed. Usually it's in a conditional branch that logically will never be entered._


</details>



 
## Week 1

### Questions and topics to discuss

<details ><summary><strong>1. Intros</strong></summary>

- What is your background?
    - What did you study?
    
    - Have you done any other coding coursework/classes/boot camps?
    
    - Experience in other SWE areas? _(e.g. DevOps, Front End, Data Eng, etc.)_
    
    - Where have you worked? 
    
    - How'd you get into the field?

- Other hobbies?

- Open to connecting on LinkedIn and/or other platforms?

</details>

  
<details ><summary><strong>2. Time and Space Complexity, Big O Notation</strong></summary>

- Will this be discussed at all in the course?

- Any recommendations on resources? 

- Any way to practice determining time & space complexity? (i.e. something like LeetCode but for Big O?)
    - _Apart from analyzing my own code, of course_

</details>

  
<details ><summary><strong>3. Other</strong></summary>

- Anything you wish you had known going into the course?
    - _e.g. quirks of Java, code conventions, organization, etc._

- Using GitLab vs. GitHub during the course -- does it matter?
    - How about professionally?

    - Do more organizations use GitLab or something similar? GitPod? etc.
    
- Thoughts on text editors -- Eclipse vs. VS Code?

- **Open source:**
    - Suggestions for getting started & overcoming fear/imposter syndrome
    
    - How do you show off your OS work on a resume or LinkedIn, for example?

- Question about reassigning variables:
    - This code incorrectly returns `true` for both sysouts:
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

    - This code incorrectly returns `false` for both sysouts:

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

    _**Answer:** the variable `canPersonDrive` is simmply never updated, which is wwhy it continues to return the same value after `currentAge` is reassigned -- we're not running any kind of function that would automatically update `canPersonDrive`; it's statically defined._

</details>


### Meeting Notes: Nov 9, 2024

#### Intros

- Mike was a BE student, previous background in IT.
- Started going to office hours a lot, helping others, and was offered position of his mentor when she left.

#### Big O

- Outside scope of the course, but could ask Instructor about it

#### Open Source

- Mike does not have experience with OS projects.
- Suggested reaching out to one of the FE mentors to meet with next week, if desired.

#### Git platforms

- GitHub is used to submit assignments and is preferred.

#### Editors

- Can use either Eclipse or VS Code for course -- Mike has a lot of experience helping students with both.
- Eclipse does a better job of visualizing the Java hierarchy--i.e. projects, packages, classes, etc. -- than VS Code.

--  

<details><summary><em>Fathom.ai summary</em></summary>


**Elliot Hill: Back End Mentor Session**

Mentor session overview @ 0:00
> Michael and Elliot introduce themselves and discuss the purpose of the mentor session, which is for Elliot to ask general questions about the back-end development course and get advice from Michael, who previously completed the same bootcamp program.

Code editor preferences @ 3:36
> Elliot discusses his experience using Eclipse versus VS Code, noting that he is more comfortable with VS Code but is leaning towards using Eclipse for the course since it provides better visibility into the Java project structure. Michael advises that either editor is acceptable, as the focus is on learning to code rather than the specific IDE.

GitHub and version control @ 4:54
> Elliot shares his past issues with his GitHub account being suspended, and asks if it's acceptable to use GitLab instead. Michael confirms that GitHub is the preferred platform for submitting assignments, but Elliot can use VS Code to manage his code and submit it through other means if needed.

Advice for bootcamp success @ 9:15
> Michael provides advice based on his own experience going through the bootcamp, emphasizing the importance of taking advantage of mentor sessions, closely following the video lessons, and not getting stuck on any one problem for too long. He encourages Elliot to use the available resources and not be afraid to ask for help.

Recap and next steps @ 12:44
> Elliot summarizes the key topics discussed and thanks Michael for the helpful advice. Michael reminds Elliot about the additional resources provided, and encourages him to continue reaching out to mentors if he needs further assistance.

</details>

<details><summary>Full transcript</summary>

_Video link: https://fathom.video/share/DJPJKeK2P_R6V3nS7LHBwmRyKVu-rCSu_

**Michael Goeres**  
This meeting is being recorded. How are you doing today?

**Elliot Hill**  
Hey there, I'm doing well. How are you?

**Michael Goeres**  
Not bad, not bad at all.

**Elliot Hill**  
Let's do some window management here. Here we go. I appreciate you taking the time to meet on the weekend, by the way.

**Michael Goeres**  
I work two days through Saturday, so that works out. Okay. Saturday being the day thing to do, might be something that someone might need help on it.

**Elliot Hill**  
That's fair, yep.

**Michael Goeres**  
So what can I help you with?

**Elliot Hill**  
So I don't have a whole lot of questions. I kind of have just general questions. So just for a little bit of background about me, I have a bit of experience with coding. I actually did a full stack boot camp last year. It was largely front end though, which is why I'm here doing the back end.

So all the content, you know, from week one, and I've started week two even. I'm pretty good with. I have no experience with Java, but JavaScript, I know.

**Michael Goeres**  
Coding concepts are the same, the syntax is different.

**Elliot Hill**  
Exactly. Yeah, yeah. So I just had more questions about like the course in general and just like the field in general, if that's cool.

I'm curious. uh like to talk especially about open source projects um because that's open source okay uh the assignments oh no sorry just in general like yeah open source um because we have assignments that are open class but you're talking about yeah yeah yeah um yeah i i have not really dealt into you know trying to contribute to any open source projects yet i have i have a lot of imposter syndrome um and i just like wonder like do you have much experience with open 

**Michael Goeres**  
I have no experience in that either, unfortunately. I almost refer you to Michael Barnell the front end mentor; I think he's done a couple open source things and if you'd like to schedule a mentor we can change that for next week.

**Elliot Hill**  
I just know that that's, you know, as someone who's a career changer, like that's something that can help build experience. So that's why I ask, um, cool. The, let's see, I have some notes here. That's what I'm looking at.

Um, these are all just like really boring questions.

**Michael Goeres**  
That's all right.

**Elliot Hill**  
So I kind of more specific to the class talking about code editors. I have never used Eclipse until now.

I'm coming from VS code. Um, does it really matter? I'm, I'm leaning more towards sticking with Eclipse. for the course because it seems like it's good to know and and used in the field a lot. But I like I said, I've got more experience with VS code and I'm struggling with the the key bindings 

**Michael Goeres**  
Yeah, 100% you are allowed to use VS code.

**Elliot Hill**  
Okay.

**Michael Goeres**  
I mean just like you said Eclipse is good to know because you may go work for something that uses it. But yeah, at the same time, we're here to teach you coding not not Eclipse.

**Elliot Hill**  
Yeah. Yeah, okay Yeah, I think I'm gonna try and stick with eclipse for now, but There's a couple things that really frustrate me so far about it. So we'll see if that lasts.

Kind of similarly talking about platforms Does it matter Do you recommend using Either github or GitLab one or the over the other for the course, I know github obviously is like the big one

**Michael Goeres**  
um, we actually teach Git, we teach to use the GitHub in a very basic manner in week three. that's what we use for you submit your assignments to GitHub, then we can go get them and grade them and okay.

**Elliot Hill**  
So I asked that because I have mostly I had a really fun problem with my GitHub account a couple months ago where I was inexplicably, what's the word not banned, but suspended my account was suspended right before I was trying to interview for a job.

**Elliot Hill**  
Yeah, so I was like, okay, so I know it took them like two months to respond.

**Michael Goeres**  
Only two months because I have another that was suspended and they never responded.

**Elliot Hill**  
Wow.

**Michael Goeres**  
So he ended up, he ended up submitting his assignments to me on Slack. Oh, okay. 

**Elliot Hill**  
Yeah. So that's that's why like more recently I made this and I've mostly been on git lab now using that.

And so I was curious if it matters if I were just like to submit assignments or if you prefer use GitHub.

Okay. Yes. Okay. Just curious. Also good to know.

**Michael Goeres**  
Let's see. With VS Code, you can submit that way. teach how to use terminal or the command prompt because there's more things you can do there.

**Michael Goeres**  
VS Code does so many things automatically for you that it's really nice.

**Elliot Hill**  
It is really nice.

**Michael Goeres**  
But I've helped troubleshoot with it.

**Elliot Hill**  
Yeah. And that's kind of like going back to that. like, I don't know. I feel like it's worth learning Eclipse.

I feel like VS Code, in a lot of ways, maybe makes things too easy sometimes, especially if you're new.

You know, it's kind of like a crutch, there's a lot of crutches 

**Michael Goeres**  
The nice thing about Eclipse is it teaches you about the Java hierarchy better than...

Because in Java, in Eclipse, there's a project. And with the project, there's the SRC folder. And then with the SRC folder, you make a package, then with the package, you make a class.

Yeah. in VS Code, you make the project, but then the packages don't really come out looking like packages. Because in Eclipse, package looks like a little four-door file cabinet. 

**Elliot Hill**  
Yeah. Yeah. I have noticed that.

That does make sense to me. Let's see. I also was wondering... I'm pretty sure I was... The syllabus, again, I'm pretty sure this is...

outside the scope of what we'll be doing in class, but is there, is there any discussion ever of, of like determining space and time complexity for algorithms like Big O notation?

**Michael Goeres**  
We don't deal with Big O. You're welcome to ask your instructor about it though.

**Elliot Hill**  
Okay, okay.

**Michael Goeres**  
My instructor, when I went through the course, he mentioned Big O and kind of said, hey, look into it.

Yeah, outside the scope of this course, but.

**Elliot Hill**  
Got it. Good to know. That was my question. Yeah. Yeah. I've, I've looked at some resources and I'm like trying to wrap my head around it, but having a little tough time.

Okay. I figured that was the case. 

And then I kind of just broadly, I believe I understand and you went through the bootcamp yourself?

**Michael Goeres**  
Yes, I did.

**Elliot Hill**  
Any general advice, tips, things you wish you knew going into it? Looking back?

**Michael Goeres**  
Mentor sessions. I didn't do as many mentor sessions as I should have, because I have an associate's degree in IT.

But it had been five years by the time, since I graduated before I got into the bootcamp. I had not used any of it at all.

some of Java was like, oh, yeah, remember that. of it was like, I don't remember any about that. this course actually teaches some things to me in a better way than my community college did, as far as Java goes.

Yeah. And then I had never heard of an API when I was going through a community college. the last six weeks is all about APIs.

**Elliot Hill**  
Yeah.

**Michael Goeres**  
The videos is the biggest thing I can recommend, because each week in the LMS there's the videos, then the labs, then the open class, not open source, open class, and then the quiz and some other things, but I always stress watch the videos, code along with them, because that's your resource.

When you go to do the labs, you're like, oh, we did that in the videos, but if you don't code along with the videos, you've got to watch the video again.

**Elliot Hill**  
Yeah, definitely.

**Michael Goeres**  
Just carry that through, and I don't think you'll have this problem, but in the open class, Google searches your friend.

And I recommend if you get stuck on a question, you really want to, you have to find the answer then spend an hour on it.

you haven't found it, just submit the answer, and then every question after you submit it. We'll show you the instructor's solution, submit it and look at the answer and learn from that.

I may even say half an hour. I say half an hour to an hour on any one question. Yeah, as your frustration level goes up, you're learning to go down.

**Elliot Hill**  
Yeah, that's definitely a trap I have fallen into. I was going to say in the past, actually quite frequently is I just spend too much time trying to fight problems and at a certain point have to just call and be like, okay, let me yeah, yeah, just see if I can get 

**Michael Goeres**  
Wave the white flag and yeah.

So are you in one-- you're at least in the one help channel, are you in all four help channels?

**Elliot Hill**  
I, thought I was.

**Michael Goeres**  
You're one through six, can see I'm just in one through six, Or 7 through 12. Excuse me. Now you are.

**Elliot Hill**  
great, Thank you.

**Michael Goeres**  
And don't be afraid to post in the help channels.

**Elliot Hill**  
Yeah. Awesome. Thank you. Cool.

**Michael Goeres**  
Getting better about when I meet with the students in week one is like check the help channels to make sure they're in them.

Yeah. Over a year and a half after we've been doing this, I finally figured it out. Hey, just act it.

**Elliot Hill**  
Yep. rest of that. Make sure everybody's set. Cool. Thank you for that.

That was kind of all the things that I wanted to ask about it. I saw the links that you sent over just before we hopped on.

some of them I've definitely taken a look at, but I'll take a look and go through them.

**Michael Goeres**  
Yeah, they're just there for resources. Yeah, it's not study materials.

**Elliot Hill**  
Yeah. Yeah.

**Michael Goeres**  
The last two Java range and codingbat-- Java range, I haven't spent really any time on it, but it looks like they have like questions.

That's all that is is practice Java to do questions. They do Python too on coding.

**Elliot Hill**  
Oh, okay.

**Michael Goeres**  
Okay. You can make a going for Coding Bat going to sign up for an account and get a password because I've never got any spam from them, but they keep track of your progress.

**Elliot Hill**  
Okay. Good to know. Yeah, I had not heard of this before. I'll definitely do that. I know how I'm going to spend the rest of my afternoon.

Yeah, I think I think that's really about it.

**Michael Goeres**  
I'll give you back some of your day then. like, yeah, the only thing is, like I said, don't be afraid of mentors that's because I figured I know all this because I've got an associate's degree.

It's like, no, eventually I had to get help.

**Elliot Hill**  
Oh, yeah, definitely.

**Michael Goeres**  
Yeah, that's how I kind of fell into the job is because I started going to office hours to I started helping out in office hours because after I've been through it, there's like a new cohort started behind me.

It's like, oh, so they're four weeks behind. Oh, yeah, I can help them. Yeah, yeah, I'm just talking around to help after graduating while I looking for a job.

then my mentor moved on to a coding job and so I got her job. it works out well.

**Elliot Hill**  
Awesome. Yeah, yeah, I definitely I hope to help out as much as I can to my classmates and wherever I can.

**Michael Goeres**  
And I think you see the Michael's fathom note-taker. That's just an AI bot that records and takes a transcript, you'll always get a link to that. 

**Elliot Hill**  
Awesome. That's great, thank you.

**Michael Goeres**  
Cool. Yeah. Other than that, you guys have a good rest of your weekend. 

**Elliot Hill**  
Thank you very much. Bye. Bye.

</details>

### Resources Shared

- https://www.geeksforgeeks.org/introduction-to-java/?ref=lbp
- https://www.geeksforgeeks.org/loops-in-java/#
- https://www.programiz.com/java-programming/for-loop
- https://introcs.cs.princeton.edu/java/home/
- https://www.youtube.com/@alexlorenlee/videos
- https://www.youtube.com/@CodingWithJohn
- https://en.wikibooks.org/wiki/Java_Programming/Getting_started
- https://math.hws.edu/javanotes/index.html
- https://docs.oracle.com/javase/tutorial/getStarted/TOC.html
- https://javaranch.com/
- https://codingbat.com/
