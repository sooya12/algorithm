class Solution {
    boolean solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.toLowerCase());
        
        int cnt = 0; 
        
        while(sb.indexOf("p") >= 0 || sb.indexOf("y") >= 0) {
            if(sb.indexOf("p") >= 0) {
                cnt++;
                sb.setCharAt(sb.indexOf("p"), '_');
            } else if(sb.indexOf("y") >= 0) {
                cnt--;
                sb.setCharAt(sb.indexOf("y"), '_');
            }
        }

        return (cnt == 0) ? true : false;
    }
}
