package com.LingduoKong.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TerminalGamePanel gamePanel = new TerminalGamePanel(5, 5, 5);
        gamePanel.display();
        while (gamePanel.getAction()) {
            gamePanel.display();
        }
    }
}
