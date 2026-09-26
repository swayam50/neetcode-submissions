class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();

        int longestSubstring = 0;

        int i = 0, j = 0;
        while (j < s.length()) {
            if (characters.contains(s.charAt(j))) {
                if (j - i > longestSubstring)
                    longestSubstring = j - i;
                characters.remove(s.charAt(i++));
            } else
                characters.add(s.charAt(j++));
        }

        return Math.max(longestSubstring, j - i);
    }
}
