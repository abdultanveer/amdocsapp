package com.example.amdocsapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calculator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    public void testAdd() {
        int expected = 40;
        int actual = calculator.add(10,20);
        assertEquals(expected,actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}