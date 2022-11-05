class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toCharArray();
        int a = 97;
        int z = 122;
        int A = 65;
        int Z = 90;
        
        for(char c : arr) {
            if(c == ' ') {
                answer.append(c);
                continue;
            }

            if(a <= c && c <= z) {
                int tmp = (c + n) == z ? (c + n) : (c + n) % z;

                if(tmp < a) {
                    tmp += a - 1;
                }

                answer.append((char)tmp);
            } else {
                int tmp = (c + n) == Z ? (c + n) : (c + n) % Z;

                if(tmp < A) {
                    tmp += A - 1;
                }

                answer.append((char)tmp);
            }
        }
        
        return answer.toString(); 
    }
}
