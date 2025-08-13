class Solution {
    public int lengthOfLastWord(String s) {
        String word[]=s.split(" ");
        String lastword=word[word.length-1];
        int length=lastword.length();
        return length;
        
    }
}