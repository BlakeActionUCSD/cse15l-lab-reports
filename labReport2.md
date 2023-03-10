In order to create the method I used to update the server, I borrowed applicable code from our modified NumberServer.java file.
It uses two for loops:
  One for displaying strings without using /add-message?s=.
  One for updating strings using /add-message?s=.
  
![Image](addCode.png)

I tried entering a few different messages, including the ones from the lab guide. The only method that I ever used was handleRequest, with the URL
as the input. The first screenshot used the second for loop (for updating the website and returning str2).

![image](addTest1.png)

In both screenshots, the same arguments and values are used. The linked list and the counting integer are both updated. In the first screenshot, the iteration is
updated to 3, as this is where the "Testing! 123" text is stored in the linked list.

![image](addTest3.png)

For the second screenshot, the counting integer is at position 0, where the "Hello World!" text is stored in our linked list. These are changed through
a for loop that updates the values with the text copied from the URL.

The third screenshot is an example of what the terminal displays when I run the /add-message?s= command:

![image](addTest2.png)

I created a couple of tests for a couple of the reverse array methods, using the ArrayTests.java file:

![image](bugCodeTest.png)

![image](bugCodeError.png)

![image](bugCodeError1.png)
![image](bugCodeError2.png)

```
@Test 
	public void testReverseInPlace() {
    int[] input1 = { 1, 2, 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3, 2, 1 }, input1);
	}
```
```
  @Test
  public void testReversed() {
    int[] input1 = { 1, 2, 3, 4 };
    assertArrayEquals(new int[]{ 4, 3, 2, 1 }, ArrayExamples.reversed(input1));
  }
  ```
  
As for the code that did not induce failures, I just made all of the numbers in the first array equal to each other, then the second one zero,
as shown in the following code:

```
@Test 
	public void testReverseInPlace() {
    int[] input1 = { 1, 1, 1 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 1, 1, 1 }, input1);
	}
```
```
  @Test
  public void testReversed() {
    int[] input1 = { 0 };
    assertArrayEquals(new int[]{ 0 }, ArrayExamples.reversed(input1));
  }
  ```
  
  The symptom in the first test was always the array not being reversed, while it was always zero in the second one. No errors were caused when the array was
  all the same number in the first test, or always zero in the second test.
  
  The first error appeared to be caused by the array overwriting itself. I just edited the code to a proper swap method. New:
  
  ![image](bugCodeFix1.png)
  
  ```
  static void reverseInPlace(int[] arr) {
    int[] newArr = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArr[i] = arr[i];
    }

    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArr[arr.length - i - 1];
    }
  }
  ```
  
  The second error was caused by the old array copying the new array instead of the other way around. I swapped them around. New:
  
  ![image](bugCodeFix2.png)
  
  ```
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArray[i] = arr[arr.length - i - 1];
    }

    return newArray;
  }
  ```
  
  I learned a lot about creating servers in Java. I was not aware of how easy it was to create a web server and run it through a bash terminal.
  The ability to edit a web server via URL commands was also new to me, and very interesting.
