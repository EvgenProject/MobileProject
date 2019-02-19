package utils.layers;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ServerManager {

    private static String OS;
    private static String ANDROID_HOME;

    public static String getAndroidHome(){
        if (ANDROID_HOME == null) ANDROID_HOME = System.getenv("ANDROID_HOME");//  ANDROID_HOME = System.getenv("ANDROID_HOME");
        //if (ANDROID_HOME == null)
        //    throw new RuntimeException("Failed to find ANDROID_HOME, make sure the environment variable is set");

        return ANDROID_HOME;
    }

    /**
     * Gets os.
     *
     * @return the os
     */
    public static String getOS() {
        if (OS == null) OS = System.getProperty("os.name");
        return OS;
    }

    /**
     * Is windows boolean.
     *
     * @return the boolean
     */
    public static boolean isWindows(){
        return getOS().startsWith("Windows");
    }

    /**
     * Run command string.
     *
     * @param command
     *         the command
     * @return the string
     */
    public static String runCommand(String command) {
        String output = null;
        try {
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("/home/evgen");
            if (scanner.hasNext()) output = scanner.next();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return output;
    }
}
