
import java.util.ArrayList;


public class Tree {
    private Number number;
    private Tree left;
    private Tree right;
    
    public void insert(int number) {        
        Number newNumber = new Number(number);        
        if (this.number == null) {
            this.number = newNumber;
        } else if (number < this.number.getNum()) {
            if (left == null) left = new Tree();
                left.insert(number);            
        } else {
            if (right == null) right = new Tree();
                right.insert(number);            
        }        
    }
    
    public void inOrder() {
        if (number != null) {
            System.out.print(number.getNum() + " - ");
            if (left != null) left.inOrder();
            if (right != null) right.inOrder();
        }                
    }        
    
    //challengue: imprimir la raiz (o el camino) mas grande (con mas elementos).
    public void printLargestRoot(int sum, ArrayList<String> route, Number longer, ArrayList<String> path) {

        if (number != null) {

            if (left == null && right == null) {
                if (sum > longer.getNum()) {
                    longer.setNum(sum); 
                    path.clear();
                    for (int i = 0; i < route.size(); i++)                         
                        path.add(route.get(i));                    
                }
            }
            
            if (left != null) {
                route.add("Izq");
                left.printLargestRoot(sum + 1, route, longer, path);
                route.remove(route.size() - 1);
            }
            if (right != null) {
                route.add("der");
                right.printLargestRoot(sum + 1, route, longer, path);
                route.remove(route.size() - 1);
            }

        }
    }        
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        
        tree.insert(8);
        tree.insert(3);
        tree.insert(20);//der
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(15);//--izq
        tree.insert(18);//--der
        tree.insert(16);//--izq
        tree.insert(14);//
        tree.insert(17);//--der        
                                        
        ArrayList<String> path = new ArrayList<>();
        Number longer = new Number(0);
        tree.printLargestRoot(0, new ArrayList<>(), longer, path);
        System.out.println(path);     
        System.out.println(longer);
    }
    
    
}
