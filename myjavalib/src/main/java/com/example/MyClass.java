package com.example;

import java.util.Random;

public class MyClass {

    private final static String jokes []={"Compaq is considering changing the command 'Press any key' to 'Press Enter key' because of the flood of calls asking where is the 'Any' key.",
            "AST technical support had a called complaining that her mouse was hard to control with the dust cover on. The cover turned out to be the plastic bag the mouse was packed in !",
    "Wife - Have you brought the saree.\n" +
            "Husband - Bad command or file name.\n" +
            "Wife - But I told you about it in morning.\n" +
            "Husband - Erroneous syntax, abort, retry, cancel.","Wife - What is my value in your life?\n" +
            "Husband - Unknown virus detected.","Failure is not an option. It comes bundled with your Microsoft product.",
            "","My software never has bugs. It just develops random features.",
            "The beginning of the programmer’s wisdom is understanding the difference between getting program to run and having a runnable program.",
            "The Internet: where men are men, women are men, and children are FBI agents.",
            "Some things Man was never meant to know. For everything else, there’s Google."
    };
    public static String getJokes(){
        int index = new Random().nextInt(jokes.length);
        return jokes[index];
    }

}
