class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        Map<Character, Integer> freqs = new HashMap<>();
        for (char ch : s1.toCharArray())
            freqs.merge(ch, 1, Math::addExact);
        
        int eles = freqs.size();

        int j = 0;
        while (j < s1.length()) {
            char ch = s2.charAt(j++);
            if (freqs.containsKey(ch)) {
                int count = freqs.merge(ch, -1, Math::addExact);
                if (count == 0)
                    eles--;
                else if (count == -1)
                    eles++;
            } 
        }

        if (eles == 0)
            return true;

        int i = 0;
        while (j < s2.length()) {
            char end = s2.charAt(j++), start = s2.charAt(i++);

            if (freqs.containsKey(end)) {
                int count = freqs.merge(end, -1, Math::addExact);
                if (count == 0)
                    eles--;
                else if (count == -1)
                    eles++;
            }

            if (freqs.containsKey(start)) {
                int count = freqs.merge(start, 1, Math::addExact);
                if (count == 0)
                    eles--;
                else if (count == 1)
                    eles++;
            }



            if (eles == 0)
                return true;
        }

        return false;
    }
}
