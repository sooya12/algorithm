import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        // 거리두기 결과
        int[] answer = new int[5];
        Arrays.fill(answer, 1);

        for (int p = 0; p < places.length; p++) {
            // 대기실구조 (5x5)
            char[][] map = new char[5][5];
            // 응시자들 위치
            ArrayList<Person> list = new ArrayList<>();

            for (int i = 0; i < places[p].length; i++) {
                for (int j = 0; j < places[p][i].length(); j++) {
                    map[i][j] = places[p][i].charAt(j);

                    // 응시자
                    if(map[i][j] == 'P') {
                        list.add(new Person(i, j));
                    }
                }
            }

            // 응시자 간 거리두기 확인
            x : for (int i = 0; i < list.size() - 1; i++) {
                Person p1 = list.get(i);

                for (int j = i + 1; j < list.size(); j++) {
                    Person p2 = list.get(j);

                    // 맨해튼 거리 2 이하로 앉은 경우
                    if(Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c) <= 2) {
                        Queue<Person> q = new LinkedList<>();
                        q.add(p1);
    
                        while(!q.isEmpty()) {
                            Person now = q.poll();

                            // 사이에 파티션이 없는 경우
                            if(now.r == p2.r && now.c == p2.c) {
                                answer[p] = 0;
                                break x;
                            }

                            if(now.r != p2.r) {
                                int r = now.r > p2.r ? now.r - 1 : now.r + 1;

                                if(map[r][now.c] != 'X') {
                                    q.add(new Person(r, now.c));
                                }
                            }

                            if(now.c != p2.c) {
                                int c = now.c > p2.c ? now.c - 1 : now.c + 1;

                                if(map[now.r][c] != 'X') {
                                    q.add(new Person(now.r, c));
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    // 응시자 위치 정보
    private class Person {
        int r;
        int c;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
