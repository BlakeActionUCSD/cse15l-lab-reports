A few times throughout the quarter, I revisited the grading script from lab 6 in order to improve it and make it more functional.
The end result is simple, but it delivers an error report to the student, to help them diagnose their submission. If they are successful
in debugging their program, the grader will give them a diploma for their hard work.

The code I used for grade.sh includes junit and -f commands to test the submission once it has been received.

![image](https://user-images.githubusercontent.com/122486246/224913105-fd948305-6fab-49f9-86b3-a703a1146441.png)

In order to test the code, I ran it on a number of student submissions, with the first being the lab 3 ListExamples.java program with the
line 42 runtime error. My grading script successfully determined the issue, relayed information back to the student, and returned low score.

![image](https://user-images.githubusercontent.com/122486246/224914744-b26fa546-e3d5-4c2f-a9f7-839f68844479.png)

Next, I ran the corrected ListExamples.java program through my script. The result was a successful test, with a diploma awarded to the student at the end.

![image](https://user-images.githubusercontent.com/122486246/224915046-f8f71ae5-b0c7-4cff-a518-a31990130bfb.png)

I needed to make sure that the script would still return a low score even if the program failed to compile, so I ran the ListExamples.java
file with a missing semicolon. The script displayed a detailed explanation of the compiler failure on line 15, then returned a low score and
a message that read "Failed to compile."

![image](https://user-images.githubusercontent.com/122486246/224915516-2afffa50-8eb7-4c16-ab80-c78c34e0609e.png)

Finally, I decided to run my script on the most difficult program to diagnose from lab 6: ListExamples.java with subtle errors. The output
did not seem to provide information that was quite as helpful as the previous error messages, but junit was still able to show the student
what the fundamental output error of the code was caused by. The returned score was still low, and the custom runtime error text was correctly
displayed to the student.

![image](https://user-images.githubusercontent.com/122486246/224916082-41d5de63-f8a4-4267-bba2-9185b2725f2d.png)
