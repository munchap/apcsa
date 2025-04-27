public class Question3 implements Questions {
    final char ANSWER = 'A';

    @Override
    public void printPrompt() {
        System.out.println("Suppose arr is an ArrayList<String> that currently contains the elements [\"cat\", \"dog\", \"bird\"].");
        System.out.println("What is the result of calling arr.add(1, \"fish\");");
    }

    @Override
    public void printAnswers() {
        System.out.println("(A) [\"cat\", \"fish\", \"dog\", \"bird\"]");
        System.out.println("(B) [\"cat\", \"dog\", \"bird\", \"fish\"]");
        System.out.println("(C) [\"cat\", \"dog\", \"fish\", \"bird\"]");
        System.out.println("(D) [\"fish\", \"cat\", \"dog\", \"bird\"]");
        System.out.println("(E) [\"cat\", \"fish\", \"bird\", \"dog\"]");
        System.out.println("------------------------------------");
    }

    public char getAnswer(){
        return ANSWER;
    }
}
