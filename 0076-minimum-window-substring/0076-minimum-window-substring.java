class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        Map<Character, Integer> window = new HashMap<>();
        int resStart = 0, resLen = Integer.MAX_VALUE;
        int start = 0, matched = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c)))
                matched++;

            while (matched == need.size()) {
                // 1. save first
                if (end - start + 1 < resLen) {
                    resLen = end - start + 1;
                    resStart = start;
                }
                // 2. shrink
                char left = s.charAt(start);
                if (!need.containsKey(left) || window.get(left) > need.get(left)) {
                    window.put(left, window.get(left) - 1);
                    start++;
                } else {
                    break; // 3. stop
                }
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + resLen);
    }
}