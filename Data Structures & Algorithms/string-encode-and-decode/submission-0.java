class Solution {
    private static final char delimiter = 'Ω';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strs)
            sb.append(delimiter).append(str.length()).append(delimiter).append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            i++;

            int len = 0;
            while (str.charAt(i) != delimiter)
                len = len * 10 + str.charAt(i++) - '0';

            i++;

            StringBuilder sb = new StringBuilder("");
            while (len-- > 0)
                sb.append(str.charAt(i++));
            strs.add(sb.toString());
        }

        return strs;

    }
}
