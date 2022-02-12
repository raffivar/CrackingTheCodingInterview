package chapter_13_java
class S6ObjectReflection {
    /**
     * S6 - Object Reflection:
     * Q: Explain what object reflection is in Java and why it is useful.
     * A:
     * What is it?
     * Object reflection is a feature that provides a way to get reflective information about
     * classes and objects and perform operations, such as:
     * 1. Getting information about the methods and fields present inside the class at runtime
     * 2. Creating a new instance of a class
     * 3. Getting and setting the object fields directly by getting field references,
     * regardless of what the access modifier is
     *
     * When is it useful?
     * 1. Can help observe/manipulate the runtime behavior of an application
     * 2. Can help debug or test programs as we have direct access to methods, constructors, and fields
     * 3. We can call methods by name when we don't know the method in advance.
     * For example, we may let the user pass in:
     * - A class name
     * - Parameters for the constructor
     * - A method name
     * We can then use this information to create an object and call a method.
     * Doing these operations without reflection would require a complex series of if-statements,
     * if possible at all.
     *
     */
}