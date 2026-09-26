import java.util.ArrayList;

public class Path {
    private ArrayList<String> paths;
    
    public Path() {
        paths = new ArrayList<>();
    }
    
    public void addPath(String path) {
        paths.add(path);
    }
    
    public void clearPath() {
        paths.clear();
    }        

    public ArrayList<String> getPaths() {
        return paths;
    }
    
}