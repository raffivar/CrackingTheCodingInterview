package chapter_13_java

import Solution

class S4GenericsVSTemplates : Solution {
    override fun runTest() {
        /**
         * S4 - Generics vs. Templates
         * Q: Explain the difference between templates in C++ and generics in Java.
         * A:
         * Java: will perform "type erasure" and then use casting.
         * This also means all instances of MyClass, regardless of their type parameter,
         * are the same type. The type parameters are erased in runtime.
         * for example:
         *      Vector<String> vector = new Vector<String>()
         *      vector.add(new String("hello"))
         *      String str = vector.get(0)
         * at runtime, becomes:
         *      Vector vector = new Vector()
         *      vector.add(new String("hello"))
         *      String str = (String)vector.get(0)
         *
         * C++: will create a new template code for each type
         * This also means that instances with different type parameters are different types,
         * for example:
         * if we have MyClass<Foo> and MyClass<Bar>,
         * and there's a static variable in the constructor,
         * new MyClass<Foo>(10) //will equal 15
         * new MyClass<Foo>(15) //will equal 15
         * new MyClass<Bar>(20) //will equal 35
         * new MyClass<Bar>(35) //will equal 35
         *
         * This also means that in:
         * Java:
         *
         * C++:
         *
         * Java: cannot use primitives like "int" in generics
         * C++: can
         *
         * Java: can restrict the type to be a certain type
         * C++: cannot
         *
         * Java: the parameter cannot be instantiated
         * C++: can
         *
         * Java: the type parameter cannot be used tor static methods and variables,
         * since these would be shared between MyClass<Foo> and MyClass<Bar>
         * C++: can
         *
         */
    }
}