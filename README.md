# easyprint

This documentation is provisional, and should be replaced by Javadoc.

## EasyPrint

`java.lang.String` concatenation in Java is slow and bad practice, due to `String` immutability. Don't get me wrong: I dig immutability, but it's not for all tasks.

`java.lang.StringBuilder` looks too low-level and, for some tasks, too verbose -- like almost everything Java.

This package contains a wrapper for `StringBuilder` as easy, or easier, to use than `String` concatenation, with some batteries.

### Methods

```java
public EasyString(String string)
```
Creates a `EasyString` from a `String`.

```java
public EasyString(StringBuilder builder)
```
Creates a `EasyString` from a `StringBuilder`.

```java
public EasyString(Object... args)
```
Creates a `EasyString` from `Object[]` or `Object` [varargs](https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html).

```java
public EasyString append(Object... args)
```
Appends `Object[]` or `Object` varargs to an `EasyString` instance. Returns `this`, so can be chained.

Not recommended for appending constant values; use `EasyString()` instead.

```java
public static EasyString concat(String separator, Object... args)
```
Inspired by Lua's `table.concat()`. Interpolates each elements of args (`Object[]` or `Object` varargs) with `separator`.

Not recommended for `""` separator; use `EasyString()` instead.

```java
public static void print(Object... args)
```
Wrapper for `System.out.print(new EasyString(Object... args))`.

```java
public static void println(Object... args)
```
Wrapper for `System.out.println(new EasyString(Object... args))`.

```java
public static void repeat(String string, int times)
```
Repeats `string` `times` times. For example, `repeat("*", 5)` returns `*****`.

```java
public String toString()
```
Overwritten for returning `String` built.

## TODO

- [X] Tests
- [ ] More tests
- [ ] File writing, similarly to `print()` and `println()`
- [ ] StringBuffer wrapper
- [ ] Implementing useful interfaces
- [ ] Javadoc
- [ ] Benchmark against other alternatives