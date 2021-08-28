class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length() % 2 == 0) { // 글자 길이가 짝수인 경우, 가운데 두 글자 가져오기
            answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else { // 글자 길이가 홀수인 경우, 가운데 글자 가져오기
            answer += s.charAt(s.length() / 2);
        }
        
        return answer;
    }
}
