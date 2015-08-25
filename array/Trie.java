import java.util.HashMap;

public class Trie {
	class TrieNode {
	    // Initialize your data structure here.
	    
	    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	    char c;
	    boolean leaf;
	    
	    public TrieNode() {
	        
	    }
	    
	    public TrieNode(char c) {
	        this.c = c;
	    }
	}
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                children.put(c, new TrieNode(c));
            }
            TrieNode t = children.get(c);
            if (i == word.length() - 1) {
                t.leaf = true;
            }
            children = t.children;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchTrie(word);
        return t != null && t.leaf == true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchTrie(prefix) != null;
    }
    
    public TrieNode searchTrie(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                return null;
            }
            t = children.get(c);
            children = t.children;
        }
        
        return t;
    }
}
