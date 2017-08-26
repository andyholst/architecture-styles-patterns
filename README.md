# Exploration of architecture styles, tactics and patterns and design patterns

The styles, tactics and patterns and design patterns you should understand to work as a solution architect aka software 
architect.

The styles, tactics and patterns and design patterns that have been exemplified (resolved todo), can been viewed as 
a code model and some form of model expressing the design model or the domain model.

The examples exemplified will reflect the styles, tactics and patterns, both architectural pattern and design patterns, 
you can view the uml diagrams of the implementations. There will be architecture-evident-coding to express the styles
 in the code.

[![Build Status](https://travis-ci.org/MrAsimov/architecture-styles-patterns.svg?branch=master)](https://travis-ci.org/MrAsimov/architecture-styles-patterns)
[Sonar Statistics of the code](https://sonarcloud.io/dashboard?id=com.design%3Aarchitecture-styles-patterns)

# Table of Contents
1. [Architectural styles](#styles)
    1. [Structure](#archstructure)
    2. [Shared memory](#archsharedmem)
    3. [Messaging](#archmessaging)
    4. [Adaptive systems](#archadaptive)
    5. [Distributed systems](#archdist)
2. [Architectural patterns](#architectural)
3. [Design patterns](#designpatterns)
    1. [Creational patterns](#creational)
    2. [Structural patterns](#structural)
    3. [Behavioural patterns](#behavioural)
4. [Design pattern explanation](#designpatternexplination)
5. [Reference](#reference)

# Architectural styles <a name="styles"></a>

## Structure <a name="archstructure"></a>

[Component](./component/README.md)

[Layered](./layered/README.md)

[Monolithic Application](./monolithic-application/README.md)

[Pipes And Filters](./pipefilters/README.md)

## Shared memory <a name="archsharedmem"></a>

[Blackboard](./README.md) - TODO

[Data-Centric](./README.md) - TODO

[Rule-Based](./README.md) - TODO

## Messaging <a name="archmessaging"></a>

[Asynchronous Messaging](./README.md) - TODO

[Event-Driven/Implicit Invocation](./README.md) - TODO

[Publish-Subscribe](./README.md) - TODO

## Adaptive systems <a name="archadaptive"></a>

[Domain Specific Languages](./README.md) - TODO

[Microkernel](./README.md) - TODO

[Plug-ins](./README.md) - TODO

[Reflection](./README.md) - TODO

## Distributed systems <a name="archdist"></a>

[Client-Server](./README.md) - TODO

[Cloud Computing](./README.md) - TODO

[Object Request Broker](./README.md) - TODO

[Peer-To-Peer](./README.md) - TODO

[Representational State Transfer](./README.md) - TODO

[Service-Oriented](./README.md) - TODO

[Service EJB](./service/README.md)

[Shared Nothing Architecture](./README.md) - TODO

[Space-Based Architecture](./README.md) - TODO

# Architectural patterns <a name="architectural"></a>

[Active Record](./README.md) - TODO

[ADR](./README.md) - TODO

[Blackboard](./README.md) - TODO

[Data Access Object](./README.md) - TODO

[Data Transfer Object](./README.md) - TODO

[Front Controller](./README.md) - TODO

[Identity Map](./README.md) - TODO

[Interceptor](./README.md) - TODO

[Inversion Of Control](./README.md) - TODO

[Model View Controller](./README.md) - TODO

[Multilayered Architecture](./README.md) - TODO

[N-Tier](./README.md) - TODO

[Naked Objects](./README.md) - TODO

[Presentation–Abstraction–Control](./README.md) - TODO

[Sensor-Controller-Actuator](./README.md) - TODO

[Service Locator](./README.md) - TODO

[Specification](./README.md) - TODO

# Design patterns <a name="designpatterns"></a>

Design patterns that was mainly written by the Gang of Four guys.

## Creational patterns - Object creation <a name="creational"></a>

[Abstract Factory](./abstract-factory/README.md)

[Builder](./builder/README.md)

[Factory Method](./factory-method/README.md)

[Prototype](./prototype/README.md)

[Singleton](./singleton/README.md)

## Structural patterns - Composition of classes or objects <a name="structural"></a>

[Adapter](./README.md) - TODO

[Bridge](./README.md) - TODO

[Composite](./README.md) - TODO

[Decorator](./README.md) - TODO

[Facade](./README.md) - TODO

[Flyweight](./README.md) - TODO

[Proxy](./README.md) - TODO

## Behavioural patterns - Characterize the ways in which classes or objects interact and distribute responsibility <a name="behavioural"></a>

[Chain Of Responsibility](./README.md) - TODO

[Command](./README.md) - TODO

[Interpreter](./README.md) - TODO

[Iterator](./README.md) - TODO

[Mediator](./README.md) - TODO

[Memento](./README.md) - TODO

[Observer](./README.md) - TODO

[State](./README.md) - TODO

[Strategy](./README.md) - TODO

[Template Method](./README.md) - TODO

[Visitor](./README.md) - TODO

# Design pattern explanation <a name="designpatternexplination"></a>

Explanation of what the design patterns might be used to [1].

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

[1]: [Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides.](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612/)

[2]: [Just Enough Software Architecture by George Fairbanks](https://www.amazon.com/Just-Enough-Software-Architecture-Risk-Driven/dp/0984618104/)
