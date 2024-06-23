public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> charDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++){
            char a = word.charAt(i);
            charDeque.addLast(a);
        }
        return charDeque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> charDeque = wordToDeque(word);
        while (!charDeque.isEmpty()) {
            if (charDeque.size() == 1){
                return true;
            }
            if (charDeque.removeFirst() != charDeque.removeLast()){
                return false;
            }
        }
        return true;
    }

}
