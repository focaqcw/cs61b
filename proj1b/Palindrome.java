public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new LinkedListDeque<Character>();
        for(int i = 0; i<word.length(); i++){
            result.addLast(word.charAt(i));
        }
        return result;
    }

}
