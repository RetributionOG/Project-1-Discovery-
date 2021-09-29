package za.ac.nwu.ac.logic.flow.Impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModifyAccountTypeFlowImplTest {

    private ModifyAccountTypeFlowImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new ModifyAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }
}