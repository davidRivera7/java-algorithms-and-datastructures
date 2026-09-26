
package binaryTree;

public class Example {                
    
    public static void main(String[] args) {                                              
        Employee e1 = new Employee(100, "David");
        Employee e2 = new Employee(75, "Eduardo");
        Employee e3 = new Employee(78, "Rivera");
        Employee e4 = new Employee(50, "Ponce");
        Employee e5 = new Employee(30, "Selene");
        Employee e6 = new Employee(61, "Alison");
        Employee e7 = new Employee(200, "Laura");
        Employee e8 = new Employee(150, "Julio");
        Employee e9 = new Employee(220, "Christian");               
        Employee e10 = new Employee(230, "Anita");                               
       
        BST tree = new BST();
        tree.insert(e1);
        tree.insert(e2);
        tree.insert(e3);
        tree.insert(e4);
        tree.insert(e5);
        tree.insert(e6);
        tree.insert(e7);
        tree.insert(e8);
        tree.insert(e9);
        tree.insert(e10);              
        
        System.out.println(tree.totalLeafs());
    }
    
}
