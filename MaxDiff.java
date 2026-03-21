class MaxDiff {
    public int maxDifference(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;

        int maxOdd = 0, minEven = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 != 0 && map[i] > 0)
                maxOdd = Math.max(map[i], maxOdd);
            else if(map[i] % 2 == 0 && map[i] > 0)
                minEven = Math.min(map[i], minEven);
        }

        return maxOdd - minEven;
    }
}