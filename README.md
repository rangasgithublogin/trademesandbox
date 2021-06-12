# trademesandbox
**UsedCars.feature** - Implemented the Browser Based test

**TradeMeAPI.feature** - Implemented the web API tests
NOTE: 
* Running it as a data-driven/parameterized for multiple services/fileformats/expected data
* Haven't implemented the XML verification; so on purpose left to throw UnSupportedOperationException
* 3rd Question:
    - I assume you wanted to implement https://api.trademe.co.nz/v1/Categories/UsedCars.json and verify the response
    - This basically gives back all the car info while the browser based test implemented is slightly different
    
**How to Run:**

- Either run the class RunTestSuite or
- from command line run gradlew test

**Reports**

Can be found at target/cucumber/cucumber-html-reports/overview-features.html 

**Caveats...Caveats...Caveats**

Note: 
- When you run the web api tests independently, you'll see the browser driver session being created; but it doesn't bother the test
- I haven't handled instantiating browser driver session based on test types though it can be handled by introducing extra handles just as plain text in the feature file or scenario headings or an annotation
- OR simple keep separate projects