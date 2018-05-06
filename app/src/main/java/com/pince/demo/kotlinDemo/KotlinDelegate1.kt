package com.pince.demo.kotlinDemo

/**
 * 可以自己调用构造函数前提下，使用delegate替代继承的demo
 */

interface Base {
    fun printMessage()
    fun printMessageLine()
}
class BaseImpl(realObject: BaseDerived, val x: Int) : Base {
    var mRealObject: BaseDerived;
    init {
        mRealObject = realObject;
    }
    override fun printMessage() {
        mRealObject.printMessage();
        print(x)
    }
    override fun printMessageLine() { println(x) }
}

open class BaseDerived(var x:Int) {
    open fun printMessage() {
        print("BaseDerived " + x)
    }
    open fun printMessageLine() {
        print("BaseDerived " + x)
    }
}
class Derived(b: BaseImpl, x1: Int) : BaseDerived(x1),  Base by b {
    override fun printMessage() {
        print("abc")
    }
}
fun main(args: Array<String>) {
    var baseDerived = BaseDerived(11);
    val b = BaseImpl(baseDerived, 10)
    b.printMessage()
    b.printMessageLine()
}