package edu.fatec.ipp002.singleton.logger;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger
{
    private static Logger instance;
    private PrintWriter writer;

    private Logger()
    {
        try
        {
            writer = new PrintWriter(
                new OutputStreamWriter(
                    new FileOutputStream("log.txt", true),
                    "UTF-8"
                ),
                true
            );

            writer.println("\n");
            log("==== Application logger started ====");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Logger getInstance()
    {
        if (instance == null)
        {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message)
    {
        LocalDateTime dateTime = LocalDateTime.now();
        writer.println(dateTime + " | " + message);
        writer.flush();
    }
}
