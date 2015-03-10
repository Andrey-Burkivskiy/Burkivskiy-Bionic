package bionic.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrey on 23.02.15.
 */
public class FindSubString {
    public static String getSubString(String string, String regEx) {

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        String result = "";
        while(matcher.find()){
           result += matcher.group();
        }
        
        return result;
    }
}
