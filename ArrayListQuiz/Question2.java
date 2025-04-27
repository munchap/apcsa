public class Question2 implements Questions {
    final char ANSWER = 'B';

    @Override
    public void printPrompt() {
        System.out.println("Which of the following best describes the effect of using nums.set(index, value) on an ArrayList?");
    }

    @Override
    public void printAnswers() {
        System.out.println("(A) Inserts a new element at the specified index, shifting elements to the right");
        System.out.println("(B) Replaces the element at the specified index with the given value");
        System.out.println("(C) Removes the element at the specified index");
        System.out.println("(D) Appends the value to the end of the ArrayList");
        System.out.println("(E) Removes all instances of the given value");
        System.out.println("------------------------------------");
    }

    public char getAnswer(){
        return ANSWER;
    }
}