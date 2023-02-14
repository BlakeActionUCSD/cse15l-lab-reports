I chose to experiment with four different variations of the "find" command:

1. Piping the output of -type f to wc allows us to count the size and number of files in the folder. The -type f command ensures that we only count files,
and wc gives us our output. Using -l and -c allows us to see the number of new lines and bytes.

 -type f (or -type d for directories) is a necessary tool that allows us to specify what we are searching for, especially when there are directories and files
 with the same name.

 -wc is a quick and simple to read information on files and directories.

Input 1:
```
$ find ./written_2/non-fiction/OUP/Abernathy -type f | wc -l
```

Output 1 (showing that we have 9 files): 
```
9
```

Input 2:
```
$ find ./written_2/non-fiction/OUP/Berk -type f | wc -l -c
```

Output 2 (showing 4 files and 164 bytes):
```
4     164
```

2. We can use the -size command to find files and directories that are of a certain size. For example, -size +10c would search for files greater than 10 bytes.
This is a simple command that can be used to quickly check the size of a file, without having to write additional code.

Input 1:

```
$ find ./written_2 -size +100k
```

Output 1 (all files over 100 kilobytes):

```
./written_2/non-fiction/OUP/Berk/CH4.txt
./written_2/non-fiction/OUP/Berk/ch2.txt
./written_2/travel_guides/berlitz1/WhereToFrance.txt
./written_2/travel_guides/berlitz1/WhereToIndia.txt
./written_2/travel_guides/berlitz1/WhereToItaly.txt
./written_2/travel_guides/berlitz1/WhereToJapan.txt
./written_2/travel_guides/berlitz1/WhereToMalaysia.txt
./written_2/travel_guides/berlitz2/Canada-WhereToGo.txt
./written_2/travel_guides/berlitz2/China-WhereToGo.txt
./written_2/travel_guides/berlitz2/Portugal-WhereToGo.txt
```

Input 2:
```
$ find ./written_2 -size -1000c
```

Output 2 (all files under 1000 bytes):
```
./written_2/travel_guides/berlitz1/HandRIbiza.txt
./written_2/travel_guides/berlitz1/HandRIstanbul.txt
```

3. The -printf format command can give us information about the files, similar to how wc does. The difference is that -printf is much more powerful in many ways.
This command allows us to print information such as the name of a directory's owner, modification time, full path, file names without their paths, and much more.

 For basic information on files during searches, writing up a -printf command line is invaluable, as its formatting is fully customizable.

Input 1:
```
$ find ./written_2/non-fiction/OUP/Rybczynski -type f -printf "File name: %f \n File size: %s bytes \n"
```

Output 1 (displays file name using %f and file size using %s):
```
File name: ch1.txt 
 File size: 34412 bytes 
File name: ch2.txt 
 File size: 38052 bytes 
File name: ch3.txt 
 File size: 52179 bytes
```

Input 2:
```
$ find ./written_2 -type d -printf "Directory: %p\nOwner: %u\n\n"
```

Output 2 (displays directory using %p and owner using %u):
```
Directory: ./written_2
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Abernathy
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Berk
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Castro
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Fletcher
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Kauffman
Owner: cs15lwi23ajt

Directory: ./written_2/non-fiction/OUP/Rybczynski
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides/berlitz1
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides/berlitz2
Owner: cs15lwi23ajt
```

4. Our last output was very large! We can use the -prune command to exclude certain directories. This can be coupled with -name or -path to exclude
directory names or paths, respectively. Using the -o option, we can insert prune into our previous command line and exclude the non-fiction directory.

 This is very useful for excluding large or otherwise troublesome directories from searches, and it allows for much cleaner search results.

Input 1:
```
find ./written_2 -name "non-fiction" -prune -o -type d -printf "Directory: %p\nOwner: %u\n\n"
```

Output 1 (directories in non-fiction are now excluded):
```
Directory: ./written_2
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides/berlitz1
Owner: cs15lwi23ajt

Directory: ./written_2/travel_guides/berlitz2
Owner: cs15lwi23ajt
```

Input 2:
```
$ find ./written_2 -name "travel_guides" -prune -o -type f
```

Output 2 (a much simpler command, showing how to prune the contents a directory "travel_guides" from a find search):

Note: the directory itself is still visible, but find does not search its contents.
```
./written_2/non-fiction/OUP/Abernathy/ch1.txt
./written_2/non-fiction/OUP/Abernathy/ch14.txt
./written_2/non-fiction/OUP/Abernathy/ch15.txt
./written_2/non-fiction/OUP/Abernathy/ch2.txt
./written_2/non-fiction/OUP/Abernathy/ch3.txt
./written_2/non-fiction/OUP/Abernathy/ch6.txt
./written_2/non-fiction/OUP/Abernathy/ch7.txt
./written_2/non-fiction/OUP/Abernathy/ch8.txt
./written_2/non-fiction/OUP/Abernathy/ch9.txt
./written_2/non-fiction/OUP/Berk/CH4.txt
./written_2/non-fiction/OUP/Berk/ch1.txt
./written_2/non-fiction/OUP/Berk/ch2.txt
./written_2/non-fiction/OUP/Berk/ch7.txt
./written_2/non-fiction/OUP/Castro/chA.txt
./written_2/non-fiction/OUP/Castro/chB.txt
./written_2/non-fiction/OUP/Castro/chC.txt
./written_2/non-fiction/OUP/Castro/chL.txt
./written_2/non-fiction/OUP/Castro/chM.txt
./written_2/non-fiction/OUP/Castro/chN.txt
./written_2/non-fiction/OUP/Castro/chO.txt
./written_2/non-fiction/OUP/Castro/chP.txt
./written_2/non-fiction/OUP/Castro/chQ.txt
./written_2/non-fiction/OUP/Castro/chR.txt
./written_2/non-fiction/OUP/Castro/chV.txt
./written_2/non-fiction/OUP/Castro/chW.txt
./written_2/non-fiction/OUP/Castro/chY.txt
./written_2/non-fiction/OUP/Castro/chZ.txt
./written_2/non-fiction/OUP/Fletcher/ch1.txt
./written_2/non-fiction/OUP/Fletcher/ch10.txt
./written_2/non-fiction/OUP/Fletcher/ch2.txt
./written_2/non-fiction/OUP/Fletcher/ch5.txt
./written_2/non-fiction/OUP/Fletcher/ch6.txt
./written_2/non-fiction/OUP/Fletcher/ch9.txt
./written_2/non-fiction/OUP/Kauffman/ch1.txt
./written_2/non-fiction/OUP/Kauffman/ch10.txt
./written_2/non-fiction/OUP/Kauffman/ch3.txt
./written_2/non-fiction/OUP/Kauffman/ch4.txt
./written_2/non-fiction/OUP/Kauffman/ch5.txt
./written_2/non-fiction/OUP/Kauffman/ch6.txt
./written_2/non-fiction/OUP/Kauffman/ch7.txt
./written_2/non-fiction/OUP/Kauffman/ch8.txt
./written_2/non-fiction/OUP/Kauffman/ch9.txt
./written_2/non-fiction/OUP/Rybczynski/ch1.txt
./written_2/non-fiction/OUP/Rybczynski/ch2.txt
./written_2/non-fiction/OUP/Rybczynski/ch3.txt
./written_2/travel_guides
```

For research on all of these commands, I used ChatGPT and the bash manual in the terminal.
