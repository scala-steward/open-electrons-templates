# Code Style Guide

sbt compile publishLocal to publish the plugin

At open-electrons, we would like to follow the best practices code discipline with all our code bases. This guide here 
draws ideas from the experience of the engineers developing and maintaining the open-electrons projects, and from the experience 
of the broader open source community, we try to maintain high coding standards. Should you find any suggestions or even
improvements, please consider giving a pull request with your changes.

## <a name='TOC'>Table of Contents</a>

1. [Document History](#history)

2. [Scala Code Syntax](#syntax)
    * [Naming Convention](#naming)
    * [Variable Naming Convention](#variable-naming)
    * [Line Length](#linelength)
    * [Rule of 30](#rule_of_30)
    * [Spacing and Indentation](#indent)
    * [Blank Lines (Vertical Whitespace)](#blanklines)
    * [Parentheses](#parentheses)
    * [Curly Braces](#curly)
    * [Long Literals](#long_literal)
    * [Documentation Style](#doc)
    * [Imports](#imports)
    * [Pattern Matching](#pattern-matching)
    * [Infix Methods](#infix)
    * [Anonymous Methods](#anonymous)


## <a name='history'>Document History</a>
- 2022-30-12: Initial version.

## <a name='syntax'>Scala Code Syntax</a>

### <a name='naming'>Naming Convention</a>

We mostly follow Java's and Scala's standard naming conventions.

- Classes, traits, objects should follow Java class convention, i.e. PascalCase style.
  ```scala
  class MeasurementUnit

  trait ChargeDetailRecord
  ```

- Packages should follow Java package naming conventions, i.e. all-lowercase ASCII letters.
  ```scala
  package com.openelectrons.ocpp
  ```

- Methods/functions should be named in camelCase style.

- Global constants should be all uppercase letters (possibly defined in a companion object).
  ```scala
  object AppConfig {
    val DEFAULT_APP_PORT = 9000
  }
  ```

- Enumerations should be defined in a sealed trait with a companion object containing the implementations. For example:
  ```scala
    sealed trait MeasurementUnit { def name: String }
    object MeasurementUnit {
      case object Watt extends MeasurementUnit { val name: String = "W" }
      case object KiloWatt extends MeasurementUnit { val name: String = "KW" }
     }
  ```

### <a name='variable-naming'>Variable Naming Convention</a>

- Variables should be named in camelCase style, and should have self-evident names.
  ```scala
  val serverPort = 9000
  val clientPort = 9001
  ```

### <a name='linelength'>Line Length</a>

- Limit lines to 100 characters.
- The only exceptions are import statements and URLs (although even for those, try to keep them under 100 chars).


### <a name='rule_of_30'>Rule of 30</a>

We tend to stick to the following rough guidelines:

- A method should contain less than 30 lines of code.
- A class should contain less than 30 methods.
- A package should not contain more than 30 classes, thus comprising up to 27,000 LoC


### <a name='indent'>Spacing and Indentation</a>

- Put one space before and after operators, including the assignment operator.
  ```scala
  def plus(int1: Int, int2: Int): Int = int1 + int2
  ```

- Put one space after commas.
  ```scala
  Seq("a", "b", "c") // this is pleasing to the eye

  Seq("a","b","c")   // this looks clumsy and crowded, do not do this!
  ```

- Put one space after colons.
  ```scala
  // do this
  def getConf(key: String, defaultValue: String): String = {
    // some code
  }

  // don't put spaces before colons
  def calculateHeaderPortionInBytes(count: Int) : Int = {
    // some code
  }

  // don't omit spaces after colons
  def multiply(int1:Int, int2:Int): Int = int1 * int2
  ```

- Each level of indentation is 2 spaces. Tabs should not be used!
  ```scala
  // wrong!
  class Foo {
      def fourspaces = {
          val x = 4
          ......
      }
  }
  
  // right!
  class Foo {
    def twospaces = {
      val x = 2
      ..
    }
  }
  ```

- For method declarations, use 2 space indentation for their parameters and put each in each line when the parameters 
don't fit in two lines. Return types can be either on the same line as the last parameter, or start a new line 
with 2 space indent.

  ```scala
  def users[M <: Monad](
    database: Database,
    filter: UserFilter): M[List[User]] = {
    // method body
  }
  ```

- For classes whose header doesn't fit in two lines, use 2 space indentation for its parameters, put each in each line, 
put the extends on the next line with 2 space indent, and add a blank line after class header.

  ```scala
  final case class Foo(
    param1: String,  // 2 space indent for parameters
    param2: String,
    param3: Array[Byte])
    extends FooInterface  // 2 space indent here
    with Logging {

    def firstMethod(): Unit = { ... }  // blank line above
  }
  ```

- For method and class constructor invocations, use 2 space indentation for its parameters and put each in each 
line when the parameters don't fit in two lines.

  ```scala
  foo(
    someVeryLongFieldName,  // 2 space indent here
    andAnotherVeryLongFieldName,
    "this is a string",
    3.1415)

  new Bar(
    someVeryLongFieldName,  // 2 space indent here
    andAnotherVeryLongFieldName,
    "this is a string",
    3.1415)
  ```

- Do NOT use vertical alignment. Though they might look neatly done, they are less maintainable 
change in the future.
  ```scala
  // Don't align vertically
  val plus     = "+"
  val minus    = "-"
  val multiply = "*"

  // Do the following
  val plus = "+"
  val minus = "-"
  val multiply = "*"
  ```


### <a name='blanklines'>Blank Lines (Vertical Whitespace)</a>

- A single blank line appears:
  - Between consecutive members (or initializers) of a class: fields, constructors, methods, nested classes, static 
  initializers, instance initializers.
    - Exception: A blank line between two consecutive fields (having no other code between them) is optional. Such blank lines 
    are used as needed to create logical groupings of fields.
  - Within method bodies, as needed to create logical groupings of statements.
  - Optionally before the first member or after the last member of the class (neither encouraged nor discouraged).
- Use one or two blank line(s) to separate class or object definitions.
- Excessive number of blank lines is discouraged.


### <a name='parentheses'>Parentheses</a>

- Methods should be declared with parentheses, unless they are accessors that have no 
side-effect (state mutation, I/O operations, throwing exceptions are considered side-effects).
  ```scala
  class Job {
    // Wrong: killJob changes state. Should have ().
    def killJob: Unit

    // Correct:
    def killJob(): Unit
  }
  ```
- Call site should follow method declaration, i.e. if a method is declared with parentheses, call with parentheses.
  Note that this is not just syntactic. It can affect correctness when `apply` is defined in the return object.
  ```scala
  class Foo {
    def apply(args: String*): Int
  }

  class Bar {
    def foo: Foo
  }

  new Bar().foo  // This returns a Foo
  new Bar().foo()  // This returns an Int!
  ```


### <a name='curly'>Curly Braces</a>

- Put curly braces even around one-line conditional or loop statements. The only exception is if you are using if/else as 
an one-line ternary operator that is also side-effect free.
  ```scala
  // Correct:
  if (true) {
    println("Wow!")
  }

  // Correct:
  if (true) statement1 else statement2

  // Correct:
  try {
    foo()
  } catch {
    ...
  }

  // Wrong:
  if (true)
    println("Wow!")

  // Wrong:
  try foo() catch {
    ...
  }
  ```


### <a name='long_literal'>Long Literals</a>

- Suffix long literal values with uppercase `L`. It is often hard to differentiate lowercase `l` from `1`.
  ```scala
  val longValue = 5432L  // Do this

  val longValue = 5432l  // Do NOT do this
  ```


### <a name='doc'>Documentation Style</a>

- Use Java docs style instead of Scala docs style.
  ```scala
  /** This is a correct one-liner, short description. */

  /**
   * This is correct multi-line JavaDoc comment. And
   * this is my second line, and if I keep typing, this would be
   * my third line.
   */

  /** This Scala doc style looks not so ordered, so please do not use this
    * documenting your code and comments.
    */
  ```


### <a name='imports'>Imports</a>

- __Avoid using wildcard imports__, unless you are importing more than 6 entities, or implicit methods. Wildcard imports make the code less robust to external changes.
- Always import packages using absolute paths (e.g. `scala.util.Random`) instead of relative ones (e.g. `util.Random`).
- In addition, sort imports in the following order:
  * `java.*` and `javax.*`
  * `scala.*`
  * Third-party libraries (`org.*`, `com.*`, etc)
  * Project classes (`com.databricks.*` or `org.apache.spark` if you are working on Spark)
- Within each group, imports should be sorted in alphabetic ordering.
- You can use IntelliJ's import organizer to handle this automatically, using the following config:

  ```
  java
  javax
  _______ blank line _______
  scala
  _______ blank line _______
  all other imports
  _______ blank line _______
  com.databricks  // or org.apache.spark if you are working on Spark
  ```


### <a name='pattern-matching'>Pattern Matching</a>

- For methods whose entire body is a pattern match expression, put the match on the same line as the method declaration 
if possible to reduce one level of indentation.
  ```scala
  def test(msg: Message): Unit = msg match {
    case x => ....
    case y => ....
  }
  ```

- When calling a function with a closure (or partial function), if there is only one case, put the case on the same 
line as the function invocation.
  ```scala
  list.zipWithIndex.map { case (elem, i) =>
    // ...
  }
  ```
  If there are multiple cases, indent and wrap them.
  ```scala
  list.map {
    case a: Foo =>  ...
    case b: Bar =>  ...
  }
  ```

- If the only goal is to match on the type of the object, do NOT expand fully all the arguments, as it makes refactoring 
more difficult and the code more error prone.
  ```scala
  case class Pokemon(name: String, weight: Int, hp: Int, attack: Int, defense: Int)
  case class Human(name: String, hp: Int)
  
  // Do NOT do the following, because
  // 1. When a new field is added to Pokemon, we need to change this pattern matching as well
  // 2. It is easy to mismatch the arguments, especially for the ones that have the same data types
  targets.foreach {
    case target @ Pokemon(_, _, hp, _, defense) =>
      val loss = sys.min(0, myAttack - defense)
      target.copy(hp = hp - loss)
    case target @ Human(_, hp) =>
      target.copy(hp = hp - myAttack)
  }
  
  // Do this:
  targets.foreach {
    case target: Pokemon =>
      val loss = sys.min(0, myAttack - target.defense)
      target.copy(hp = target.hp - loss)
    case target: Human =>
      target.copy(hp = target.hp - myAttack)
  }
  ```


### <a name='infix'>Infix Methods</a>

__Avoid infix notation__ for methods that aren't symbolic methods (i.e. operator overloading).
  ```scala
  // Correct
  list.map(func)
  string.contains("foo")

  // Wrong
  list map (func)
  string contains "foo"

  // But overloaded operators should be invoked in infix style
  arrayBuffer += elem
  ```


### <a name='anonymous'>Anonymous Methods</a>

__Avoid excessive parentheses and curly braces__ for anonymous methods.
  ```scala
  // Correct
  list.map { item =>
    ...
  }

  // Correct
  list.map(item => ...)

  // Wrong
  list.map(item => {
    ...
  })

  // Wrong
  list.map { item => {
    ...
  }}

  // Wrong
  list.map({ item => ... })
  ```
