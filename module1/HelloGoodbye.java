public class HelloGoodbye {

    /**
     * Hello Kevin and Bob.
     * Goodbye Bob and Kevin.
     * */
    public static void main(String... args){
        if(args.length > 2){
            System.out.println("Too many args!");
        } else{
            System.out.println("Hello " + args[0] + " and " + args[1] + ".");
            System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
        }
    }
}
