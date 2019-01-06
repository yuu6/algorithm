package com.yuu6.algorithms.letterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()>=1){
            List<Character> chars = new ArrayList<Character>();
            aletter(digits,digits.length()-1,chars);
            System.out.println(res);
            return res;
        }else{
            return new ArrayList<>();
        }


    }
    private void aletter(String digits,int index,List<Character> chars){
        if(index<0){
//            System.out.println(chars);
            res.add(mytToString(chars));
            return;
        }else{
            for(String i :zhuanhuan(digits.charAt(index))){
                chars.add(i.charAt(0));
                aletter(digits,--index,chars);
                chars.remove(chars.size()-1);
                index++;
            }
        }

    }
    private String mytToString(List<Character> chars){
        String res = "";
        for(int i=chars.size()-1;i>=0;i--){
            res += chars.get(i);
        }
        return res;
    }
    private List<String> zhuanhuan(char a){
        List res = new ArrayList();
        switch(a){
            case '2':
                res = Arrays.asList("a","b","c");
                break;
            case '3':
                res = Arrays.asList("d","e","f");
                break;
            case '4':
                res = Arrays.asList("g","h","i");
                break;
            case '5':
                res = Arrays.asList("j","k","l");
                break;
            case '6':
                res = Arrays.asList("m","n","o");
                break;
            case '7':
                res = Arrays.asList("p","q","r","s");
                break;
            case '8':
                res = Arrays.asList("t","u","v");
                break;
            case '9':
                res = Arrays.asList("w","x","y","z");
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("2");
    }
}