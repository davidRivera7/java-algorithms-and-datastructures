
package becas;

public class Beca {
    private int mesInicio;
    private int mesFin;
    private int precioMes;
    
    public Beca(int mesInicio, int mesFin, int precioMes) {
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
        this.precioMes = precioMes;
    }
    
    public int getMesInicio() {
        return mesInicio;
    }
    
    public int getMesFin() {
        return mesFin;
    }
    
    public int getPrecioMes() {
        return precioMes;
    }
            
    public int getTotalBeca() {
        int i = mesInicio; 
        int total = 0;
        
        while (i <= mesFin) {
            total += precioMes;
            i++;
        }
        
        return total;
    }
    
    @Override
    public String toString() {
        return "mesIni = " + mesInicio + ", mesFin = " + mesFin + ", precioMes = " + precioMes + 
                ", total = " + getTotalBeca();    
    }    
}
