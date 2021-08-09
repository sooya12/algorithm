class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 3단계
        while(new_id.indexOf("..") >= 0) {
            new_id = new_id.replace("..", ".");
        }
        // 4단계
        if(new_id.indexOf(".") == 0) {
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() > 0 && new_id.lastIndexOf(".") == new_id.length() - 1) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 5단계
        if(new_id.length() < 1 || "".equals(new_id) || " ".equals(new_id) || new_id == null) {
            new_id = "a";
        }
        // 6단계
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            
            if(new_id.length() > 0 && new_id.lastIndexOf(".") == new_id.length() - 1) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }   
        }
        // 7단계
        if(new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);
            
            while(new_id.length() < 3) {
                new_id += last;
            }
        }
        
        return new_id;
    }
}
