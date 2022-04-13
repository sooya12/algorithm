class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0; // 가능한 스킬트리 개수
        int pre; // 앞 스킬 위치
        String s, tmp; // 스킬목록, 현재스킬
        boolean[] check; // 스킬 사용 여부

        for (int i = 0; i < skill_trees.length; i++) {
            s = skill_trees[i];
            pre = -1;
            check = new boolean[skill.length()];

            for (int j = 0; j < skill.length(); j++) {
                tmp = skill.substring(j, j + 1);

                // 스킬 사용
                if(s.contains(tmp)) {
                    // 앞 스킬 사용 안 함 or 뒷 스킬 먼저 사용함 or 중간 스킬 사용 안 함
                    if((j > 0 && pre < 0) || pre > s.indexOf(tmp) || (j > 0 && !check[j - 1])) {
                        break;
                    }

                    check[j] = true;
                    pre = s.indexOf(tmp);
                }

                // 스킬을 순서대로 사용한 경우
                if(j == skill.length() - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
