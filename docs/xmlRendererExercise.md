# XML Renderer Exercise
The goal of the XML renderer exercise is to create a renderer for an XML model.

The model classes are in the "xml.model" package and are complete - you should not need to make any changes in those classes. Ultimately the renderer should accept a `xml.model.Document` object and return a String containing properly formatted XML:

1. Proper XML Header
2. Proper Doctype
3. Rendered XML with sub-elements indented 2 spaces

This exercise demonstrates building a complex system based solely on small functions.  This is a core concept in functional programming: functions are building blocks that can be combined to create something more complex.

In this exercise we will guide you through the creation of a full XML renderer starting from very small functions. You should not think that you can arrive at a solution like this from the very start without practice.  The solution we will implement is the result of many refactorings during the development of the exercise.  Our hope is that when you see the solution presented here it will spur your imagination towards refactoring your own code.

In our solution, almost every function is one line long (meaning one semicolon), and there is only one if statement. All functions are pure and there is no external state. 

## Objectives:

1. Demonstrate the power of small pure functions and how they can be combined to make a larger system
2. Practical use of:
   - Stream.collect and the Collectors.joining() collector
   - Stream.map
   - Stream.flatMap
   - Stream.filter

## Overview of the XML Model
The classes in the `xml.model` package implement a simple XML model.  A `Document` consists of

1. An optional DocType (can be either a `PublicDocType` or a `SystemDocType`)
2. A root `XmlElement`

An `XmlElement`:

1. May or may not have `Attributes`.  `Attributes` are a list of `Attribute` classes. An `Attribute` is a name-value pair.
2. May or may not have child elements.  Child elements may be either another `XmlElement` or a `TextElement`.  `XmlElements` may be nested to any depth.

### What's Up With the Visitors?
There are two visitors `DocTypeVisitor` and `ElementVisitor`.

The GoF Visitor pattern is useful in cases like this where there is an inheritance hierarchy.  For example, a `Document` may have a DocType and the DocType may be either a `PublicDocType` or a `SystemDocType` - but the `Document` only knows there there is some subtype of `AbstractDocType`.  The two classes must be rendered differently.  The visitor allows us to make a type safe renderer without having to do `instanceof` checks.

The Visitor pattern can be complex because of the weird method names, but we've done the work of setting it up for you and we will guide you through usage.

Language enthusiasts will note that we only need the Visitor here because Java doesn't have structural pattern matching.  Languages like Scala have structural pattern matching and can avoid the use of visitors in situations like this.

## Exercises
The goal is to make all the tests in `src/test/java/exercises/xml` pass.  You will accomplish this by completing methods in the classes in `src/main/java/exercises/xml`.  If you get stuck at any point, you can look in the classes in `src/main/java/solutions/xml` for guidance.

**Important:** Before staring the exercises, remove the `@Ignore` annotation from four classes in `src/test/java/exercises/xml`.  This will expose 13 unit test errors that you will resolve by completing the exercises.

1. (S) Complete the method `exercises.xml.AttributeRenderer.renderAttribute(Attribute)`
   - The method is simple string concatenation rendering an `Attribute` as `name="value"`
   - Finishing this method should resolve one failing test.

2. (M) Complete the method `exercises.xml.AttributeRenderer.renderAttributes(Attributes)`
   - The method should return a string composed of each rendered attribute in alphabetical order with a single space between each attribute (hints: `Attribute` is sortable, and the `Collectors.joining()` collector is useful here)
   - The method should use a method reference to the `renderAttribute` method
   - Finishing this method should resolve one failing test.

3. (S) Complete the method `exercises.xml.DocTypeRenderer.visit(SystemDocType)`
   - This method is simple string concatenation and should return `SYSTEM "dtdLocation"`
   - Finishing this method should resolve one failing test.

4. (S) Complete the method `exercises.xml.DocTypeRenderer.visit(PublicDocType)`
   - This method is simple string concatenation and should return `PUBLIC "dtdName" "dtdLocation"`
   - Finishing this method should resolve one failing test.

5. (S) Complete the method `exercises.xml.ElementRenderer.visit(TextElement)`
   - This method is very simple should return a `Stream<String>` consisting of the content of the `TextElement`
   - Finishing this method should resolve one failing test.

6. (M) Complete the method `exercises.xml.ElementRenderer.renderElementWithoutChildren(XmlElement)`
   - This method should return a `Stream<String>` containing just one String - the rendered `XmlElement` as something like `<foo name="value" />`.  The method is simple string concatenation with one difficulty: the element may or may not have `Attributes`.  Here's how we suggest handling this difficulty:
      - Create a private method `String renderAttributes(Attributes)` that returns a string composed of a single space concatenated with the results of calling the `AttributeRenderer` method from step #2 above.
      - Create another private method `String renderAttributes(XmlElement)` that returns the results of the above method if the `XmlElement` has attributes, else returns an empty string. This method should use a method reference to the method above (Hint: `Optional.map` and `Optional.orElse` are useful here)
   - Finishing these methods should resolve two failing tests.

7. (L) Complete the method `exercises.xml.ElementRenderer.renderElementWithChildren(XmlElement)`
   - This method should a `Stream<String>` with:
      - An XML open tag (may or may not have attributes)
      - The rendered child elements indented two spaces
      - An XML close tag
   - Making this method work will require several supporting methods.  We suggest the following supporting methods:
      - Create a method `Stream<String> renderOpen(XmlElement)` that returns a stream consisting of a single String - the rendered XML open tag.  This method is very similar to the `renderElementWithoutChildren` method with the difference that it does not return a closed tag
      - Create a method `Stream<String> renderClose(XmlElement)` that returns a stream consisting of a single String - the rendered XML close tag.  This is simple string concatenation.
      - Create a method `Stream<String> renderChild(VisitableElement element)` that renders an element. This method should call the `accept` method on the `element` and pass `this`.  This is essentially a recursive call into the same visitor.
      - Create a method `String indent(String s)` that returns the input String with two spaces appended at the beginning (simple string concatenation)
      - Create a method `Stream<String> renderChildren(XmlElement)` that renders each child element of the  `XmlElement` and indents the results. Hints: This method should have method references to the `renderChild` and `indent` methods created earlier.  Also remember that `Stream.flatMap` will turn a stream of streams into a flattened stream.
   - Finally, complete the `renderElementWithChidren` by `Stream<String>` that adds the Open tag, rendered children, and the close tag.  Hints: again, this is a place for `flatMap` and also remember that `Function.identity()` is a function that returns whatever is input into the function.
   - Finishing these methods should resolve two failing tests.

8. (M) Complete the method `exercises.xml.DocumentRenderer.render(Document)`
   - This method should return a string that holds an entire XML document including:
      - An XML Header (we have supplied a method to create this header)
      - A full DOCTYPE
      - The rendered rootElement
   - Create a method `String renderDocType(AbstractDocType)` that will call the `accept` method on the `AbstractDocType` and pass the visitor completed in steps #3 and #4 above.
   - Create a method `Stream<String> renderDocType(Document)` that returns a stream with a single String composed of
      - "<!DOCTYPE "
      - the root element name
      - the rendered doctype or empty string (use a method reference to the method created above)
      - ">"
   - Create a method `Stream<String> renderRootElement(Document)` that renders the root element by calling the `accept` method with visitor completed in steps #5-#7 above
   - Finally finish the `render(Document)` method by concatenating the XML header, DocType, and rendered root element and adding a newline character (`\n`) after each string.  This will be a Stream of streams, flattened, then collected.
   - Finishing these methods should resolve four failing tests.
