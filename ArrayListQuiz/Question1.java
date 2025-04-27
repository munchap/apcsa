public class Question1 implements Questions {
    private final char ANSWER = 'B';

    @Override
    public void printPrompt() {
        System.out.println("Consider the following code segment:");
        System.out.println();
        System.out.println("ArrayList<Integer> nums = new ArrayList<Integer>();");
        System.out.println("nums.add(5);");
        System.out.println("nums.add(10);");
        System.out.println("nums.add(15);");
        System.out.println("nums.add(20);");
        System.out.println("nums.remove(1);");
        System.out.println();
        System.out.println("What are the contents of nums after the code executes?");
    }

    @Override
    public void printAnswers() {
        System.out.println("(A) [5, 10, 15, 20]");
        System.out.println("(B) [5, 15, 20]");
        System.out.println("(C) [5, 10, 20]");
        System.out.println("(D) [10, 15, 20]");
        System.out.println("(E) [5, 10, 15]");
        System.out.println("------------------------------------");
    }

    public char getAnswer() {
        return ANSWER;
    }
}
