I chose to experiment with four different variations of the "find" command:

1. Piping the output of -type f to wc allows us to count the size and number of files in the folder. The -type f command ensures that we only count files,
and wc gives us our output. Using -l and -c allows us to see the number of new lines and bytes.

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
