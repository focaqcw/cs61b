public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque wordDeck = wordToDeque(word);
        while (wordDeck.size() > 1) {
            Character first = (Character) wordDeck.removeFirst();
            Character last = (Character) wordDeck.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordDeck = wordToDeque(word);

        while (wordDeck.size() > 1) {
            Character first = (Character) wordDeck.removeFirst();
            Character last = (Character) wordDeck.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;

    }

}
