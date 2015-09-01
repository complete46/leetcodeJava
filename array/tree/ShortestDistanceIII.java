package tree;

public class ShortestDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int i = -1;
		int j = -1;
		int min = Integer.MAX_VALUE;

		for (int k = 0; k < words.length; k++) {
			if (words[k].equals(word1)) {
				if (word1.equals(word2)) {
					if (i != -1 && k - i < min) {
						min = k - i;
					}
					i = k;
				} else {
					i = k;
					if (j != -1 && i - j < min) {
						min = i - j;
					}
				}
			} else if (words[k].equals(word2)) {
				j = k;
				if (i != -1 && j - i < min) {
					min = j - i;
				}
			}
		}

		return min;
	}
}
