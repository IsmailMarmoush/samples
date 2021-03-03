# Reactive Programming
## Futures and promises

Week 1:
> Review of Principles of Functional Programming: substitution model, for-expressions and how they relate to monads. Introduces a new implementation of for-expressions: random value generators. Shows how this can be used in randomized testing and gives an overview of ScalaCheck, a tool which implements this idea.

Week 2: 
> Functional programming and mutable state. What makes an object mutable? How this impacts the substitution model. Extended example: Digital circuit simulation.

Week 3: 
> Futures. Introduces futures as another monad, with for-expressions as concrete syntax. Shows how futures can be composed to avoid thread blocking. Discusses cross-thread error handling.

Week 4: 
> Reactive stream processing.  Generalizing futures to reactive computations over streams. Stream operators.

Week 5: 
> Actors. Introduces the Actor Model, actors as encapsulated units of consistency, asynchronous message passing, discusses different message delivery semantics (at most once, at least once, exactly once) and eventual consistency.

Week 6: 
> Supervision. Introduces reification of failure, hierarchical failure handling, the Error Kernel pattern, lifecycle monitoring, discusses transient and persistent state.

Week 7: 
> Conversation Patterns. Discusses the management of conversational state between actors and patterns for flow control, routing of messages to pools of actors for resilience or load balancing, acknowledgement of reception to achieve reliable delivery.
