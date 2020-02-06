import java.util.Arrays;

public class Runner {


    public static void main(String[] args) {
        System.out.println(icyHot(120, -1));
        System.out.println(icyHot(-1, 120));
        System.out.println(icyHot(2, 120));
        System.out.println(conCat("abc", "cat"));
        System.out.println(conCat("dog", "cat"));
        System.out.println(conCat("abc", ""));
        int[] x = {1, 2, 3};
        int[] y = {1, 2};
        int[] z = {1};
        int[] num1 = {1,4,1,4};
        int[] num2 = {1,4,2,4};
        int[] num3 = {1,1};
        int[] num4 = {5,4,9,4,9,5};
        int[] num5 = {1,4,1,5};
        int[] num6 = {1,4,1,5,5,4,1};
        System.out.println(Arrays.toString(frontPiece(x)));
        System.out.println(Arrays.toString(frontPiece(y)));
        System.out.println(Arrays.toString(frontPiece(z)));
        System.out.println(squirrelPlay(70, false));
        System.out.println(squirrelPlay(95, false));
        System.out.println(squirrelPlay(95, true));
        System.out.println(countXX("abcxx"));
        System.out.println(countXX("xxx"));
        System.out.println(countXX("xxxx"));
        System.out.println(noTeenSum(1,2,3));
        System.out.println(noTeenSum(2,13,1));
        System.out.println(noTeenSum(2,1,14));
        System.out.println(catDog("1cat1cadodog"));
        System.out.println(catDog("catcat"));
        System.out.println(countTriple("abcXXXabc"));
        System.out.println(countTriple("xxxabyyyycd"));
        System.out.println(countTriple("a"));
        System.out.println(only14(num1));
        System.out.println(only14(num2));
        System.out.println(only14(num3));
        System.out.println(fix45(num4));
        System.out.println(fix45(num5));
        System.out.println(fix45(num6));








    }

    // Warm up icyHot if one is less than zero and other is more than 100 then true.
    public static boolean icyHot(int temp1, int temp2) {
        if (temp1 < 0 && temp2 > 100 || temp1 > 100 && temp2 < 0) {
            return true;
        }
        return false;
    }

    // combine both strings together.
    public static String conCat(String first, String second) {

        if (first.substring(2, 3).equals((second.substring(0, 0)))) {
            first = first.substring(0, 1) + second;
            return first;
        }
        if (first.substring(2) != second.substring(0)) {
            first = first + second;
        }

        return first;
    }

    // frontPiece if length== more than 2 then return first two ints, if smaller then return all
    public static int[] frontPiece(int[] nums) {
        if (nums.length >= 2) {
            int[] ans = {nums[0], nums[1]};
            return ans;
        } else return nums;


    }

    // squirrelPlay if summer then they play from 60-100 if not summer then from 60-90
    public static boolean squirrelPlay(int temp, boolean isSummer) {
        if (isSummer == true && temp >= 60 && temp <= 100) {
            return true;
        }
        if (isSummer != true && temp >= 60 && temp <= 90) {
            return true;
        } else return false;
    }

    // warmup-2  countXX
    public static int countXX(String str) {
        int count = 0;
        String y = "xx";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals(y)) {
                count++;
            }
        }
        return count;
    }

    //logic2 noTeen Sum
    public static int fixTeen(int n) {
        if (n >= 13 && n <= 19 && n != 15 && n != 16) {

            return 0;
        } else return n;
    }

    public static int noTeenSum(int a, int b, int c) {
        int sum = fixTeen(a) + fixTeen(b) + fixTeen(c);
        return sum;
    }

    //string 2 catDog
    public static boolean catDog(String str) {
        int cat = 0;
        int dog = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat"))
                cat++;
            if (str.substring(i, i + 3).equals("dog"))
                dog++;
        }
        if (cat == dog)
            return true;
        else return false;
    }

    //string3 countTriple
    public static int countTriple(String letters) {
        int triple = 0;

        for (int i = 0; i < letters.length(); i++) {
            if (letters.length() > i + 2) {
                if (letters.charAt(i) == letters.charAt(i + 1) &&
                        letters.charAt(i) == letters.charAt(i + 2))
                    triple++;
            }
        }
        return triple;
    }

    // array 2 only14
    public static boolean only14(int[] nums) {
        boolean answer = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 4 && nums[i] != 1) {
                answer = false;
            }
        }
        return answer;
    }
    // array 3
    public static int[] fix45(int[] nums) {
        int[] result = nums;
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 4 && i != result.length) {
                int index = five(result);

                if(index != -1) {
                    int temp = result[i + 1];
                    result[i + 1] = result[index];
                    result[index] = temp;
                }
            }
        }

        return result;
    }

    public static int five(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if((i == 0 && nums[i] == 5) || (nums[i] == 5 && nums[i - 1] != 4)) {
                return i;
            }
        }

        return -1;
    }


}