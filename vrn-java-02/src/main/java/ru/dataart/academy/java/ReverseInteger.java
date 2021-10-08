package ru.dataart.academy.java;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 12
     * -2,147,483,648 -> exception, error message
     */

    public int reverse(int inputNumber) throws RuntimeException {
        boolean negative = false;
        if (inputNumber < 0) {
            inputNumber = 0 - inputNumber;  //inputNumber = Math.abs(inputNumber);
            negative = true;
        }
        long outputNumber = 0;
        while (inputNumber > 0) {
            outputNumber = 10 * outputNumber + inputNumber % 10;
            inputNumber = inputNumber / 10;
        }
        if (negative) {
            outputNumber = 0 - outputNumber;
        }
        if (outputNumber < Integer.MIN_VALUE || outputNumber > Integer.MAX_VALUE) {
            throw new MyException();
        }
        return (int)outputNumber;
    }
}
