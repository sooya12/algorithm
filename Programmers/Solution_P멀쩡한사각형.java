import java.math.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long val1, val2;

        if(w <= h) {
            val1 = h;
            val2 = w;
        } else {
            val1 = w;
            val2 = h;
        }

        // 1차 함수
        // y = (val1/val2)*x
        // i번째 칸의 값(멀쩡한 사각형)
        for(int i = 0; i < val2; i++) {
            answer += val1 * i / val2;
        }

        return answer * 2;
    }
}

// BigInteger의 gcd(최대공약수) 이용
class Solution {
    public long solution(int w, int h) {
        long lw = w;
        long lh = h;
        long answer = lw * lh - (lw + lh - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue());

        return answer;
    }
}