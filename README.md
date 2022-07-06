# fingerprint

1. clone project: git clone <...>
2. navigate to project folder and run ./gradlew build
3. run ./gradlew bootRun
4. server is running on localhost:8080

5. To add fingerprint run command 
curl --request POST 'http://localhost:8080/fingerprint?key=<key_text>' --data-binary '<path-to-file>' -o '<path-and-name-of-outputfile>'

  Example:
curl --request POST 'http://localhost:8080/fingerprint?key=totalsuva' --data-binary '@/Users/jaanusrebane/Desktop/test.txt' -o '/Users/jaanusrebane/Desktop/newtest.txt'
  
6. Identify key value
curl --request POST 'http://localhost:8080/identify' --data-binary '<path-to-file>'
  
  Example:
curl --request POST 'http://localhost:8080/identify' --data-binary '@/Users/jaanusrebane/Desktop/newtest.txt'
  
  returns key_text
