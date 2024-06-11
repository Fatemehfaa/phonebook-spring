package com.example.springphonebook;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validation {
    public boolean validateMobilNumber(String phoneNumber) {
        char[] array = phoneNumber.toCharArray();
        if (array.length == 11) {
            if (array[0] == '0' && array[1] == '9') {
                for (int start = 2; start < array.length; start++) {
                    if (!Character.isDigit(array[start]))
                        return false;
                }
                return true;
            }
        }
        return false;
    }


    public boolean validationNationalCode(String code) {
        //check length
        if (code.length() != 10)
            return false;

        char[] breakNationalCode = code.toCharArray();
        int length = breakNationalCode.length;
        int result = 0;
        int numberIndex = 0;
        for (int start = 0; start < length - 1; start++) {
            numberIndex = length - start;
            result += (Character.getNumericValue(breakNationalCode[start]) * numberIndex);
        }
        int numberTotal = result % 11;
        if (numberTotal > 2) {
            int number = 11 - numberTotal;
            return number == Character.getNumericValue(breakNationalCode[9]);
        } else return numberTotal == Character.getNumericValue(breakNationalCode[9]);
    }
}
