package pro.edu;

import java.util.Arrays;

public class Main {
    public static String getPrefix(String[] array){

        String prefix = null;
        boolean flag = true;

        int maxLength = Arrays.stream(array).mapToInt(String::length).min().orElse(0);
        for (int i = 0; i < maxLength ; i++) {
            prefix = array[0].substring(0,i+1);
            for (int j = 0; j < array.length; j++) {
                if (!array[j].substring(0, i +1).equals(prefix)){
                    flag = false;
                    break;
                }
            }
            if(flag == false)  {
                maxLength = i;
                break;
            }
        }
        return array[0].substring(0,maxLength);
    }
    public static String getPrefix2(String[] array){
        String prefix = "";
        boolean flag = true;
        int minLength = Arrays.stream(array).mapToInt(String::length).min().orElse(0);

        for (int i = 0; i <minLength ; i++) {
            char ch = array[0].charAt(i);
            for (int j = 0; j < array.length; j++) {
                if(array[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prefix += ch;
            }else break;;
        }

        return  prefix;
    }


    public static void main(String[] args) {
        System.out.println("----------  prefix --------");
        String[] ars = {"abcc", "abcd", "abcde", "abcdef"};

        System.out.println();
        System.out.println(getPrefix2(ars));

    }
}
