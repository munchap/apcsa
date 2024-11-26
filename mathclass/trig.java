public class trig {
    public static void trigMain() {

        int randomAngle = (int) (Math.round((Math.random() * 91 - 0.5)));      
        System.out.println("Random angle (radians): " + randomAngle);

        double sin = Math.sin(randomAngle);
        double cos = Math.cos(randomAngle);
        double tan = Math.tan(randomAngle);

        System.out.println("Sine: " + sin);
        System.out.println("Cosine: " + cos);
        System.out.println("Tangent: " + tan);
    } 
}
