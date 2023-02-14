I chose to experiment with four different variations of the "find" command:

1. Piping the output of -type f to wc allows us to count the size and number of files in the folder. The -type f command ensures that we only count files,
and wc gives us our output. Using -l and -c allows us to see the number of new lines and bytes.

Input:
```
$ find ./written_2/non-fiction/OUP/Abernathy -type f | wc -l
```

Output (showing that we have 9 files): 
```
9
```

Input:
```
$ find ./written_2/non-fiction/OUP/Berk -type f | wc -l -c
```

Output (showing 4 files and 164 bytes):
```
4     164
```

2. We can use the -size command to find files and directories that are of a certain size. -size +10c would search for files greater than 10 bytes in size.

Input:

```
$ find ./written_2 -size +100k
```

Output (all files over 100 kilobytes):

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

Input:
```

```
