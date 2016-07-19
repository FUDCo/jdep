package com.fudco.jdepexample.pack2;

public class Bar {

    private String myArgs[];

    public Bar(String args[]) {
        myArgs = args;
    }

    public void foolAroundSomeMore() {
        System.out.print("hehe, you said \"");
        for (int i = 0; i < myArgs.length; ++i) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(myArgs[i]);
        }
        System.out.println("\" (but not in that order)");
    }
}
