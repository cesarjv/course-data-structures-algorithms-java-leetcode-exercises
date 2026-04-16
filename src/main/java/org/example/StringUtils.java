package org.example;

public final class StringUtils {

    private StringUtils() {
        // Evita instanciación
    }

    public static String reverseString(String value){

        Stack<Character> stack= new Stack<>();

        for(int i=0; i < value.length(); i++){
            stack.push(value.charAt(i));
        }
        StringBuilder reversed=new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
