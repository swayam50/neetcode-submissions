class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            String key = findKey(str);
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(str);
        } 
        return List.copyOf(anagrams.values());
    }

    private String findKey(String str) {
        int[] freqs = new int[26];
        for (int i = 0; i < str.length(); i++)
            freqs[str.charAt(i) - 'a']++;

        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < 26; i++)
            if (freqs[i] != 0)
                builder.append((char)(i + 'a')).append(freqs[i]);
        return builder.toString();
    }
}
