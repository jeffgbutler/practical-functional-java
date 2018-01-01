

## Practices that will change the way you code

1. All objects are immutable.  Never use your IDE's "generate getters and setters" function.
2. Never deal will null directly.  Use Optional to wrap all values that could be null.
3. Treat Optional.isPresent() as a code smell and avoid it if possible.
4. Never code another for loop.  Use Streams instead.
5. Treat Stream.forEach() as a code smell and avoid it if possible.