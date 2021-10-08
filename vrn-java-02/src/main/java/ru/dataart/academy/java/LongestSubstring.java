package ru.dataart.academy.java;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    /**
     * @param checkString - input string to check
     * @return - length of max substring without repeatable characters
     * Example: dnmdncbb  -> 5 (mdncb)
     * amam -> 2 (am)
     */

    public int getLengthOfLongestSubstring(String checkString) {
        int maxLength = 0;
        List<Character> currSubstring= new ArrayList<>();
        char[] charArray = checkString.toCharArray();
        int length = charArray.length;
        boolean needToStop;

        for (int i = 0; i < length; i++) {
            currSubstring.clear();
            currSubstring.add(charArray[i]);
            needToStop = false;
            for (int j = i + 1; j < length && !needToStop; j++) {
                for (Character currChar : currSubstring) {
                    if (charArray[j] == currChar) {
                        needToStop = true;
                        break;
                    }
                }
                if (!needToStop) {
                    currSubstring.add(charArray[j]);
                }
            }
            if (currSubstring.size() == length) {
                return length;
            }
            maxLength = currSubstring.size() > maxLength ? currSubstring.size() : maxLength;
            //Если использовать встроенную функцию:  maxLength = Math.max(currSubstring.size(), maxLength);
        }
        return maxLength;
    }


    //Вариант без использования коллекций (списка)
/*    public int getLengthOfLongestSubstring(String checkString) {
        int maxLength = 0;
        int currLength = 0;
        char[] charArray = checkString.toCharArray();
        int length = charArray.length;
        char[] currSubstring = new char[length];
        boolean needToStop;

        for (int i = 0; i < length; i++) {
            currSubstring = new char[length];
            currSubstring[0] = charArray[i];
            currLength = 1;
            needToStop = false;
            for (int j = i + 1; j < length && !needToStop; j++) {
                for (char currChar : currSubstring) {
                    if (charArray[j] == currChar) {
                        needToStop = true;
                        break;
                    }
                }
                if (!needToStop) {
                    currSubstring[j - i] = charArray[j];
                    currLength++;
                }
            }
            if (currLength == length) {
                return length;
            }
            maxLength = currLength > maxLength ? currLength : maxLength;
        }
        return maxLength;
    }
    */
}
