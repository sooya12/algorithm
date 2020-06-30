package Programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Solution_P베스트앨범 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 600, 150, 800, 2500 })));
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 600, 500, 800, 600 })));
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" }, new int[] { 500, 600, 501, 800, 900 })));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		HashMap<String, ArrayList<Song>> hm = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			if(!hm.containsKey(genres[i])) {
				hm.put(genres[i], new ArrayList<>());
			} 
			
			hm.get(genres[i]).add(new Song(i, plays[i]));
		}
		
		List<SongList> list = new ArrayList<>();
		
		Iterator it = hm.keySet().iterator();
		
		while(it.hasNext()) {
			ArrayList<Song> tmp = hm.get(it.next());
			Collections.sort(tmp);
			
			int totalPlay = 0;
			for (int i = 0; i < tmp.size(); i++) {
				totalPlay += tmp.get(i).play;
			}
			
			list.add(new SongList(tmp, totalPlay));
		}
		
		Collections.sort(list);
		
		ArrayList<Integer> ansList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Song> playList = list.get(i).playlist;
			
			for (int j = 0; j < playList.size() && j < 2; j++) {
				ansList.add(playList.get(j).idx);
			}
		}
		
		answer = new int[ansList.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = ansList.get(i);
		}
		
		return answer;
	}
	
	static class Song implements Comparable<Song>{
		int idx;
		int play;
		
		Song(int idx, int play){
			this.idx = idx;
			this.play = play;
		}

		@Override
		public int compareTo(Song o) {
			if(o.play > this.play) {
				return o.play - this.play;
			} else if(o.play == this.play) {
				return -(o.idx - this.idx);
			} else {
				return o.play - this.play;
			}
		}
		
		@Override
		public String toString() {
			return idx + " " + play;
		}
	}
	
	static class SongList implements Comparable<SongList>{
		ArrayList<Song> playlist;
		int totalPlay;
		
		SongList(ArrayList<Song> playlist, int totalPlay){
			this.playlist = playlist;
			this.totalPlay = totalPlay;
		}

		@Override
		public int compareTo(SongList o) {
			return o.totalPlay - this.totalPlay;
		}
		
		@Override
		public String toString() {
			return playlist + " " + totalPlay;
		}
	}
}
