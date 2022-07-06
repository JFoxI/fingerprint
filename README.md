# fingerprint

1. clone project: git clone <...>
2. navigate to project folder and run ./gradlew build
3. run ./gradlew bootRun
4. server is running on localhost:8080

5. To add fingerprint run command curl --request POST 'http://localhost:8080/fingerprint?key=totalsuva' --data-binary '@/Users/jaanusrebane/Desktop/test.txt' -o '/Users/jaanusrebane/Desktop/newtest.txt'
