package com.LingduoKong.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    @org.junit.Test
    public void test() {
        GameControl gameControl = new GameControl();
        gameControl.start(1, 1, 1);
        gameControl.NextStep(0, 0, gameControl.TOUCH);
        Assert.assertEquals(false, gameControl.isWin());
        Assert.assertEquals(true, gameControl.isLose());
        Assert.assertArrayEquals(new String[][]{{gameControl.MINE}}, gameControl.getCurStatus());
    }

}
