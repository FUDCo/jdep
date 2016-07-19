package com.fudco.jdepexample.pack1;

import com.fudco.jdepexample.pack2.Bar;

public class Main {

    static void main(String args[]) {
        Foo foo = new Foo();
        args = foo.fiddleWithArgs(args);
        Bar bar = new Bar(args);
        bar.foolAroundSomeMore();
    }
}
