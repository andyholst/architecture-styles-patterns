# Patterns implemented in Java

[![Build Status](https://travis-ci.org/MrAsimov/patterns.svg?branch=master)](https://travis-ci.org/MrAsimov/patterns)
[SonarQube](https://sonarcloud.io/dashboard?id=com.design%3Apatterns)

# Introduction

I want to explore architectural patterns, design patterns and other patterns in my quest for exploring patterns. I am 
using the MIT license and want to contribute to learn best practises about patterns and how to document them for anybody
to learn from.

# Table of Contents
1. [Design patterns](#designpatterns)
    1. [Creational patterns](#creational)
    2. [Structural patterns](#structural)
    3. [Behavioural patterns](#behavioural)
2. [Architectural patterns](#architectural)
3. [Design pattern explaination](#designpatternexplination)
4. [Reference](#reference)

# Design patterns <a name="designpatterns"></a>

Design patterns that was mainly written by the Gang of Four guys.

## Creational patterns - Object creation <a name="creational"></a>

[Abstract Factory](./) - TODO

[Builder](./builder/README.md)

[Factory Method](./) - TODO

[Prototype](./) - TODO 

[Singleton](./) - TODO

## Structural patterns - Composition of classes or objects <a name="structural"></a>

[Adapter](./) - TODO

[Bridge](./) - TODO

[Composite](./) - TODO

[Decorator](./) - TODO

[Facade](./) - TODO

[Flyweight](./) - TODO 

[Proxy](./) - TODO

## Behavioural patterns - Charactize the ways in which classes or objects interact and distribute responsibility <a name="behavioural"></a>

[Chain Of Responsibility](./) - []TODO

[Command](./) - TODO

[Interpreter](./) - TODO

[Iterator](./) - TODDO

[Mediator](./) - TODO

[Memento](./) - TODO

[Observer](./) - TODO

[State](./) - TODO

[Strategy](./) - TODO

[Template Method](./) - TODO

[Visitor](./) - TODO

# Architectural patterns <a name="architectural"></a>

[Component](./component/README.md)

[Front Controller](./) - TODO 

[Interceptor](./) - TODO 

[Model View Controller](./) - TODO

[N-Tier](./) - TODO

[Specification](./) - TODO

[Publish–Subscribe](./) - TODO
  
[Naked Objects](./) - TODO 

[Service Locator](./) - TODO

[Active Record](./) - TODO

[Identity Map](./) - TODO

[Data Access Object](./) - TODO 

[Data Transfer Object](./) - TODO

[ADR](./) - TODO 

[Inversion Of Control](./) -TODO

# Design pattern explaination <a name="designpatternexplination"></a>

Explaination of what the design patterns might be used to [1].

## Creating an object by specifying a class explicitly - Abstract Factory, Factory Method, Prototype

Specifying a class name when you create an object commits you to a particular implementation instead of a particular 
interface. This commitment can complicate future changes. To avoid it, create objects indirectly.
                                                              
## Dependence on specific operations - Chain of Responsibility, Command
                                                                                
When you specify a particular operation, you commit to one way of satisfying a request. By avoiding hard-coded requests, 
you make it easier to change the way a request gets satisfied both at compile-time and at run-time.

## Dependence on hardware and software platform - Abstract Factory, Bridge
                                                   
External operating system interfaces and application programming interfaces (APIs) are different on different hardware 
and software platforms. Software that depends on a particular platform will be harder to port to other platforms. It may 
even be difficult to keep it up to date on its native platform. It’s External operating system interfaces and application 
programming interfaces (APIs) are different on different hardware and software platforms. Software that depends on a 
particular platform will be harder to port to other platforms. It may even be difficult to keep it up to date on its 
native platform. It’s important therefore to design your system to limit its platform dependencies.

## Dependence on object representations or implementations - Abstract Factory, Bridge, Memento, Proxy
                                                                                                                            
Clients that know how an object is represented, stored, located, or implemented might need to be changed when the object 
changes. Hiding this information from clients keeps changes from cascading.

## Algorithmic dependencies - Builder, Iterator, Strategy, Template Method, Visitor
                              
Algorithms are often extended, optimized, and replaced during development and reuse. Objects that depend on an algorithm 
will have to change when the algorithm changes. Therefore algorithms that are likely to change should be isolated.

## Tight coupling - Abstract Factory, Bridge, Chain of Responsibility, Command, Facade, Mediator, Observer

Classes that are tightly coupled are hard to reuse in isolation, since they depend on each other. Tight coupling leads to 
monolithic systems, where you can’t change or remove a class without understanding and changing many other classes. The 
system becomes a dense mass that’s hard to learn, port, and maintain.

Loose coupling increases the probability that a class can be reused by itself and that a system can be learned, ported, 
modified, and extended more easily. Design patterns use techniques such as abstract coupling and layering to promote 
loosely coupled systems.

## Extending functionality by subclassing - Bridge, Chain of Responsibility, Composite, Decorator, Observer, Strategy

Customizing an object by subclassing often isn’t easy. Every new class has a fixed implementation overhead 
(initialization, finalization, etc.). Defining a subclass also requires an in-depth understanding of the parent class. 
For example, overriding one operation might require overriding another. An overridden operation might be required to call 
an inherited operation. And subclassing can lead to an explosion of classes, because you might have to introduce many new 
subclasses for even a simple extension. Object composition in general and delegation in particular provide flexible 
alternatives to inheritance for combining behavior. New functionality can be added to an application by composing 
existing objects in new ways rather than by defining new subclasses of existing classes. On the other hand, heavy use of 
object composition can make designs harder to understand. Many design patterns produce designs in which you can introduce 
customized functionality just by defining one subclass and composing its instances with existing ones.

## Inability to alter classes conveniently - Adapter, Decorator, Visitor

Sometimes you have to modify a class that can’t be modified conveniently. Perhaps you need the source code and don’t 
have it (as may be the case with a commercial class library). Or maybe any change would require modifying lots of 
existing subclasses. Design patterns offer ways to modify classes in such circumstances.

# Reference <a name="reference"></a>

[1]: Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides.
[2]: Just Enough Software Architecture by George Fairbanks
