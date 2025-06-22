package edu.fatec.ipp002.singleton;

import edu.fatec.ipp002.singleton.logger.Logger;

public class Main
{
    public static void main(String[] args)
    {
        Logger logger = Logger.getInstance();
        logger.log("Application started.");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Still the same logger instance!");
    }
}