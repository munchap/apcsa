public class Question5 implements Questions {
    final char ANSWER = 'C';

    @Override
    public void printPrompt() {
        System.out.println("Which of the following statements about ArrayLists is true?");
    }

    @Override
    public void printAnswers() {
        System.out.println("(A) The size of an ArrayList must be specified when it is declared.");
        System.out.println("(B) ArrayLists can store primitive types like int and double directly.");
        System.out.println("(C) Removing an element from an ArrayList decreases its size by one.");
        System.out.println("(D) ArrayLists cannot be resized after being created.");
        System.out.println("(E) Elements in an ArrayList must be unique; duplicates are not allowed.");
        System.out.println("------------------------------------");
    }

    public char getAnswer(){
        return ANSWER;
    }
}
