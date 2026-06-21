class Solution {
    public String minWindow(String s, String t) {
        if(s.length()< t.length()) return "";

        //what we need int the window
        Map<Character, Integer> need= new HashMap<>();

        for(char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) +1);
        }

        //what we have in the window
        Map<Character, Integer> window= new HashMap<>();

        int resStart=0;
        int start=0;
        int reslen=Integer.MAX_VALUE;
        int matched=0;

        for(int end=0; end<s.length(); end++){
            char c= s.charAt(end);
            window.put(c, window.getOrDefault(c, 0) +1);


            if(need.containsKey(c) && window.get(c).equals(need.get(c))) matched++;


            while(matched==need.size()){
                if(end-start + 1 <reslen){
                    reslen= end-start +1;
                    resStart=start;
                }

                // remove leftmost char from window
                char left= s.charAt(start);
                window.put(left, window.get(left)-1);

                // if removing it broke a match, update matched
                if(need.containsKey(left) && window.get(left) < need.get(left)){
                    matched--;
                }

                start++;
            }
        }

               return reslen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + reslen);

    }
}