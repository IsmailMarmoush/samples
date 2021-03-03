# SBT Knowledge

## Basics
### Running Scala Code
There are 3 ways to run scala code

* As a script
* As an application with Object. main 
* As an application trait (for simple and one threaded apps)



## Configurations

### Debugging implicits
It helps to write the conversion out explicitly. If that also gives an error message, you then know why the compiler could not apply your implicit.

The -Xprint:typer option to the compiler is useful for this. If you run scalac with this option, then the compiler will show you what your code looks like after all implicit conversions have been added by the type checker. 

### withSource
This setting of type Boolean, which defaults to false, lets you control whether sbteclipse should try to download source artifacts and create Eclipse source attachments for library dependencies.

The following example shows how to make sbteclipse create source attachments:

`EclipseKeys.withSource := true`

Then in SBT console:
```
update-classifiers
eclipse
```
