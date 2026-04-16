package org.example;

public final class StringUtils {

    private StringUtils() {
        // Evita instanciación
    }

    /*  Invierte un string utilizando un stack.
        Cada carácter del string se inserta en el stack y luego se extrae,
        aprovechando el orden LIFO para construir el string invertido.
        El método tiene complejidad O(n) en tiempo y espacio */

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


    /*  Verifica si una cadena de paréntesis está balanceada usando un stack.
        Cada paréntesis de apertura se inserta en el stack.
        Al encontrar un paréntesis de cierre, se valida que exista una apertura previa.
        Si en algún momento se intenta cerrar sin abrir, la cadena es inválida.
        Al final, la cadena es válida solo si el stack queda vacío. */

    public static boolean isBalancedParentheses(String value){

        Stack<Character> stack= new Stack<>();

        for(int i=0; i < value.length(); i++){
            if (value.charAt(i) =='(') {
                stack.push(value.charAt(i));
            }
            else if (value.charAt(i) ==')') {
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }


    /*  Ordena el stack en orden ascendente usando un stack auxiliar.
        La idea es mantener el stack auxiliar siempre ordenado.
        Se extraen elementos del stack original y se insertan en el auxiliar
        moviendo temporalmente los elementos mayores de vuelta al stack original.
        Al final, los elementos se devuelven al stack original, quedando ordenado
        con el menor valor en el top   */

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> stackAux = new Stack<>();
        while(!stack.isEmpty()){
            int current = stack.pop();
            while (!stackAux.isEmpty() && stackAux.peek() > current){
                stack.push(stackAux.pop());
            }
            stackAux.push(current);
        }

        // Devolver elementos al stack original
        while (!stackAux.isEmpty()){
            stack.push(stackAux.pop());
        }
    }
}
