package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetExercises {

    private List<Integer> removeDuplicates(List<Integer> myList){
        return new ArrayList<>(new HashSet<>(myList));
    }

    public static boolean hasUniqueChars(String string){
        HashSet<Character> set= new HashSet<>();
        for (char c: string.toCharArray()){
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }
}
