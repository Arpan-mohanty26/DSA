import java.util.*;

// Trie Node class
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

// Trie class
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    // Search a word in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    // Delete a word from the trie
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord;
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }

    // Search contacts by prefix
    public List<String> searchByPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return results;
            }
        }
        findAllWords(node, new StringBuilder(prefix), results);
        return results;
    }

    private void findAllWords(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix.toString());
        }
        for (char ch : node.children.keySet()) {
            prefix.append(ch);
            findAllWords(node.children.get(ch), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}

// Contact Management System class
class ContactManagementSystem {
    private Trie contactsTrie;

    public ContactManagementSystem() {
        contactsTrie = new Trie();
    }

    // Add a contact
    public void addContact(String contact) {
        contactsTrie.insert(contact.toLowerCase());
    }

    // Search contacts by prefix
    public List<String> searchContacts(String prefix) {
        return contactsTrie.searchByPrefix(prefix.toLowerCase());
    }

    // Delete a contact
    public void deleteContact(String contact) {
        contactsTrie.delete(contact.toLowerCase());
    }

    // Main method
    public static void main(String[] args) {
        ContactManagementSystem cms = new ContactManagementSystem();

        cms.addContact("Alice");
        cms.addContact("Bob");
        cms.addContact("Charlie");
        cms.addContact("David");

        System.out.println("Contacts starting with 'A': " + cms.searchContacts("A"));
        System.out.println("Contacts starting with 'B': " + cms.searchContacts("B"));
        System.out.println("Contacts starting with 'C': " + cms.searchContacts("C"));

        System.out.println("Deleting contact 'Alice'");
        cms.deleteContact("Alice");

        System.out.println("Contacts starting with 'A': " + cms.searchContacts("A"));
    }
}
