package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    private final String digits = "0123456789";

    public int getCountOfDigits(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Integer> foundNumbers = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (digits.contains(Character.toString(s.charAt(i)))) {
                foundNumbers.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        return foundNumbers.size();
    }
}
