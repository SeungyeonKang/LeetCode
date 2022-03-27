class Solution {
    public int myAtoi(String str) {
        /*
        1. read character until the next character is non-digits or end of the string
        2. ignore white space
        3. check it's '-' or '+'
        4. check it's range (-2^31 <= result <= 2^31)
        
        0 <= s.length <= 200
        s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
        
        TC : O(n)
        SC : O(1)
        */
         int index = 0, sign = 1, total = 0;
 
        if(str.length() == 0) return 0;

        while(index < str.length() && str.charAt(index) == ' ')
            index ++;

        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
        
    }
}
