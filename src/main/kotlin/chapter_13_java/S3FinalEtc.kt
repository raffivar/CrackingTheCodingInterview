package chapter_13_java

class S3FinalEtc {
    /**
     * S3 - Final,etc.
     * Q: What is the difference between final, finally, and finalize?
     * A:
     * final - keyword with the next meanings:
     * primitive - value cannot be changed
     * reference - the reference cannot be changed (can't point to another object)
     * method - cannot be overridden
     * class - cannot be subclassed
     *
     * finally - Runs at the end of a try/catch block
     * Will be executed even if we go back to the original thread from the try or catch blocks
     * Will only not-be-executed if the JVM exits before
     *
     * finalize() - A method that is automatically called by the garbage collector before actually destroying the object.
     * A class can override this method to define custom behavior during garbage collection
     *
     */
}