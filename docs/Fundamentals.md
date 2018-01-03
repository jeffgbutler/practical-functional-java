# Fundamentals

The exercises make heavy use of important changes in Java 8+ including:

- Lazy Streams
- Optionals
- Method References
- Lambda Syntax
- etc.

We will not attempt to cover these topics in too much detail - there are plenty of other tutorials and reference information available for that.  Rather, we will cover a quick overview of what's needed to complete the exercises.

## Immutability

The foundational concept of functional programming is immutability.  This manifests in two important ways:

- Objects should be immutable
- Functions should be "pure"

### Immutable Objects

Simply stated, immutable objects don't have setters, and their getters do not allow access to mutable objects like Lists or Maps. There are many common patterns for creating immutable objects and we will have a whole exercise devoted to this topic, but for now just think "no setters".

### Pure Functions

A pure function does not alter or rely on any external state.  It produces an output based solely on the inputs.

## Practices that will change the way you code

1. All objects are immutable.  Never use your IDE's "generate getters and setters" function.
2. Never deal will null directly.  Use Optional to wrap all values that could be null.
3. Treat Optional.isPresent() as a code smell and avoid it if possible.
4. Never code another for loop.  Use Streams instead.
5. Treat Stream.forEach() as a code smell and avoid it if possible.