class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> c2p = new HashMap<>();
        int maxLength = 0;
        int curLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c2p.containsKey(c) && c2p.get(c) >= start) {
                if (maxLength < curLength) {
                    maxLength = curLength;
                }
                start = c2p.get(c) + 1;
                curLength = i - c2p.get(c);
                c2p.put(c, i);
            } else {
                c2p.put(c, i);
                curLength++;
            }
        } 

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
