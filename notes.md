# Reactive programming in scala

## The actor model

### Introduction to Futures

[Scala Documentazion](https://docs.scala-lang.org/overviews/core/futures.html)

[Futures tutorial](https://alvinalexander.com/scala/concurrency-with-scala-futures-tutorials-examples/)

### Actors

The actor model represents objects and their interactions, resembling human organizations and built upon the laws of physics.

An [actor](200~https://www.ijcai.org/Proceedings/73/Papers/027B.pdf):
* is an object with identity
* has a behavior
* only interacts using asynchronous message passing

Upon reception of a message, the actor can do nay combination of the follwing:
* send messages
* create actors
* designate the behavior for the next message

### Actor encapsulation

No direct access is possible to the actor behavior. Only messages can be sent to known addresses (`ActorRef`)
* every actor knows its own address (`self`)
* creating an actor returns its address
* addresses can be sent within messages (e.g. sender)

Actors are completely indipendenta agents of computation:
* local execution, no notion of global synchronization
* all actors run fully concurrently
* message-èassing primitive is onw-way communication

### Actor-interal evaluation order

An actor is effectively single threaded:
* messages are received sequentially
* behavior change is effective before processing the next message
* processing one message is the atomic unit of execution

This has the benefit of synchronized methods, but blocking is replaced by enqueueing a message.



## Handling failure and state

## Distributed computing

## Typed actors

## Stream processing