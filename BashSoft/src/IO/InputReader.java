package IO;

import StaticData.SessionData;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by mponev on 30.05.16.
 */
public class InputReader {
    private static final String END_COMMAND = "quit";
    private CommandInterpreter interpreter;
    public InputReader(CommandInterpreter interpreter) {
        this.interpreter = interpreter;
    }
    public void readCommands() throws IOException{
        Scanner sc = new Scanner(System.in);
        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
        String input = sc.nextLine().trim();
        while (!input.equals(END_COMMAND)) {
            this.interpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
            input = sc.nextLine().trim();
        }
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            if (!thread.getName().equals("main") && !thread.isDaemon()) {
                try {
                    thread.join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
