package torreshanoi;

public class TorresHanoi {

    //no es entendible.
    public static void torres(int discs, Stack origin, Stack aux, Stack destiny) {
        if (discs == 1) {
            destiny.insert(origin.getValue());
            origin.unstack();
        } else {
            torres(discs - 1, origin, destiny, aux);
            destiny.insert(origin.getValue());
            origin.unstack();
            torres(discs - 1, aux, origin, destiny);
        }
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        int[] numbers = {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int i : numbers) {
            stack1.insert(i);
        }

        torres(13, stack1, stack2, stack3);
        System.out.println("TORRE 1");
        System.out.print(stack1);
        System.out.println("TORRE 2");
        System.out.print(stack2);
        System.out.println("TORRE 3");
        System.out.print(stack3);
    }

}
