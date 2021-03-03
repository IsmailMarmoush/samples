## Akka Fault tolerance
* http://doc.akka.io/docs/akka/snapshot/scala/fault-tolerance.html

--------------------------------------

## Effective Akka Book
### Actors Should Do Only One Thing
* Create Specific Supervisors

**The One-For-One Strategy vs. All-For-One Strategy**
1. OneForOne is a great strategy when the kind of failures that occur are **specific to a single actor**. This can be exceptions that occur when handling work passed in a message, or a runtime exception focused on a failure that would not affect other actors. 
2. AllForOne is a strategy you may want to employ when the kind of failure affects all of the actors under the supervisor, Example **an exception connecting to a database in a child actor that will affect all**—in this case, you can use AllForOne to stop all actors under the supervisor until the connection is known to have been reestablished.

* Keep Kernel Simple
By introducing more layers and handling exceptions that may arise in them, instead of handling all of these in the root kernel

### Avoid Blocking 
* Futures Delegation Example 
* Pre-defining Parallel Futures
* Parallel Futures with the zip() Method 35
* Sequential Futures 35
* Callbacks(onComplete,onSuccess..) versus Monadic Handling(for comprehension) 36
> Use callbacks for side-effecting responses such as database access calls. Use monadic for non 
side effecting (functional). And note that callbacks can be unwieldy if we do nested futures.  
* Futures and ExecutionContext 36
* Push, Don’t Pull 37
* When You Must Block 39
* Managed Blocking in Scala 39

### Avoid Premature Optimization
* Start Simple 40
* Layer in Complexity via Indeterminism 42
* Optimize with Mutability 42
* Prepare for Race Conditions 44

### Be Explicit
* Name Actors and ActorSystem Instances 46
* Create Specialized Messages 46
* Create Specialized Exceptions 47
* Beware the “Thundering Herd” 48

### Don’t Expose Actors
* Avoid Using this 49
* The Companion Object Factory Method 50
* Never Use Direct References 52
* Don’t Close Over Variables 52
* Use Immutable Messages with Immutable Data 53

### Help Yourself in Production
* Make Debugging Easier 55
* Add Metrics 55
* Externalize Business Logic 55
* Use Semantically Useful Logging 55
* Aggregate Your Logs with a Tool Like Flume 57
* Use Unique IDs for Messages 57

### Tune Akka Applications with the Typesafe Console
* Fixing Starvation 58
* Sizing Dispatchers 60
* The Parallelism-Factor Setting 60
* Actor Mailbox Size 60
* Throughput Setting 60
* Edge Cases 

------------------------------------
