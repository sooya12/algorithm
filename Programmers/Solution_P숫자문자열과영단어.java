class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < nums.length; i++) {
            String val = nums[i];
            
            if(s.indexOf(val) > -1) {
                s = s.replaceAll(val, String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }
}
