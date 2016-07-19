package com.fudco.jdepexample.pack1;

class Foo {

    Foo() {
    }

    String[] fiddleWithArgs(String args[]) {
        String result[] = new String[args.length];
        for (int i = 0; i < args.length; ++i) {
            result[args.length - i - 1] = args[i];
        }
        return result;
    }
}
