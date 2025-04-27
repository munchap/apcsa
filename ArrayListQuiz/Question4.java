public class Question4 implements Questions {
    final char ANSWER = 'A';

    @Override
    public void printPrompt() {
        System.out.println("Given the following method:");
        System.out.println();
        System.out.println("public static void doubleValues(ArrayList<Integer> list) {");
        System.out.println("    for (int i = 0; i < list.size(); i++) {");
        System.out.println("        list.set(i, list.get(i) * 2);");
        System.out.println("    }");
        System.out.println("}");
        System.out.println();
        System.out.println("If list initially contains [1, 3, 5], what will list contain after doubleValues(list) is called?");
    }

    @Override
    public void printAnswers() {
        System.out.println("(A) [2, 6, 10]");
        System.out.println("(B) [1, 6, 10]");
        System.out.println("(C) [2, 3, 5]");
        System.out.println("(D) [1, 3, 5, 2, 6, 10]");
        System.out.println("(E) [2, 6, 5]");
        System.out.println("------------------------------------");
    }

    public char getAnswer(){
        return ANSWER;
    }
}
