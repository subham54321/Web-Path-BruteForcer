# Web-Path-BruteForcer in Java

### Problem Statement: Build a minimal web path bruteforcer: Optimised memory, CPU usage

#### The CLI interface to the web path bruteforcer should accept these from the user:

* WebApp URL

* A file containing a list of webapp paths that need to be brute forced against the specified
webapp url [Minimum paths: 1000]

Sample wordlist: Link

* List of success status code: (default: [200])


## Sample Input:
```
Webapp url: https://www.github.com
Webapp paths: sample 5 lines out of 1000 of the input file wordlist.txt
•admin
•info
•.git/config
•.htaccess
•pricing

•Success status codes: [200, 302]
```

## Sample Output: 
```A list of URLs that responded with any of the success status codes as provided in
the input by the user.

• https://www.github.com/info [Status code 302]
• https://www.github.com/.htaccess [Status code 200]
```
## How to use
```
java bruteforcer [Base URL] [WordList Path] [Status Code]
```

## Sample Input
```
java bruteforcer https://github.com /Users/subhamsharma/Desktop/bruteforcer/wordlist.txt 200 404
```
## Sample Output
```
https://github.com/admin[Status code 404]
https://github.com/info[Status code 404]
https://github.com/.git/config[Status code 404]
https://github.com/.htaccess[Status code 404]
https://github.com/pricing[Status code 200]
```

## Note 
Multithreading is used for faster performance.
