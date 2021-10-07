package ru.dataart.academy.java;

public class TwoSums {
    /**
     * @param nums   - sorted in ascending order array of integer values >=0
     * @param target - integer value >= 0
     * @return - array of two numbers from nums which sum equals to target
     * Example: nums = [1, 4, 6, 7, 10], target = 10
     * Result - [4, 6]
     * Example: nums = [1, 4, 6, 7, 10], target = 2
     * Result - []
     */
    public int[] getTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        int middleIndex = getMiddleIndex(nums, target);
        for (int i = 0; i <= middleIndex; i++) {
            for (int j = middleIndex + 1; j < nums.length && nums[i] + nums[j] <= target; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }
        return new int[0];
    }

    //Метод как бы разделяет массив на 2 части, в первой части числа <= половине вводимой суммы, во второй >= половине вводимой суммы
    //Метод возвращает индекс, разделяющий эти части
    private int getMiddleIndex(int[] nums, int target) {
        int index = 0;
        while (index < nums.length && nums[index] < target / 2){
            index++;
        }
        return index;
    }
}
