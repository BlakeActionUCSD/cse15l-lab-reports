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

