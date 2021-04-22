# Project Report

Caleb Van Lue

## Challenge #1 Complete

For this challenge, I modified a line in the QueryEngineModule class 
in order to use the real WikipediaQueryEngine instead of the fake one.
Initially, the QueryEngine interface was being bound to the FakeQueryEngine
class, so by replacing FakeQueryEngine with WikipediaQueryEngine on line 14, 
I was able to utilize a proper connection to Wikipedia rather than a 
simulated one.


## Challenge #2 Complete

For this challenge, I found the timestamp of each revision to be the
biggest eyesore, so that's what I sougght to correct. In order to do this,
I created the RevisionInterface, which holds a Date format that matches those
of Wikipedia's timestamps, as well as the format() method that returns a 
properly formatted String (that is slightly prettier than previous
implementations). Next, I implemented this interface in the RevisionFormatter
class, which allowed me to simplify the creation of the returned string by
utilizing that previously defined Date format in the implemented interface.
Once the timestamp had been modified to look better, I created the 
RevisionInterfaceModule, which binds the RevisionInterface to the 
RevisionFormatter class, injecting the proper dependency at runtime. 
Finally, I added this module to the Guice injector within the App class. 
I feel that this slight modification makes the timestamps much simpler to
read, thus making the application more user-friendly.


## Challenge #3 Complete

For this challenge, I began by converting the list of revisions into a stream
using the .stream() method in runQuery() in the WikipediaAnalyzer class, right
before where the old for loop began. Once converted to a stream, I needed to 
use the RevisionFormatter's format method to properly format the revisions into 
readable text. To do this, I used the .map() method to apply the format() method
to each of the elements in the stream. Once all of the revisions have been properly
formatted, it was time to collect them all and join with "\n" as a separator so that
they would all appear on different lines. In order to use RevisionFormatter's format() 
method, I needed to remove the thrown ParseException that I included during a previous 
challenge. 


## Reflection Question #1: Functional vs OO

(Write one or more paragraphs comparing and contrasting the iterative and functional  
approaches to string concatenation you explored in challenge #3. Which do you
prefer, and why?)

In most of my previous projects, I utilized the iterative approach to string concatenation
rather than the functional one. As a beginning programmer, this process made more sense to 
me, as I could follow along with each line to determine what exactly was happening with my 
data. Now, as a more advanced programmer, I feel that I prefer the functional approach. The 
ability to condense many lines of code down to a single line through method chaining is very 
satisfying to me, and I now find it simpler to analyze what each method is doing through this 
approach. The functional approach seems cleaner to me: why use many lines to accomplish one 
thing when you can do the exact same thing in one line? 

## Reflection Question #2: Polymorphism and Dependency Inversion

(Explain how polymorphism engendered dependency inversion in this little
application. Be clear and precise here, as this is, in part, an assessment of
your correct use of technical terminology.
Consider, for example, where exactly is polymorphism used?
Where exactly is a dependency inverted?)

Through the use of dynamic polymorphism in the RevisionFormatter and RevisionInterface
classes, dependency inversion is created. By creating an interface to be used by the 
RevisionFormatter class, we introduce abstraction to this application. Abstraction is also
applied through the QueryEngine interface and the FakeQueryEngine/WikipediaQueryEngine classes.
As any instances of these classes that implement the interfaces are instances of multiple types
of classes, polymorphism is present in each of them. This separation through the abstract layer
and the binding through Guice allows us to invert the dependencies and follow the Dependency
Inversion Principle. By coding through our interfaces rather than our concrete classes, we are 
able to depend on the abstraction, inverting the dependencies.