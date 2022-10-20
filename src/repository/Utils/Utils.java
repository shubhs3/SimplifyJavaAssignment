package repository.Utils;

public class Utils {
    public static String toCamelCase(String input){
        input = input.replaceFirst(String.valueOf(input.charAt(0)),String.valueOf(input.charAt(0)).toUpperCase());
        return input;
    }
}
