package org.theledgerco;

import junit.framework.TestCase;

import java.io.IOException;

public class MainTest extends TestCase {

    public void testMain() throws IOException {
        Main.main(new String[]{"C:\\Users\\Jitender\\IdeaProjects\\Ledger\\src\\test\\resources\\TestInput1.txt"});
    }
}