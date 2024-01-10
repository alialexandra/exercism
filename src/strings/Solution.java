package strings;


import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LogLevels {

    public static String message(String logLine) {
        return logLine.substring(logLine.lastIndexOf(":") + 1).trim();
    }

    public static String logLevel(String logLine) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(logLine);

        if (matcher.find()) {
            return matcher.group(1).toLowerCase(); // This returns the text inside the brackets
        }
        return null;
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}


public class Solution {

    public static void main(String[] args) {
        LogLevels logLevels = new LogLevels();

        System.out.println(LogLevels.reformat("[WARNING]:  Disk almost full\r\n"));
    }

}