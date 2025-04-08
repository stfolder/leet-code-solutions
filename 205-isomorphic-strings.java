class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> replaceMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!replaceMap.containsKey(s.charAt(i)) && !replaceMap.containsValue(t.charAt(i))) {
                replaceMap.put(s.charAt(i),  t.charAt(i));
            }
            if (!replaceMap.containsKey(s.charAt(i)) || t.charAt(i) != replaceMap.get(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
