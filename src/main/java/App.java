import calculation.Overlap;

public class App {
    public static void main(String [] args) {
        if(args.length == 8){
            int [] coordinates = parseArgsToNumbers(args);
            Overlap overlap = new Overlap(coordinates);
            System.out.println("Overlap area is: " + overlap.calculateOverlap());
        }else{
            System.out.println("8 intigers required, got " + args.length);
        }

    }

    private static int [] parseArgsToNumbers(String [] args){
        int [] coordinates = new int [8];

        try {
            for(int i = 0; i < args.length; ++i){
                coordinates[i] = Integer.valueOf(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            System.exit(0);
        }
        return coordinates;
    }

}
