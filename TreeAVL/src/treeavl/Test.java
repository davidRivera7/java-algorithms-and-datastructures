//Arbol correcto
package treeavl;

public class Test {
    public static void main(String[] args) {                
        TreeAVL t = new TreeAVL();
        
        t.insert(17);        
        t.insert(47);        
        t.insert(100);        
        t.insert(23);        
        t.insert(21);        
        t.insert(54);        
        t.insert(80);        
        t.insert(69);        
        t.insert(12);        
        t.insert(57);        
        t.insert(44);        //
        t.insert(81);        //
        t.insert(66);        //
        t.insert(13);        //
        t.insert(37);        //
        t.insert(95);        //
        t.insert(3);        //
        t.insert(26);        //
        t.insert(41);        //
        t.insert(52);        //
        t.insert(85);        //
        t.insert(24);        //
        t.insert(6);        //
        t.insert(73);        //
        t.insert(56);        //
                
        t.inOrder();
    }
    
}
