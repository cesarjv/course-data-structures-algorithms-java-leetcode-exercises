package org.example;

import java.util.*;

public class HashTable {

    private Entry[] table;

    private static class Entry {
        String key;
        int value;
        Entry next;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public HashTable() {
        int size = 7;
        table=new Entry[size];
    }
    private int hash(String key){
        return Math.abs(key.hashCode()) % table.length;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Entry newEntry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
            return;
        }
        Entry temp = table[index];
        while (temp != null) {
            // Si la clave ya existe, actualizar
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            // Si es el último nodo, salir
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // Insertar al final
        temp.next = newEntry;
    }


    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + ": ");
            Entry temp = table[i];
            if (temp == null) {
                System.out.println("null");
                continue;
            }
            while (temp != null) {
                System.out.print("[" + temp.key + " = " + temp.value + "]");
                if (temp.next != null) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
        }
    }


    public Integer get(String key) {
        int index = hash(key);
        Entry temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0; // clave no encontrada
    }

    private boolean itemInCommon(int[] array1, int[] array2){

        HashMap<Integer,Boolean> hashMap=new HashMap<>();

        for (int j : array1) {
            hashMap.put(j, true);
        }

        for (int j : array2) {
            if (hashMap.containsKey(j)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Integer> findDuplicates(int[] array) {
        HashMap<Integer,Integer> values=new HashMap<>();
        ArrayList<Integer> duplicatesValues= new ArrayList<>();
        for(int x:array){
            if(values.containsKey(x)){
                values.put(x,values.get(x)+1);
            }
            else{
                values.put(x,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: values.entrySet()){
            int num=entry.getKey();
            int counter= entry.getValue();
            if(counter > 1){
                duplicatesValues.add(num);
            }
        }
        return duplicatesValues;
    }

    private Character firstNonRepeatingChar(String word){

        HashMap<Character,Integer> values=new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            char c=word.charAt(i);
            if(values.containsKey(c)){
                values.put(c,values.get(c)+1);
            }
            else{
                values.put(c,1);
            }
        }

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(values.get(c) == 1){
                return c;
            }
        }
        return null;
    }

    private List<List<String>> groupAnagrams(String[] strings){
        HashMap <String, List<String>> map=new HashMap<>();

        for (String word : strings) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // Crear la lista solo si no existe
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Agregar la palabra al grupo correcto
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }


    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(num, i);
            i++;
        }
        return new int[]{}; // ✅ arreglo vacío si no hay solución
    }

    private int[] subarraySum(int[] nums, int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        int currentSum=0;
        // 👇 MUY IMPORTANTE
        map.put(0, -1);
        for(int i=0; i < nums.length;i++){
            currentSum=currentSum + nums[i];
            if(map.containsKey(currentSum-target)){
                var start=map.get(currentSum-target)+1;
                return new int[]{start,i};
            }
            map.put(currentSum,i);
        }
        return new int[]{};
    }
}
