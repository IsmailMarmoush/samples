## Handling Events through old Observer Pattern
Problems:

* [Deprecating Observer Pattern paper By Martin Ordersky](http://infoscience.epfl.ch/record/148043/files/DeprecatingObserversTR2010.pdf)
* [Someone who doesn't agree with the paper](http://java.dzone.com/articles/few-thoughts-deprecating)
* Needs shared mutable state.
* Cannot be composed.
* Leads quickly to “call-back hell”.

**Doing Better**
Use functional programming:
>Events are first class.
Events are often represented as messages.
Handlers of events are also first-class.
Complex handlers can be composed from primitive ones.