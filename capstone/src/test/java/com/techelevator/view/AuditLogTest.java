package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AuditLogTest {
    AuditLog testWriter = new AuditLog();
    Scanner scanner = new Scanner("./log.txt");

    @Before
    public void setUp() throws Exception {
        testWriter.writer("Hello", new BigDecimal("1"), new BigDecimal("311"));
    }

    @Test
    public void test() {
        assertEquals(true, scanner.hasNextLine());
        scanner.nextLine();
        assertEquals(false, scanner.hasNextLine());
    }
}
