class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        String note = ransomNote;
        int p = 0;

        while (note.length() > 0 && p < magazine.length()) {
            note = note.replaceFirst(magazine.substring(p, p + 1), "");
            p++;
        }

        return note.length() == 0;
    }
}
