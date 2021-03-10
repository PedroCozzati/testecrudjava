public class Controle {
    
    private int continuar;
    private int fim;
    private int ver;
    private int modificar;

    public Controle(int continuar, int fim, int ver, int modificar) {
        this.setContinuar(continuar);
        this.setFim(fim);
        this.setVer(ver);
        this.setModificar(modificar);
    }

    public int getModificar() {
        return modificar;
    }

    public void setModificar(int modificar) {
        this.modificar = modificar;
    }


    public int getVer() {
        return ver;
    }


    public void setVer(int ver) {
        this.ver = ver;
    }


    public int getFim() {
        return fim;
    }


    public void setFim(int fim) {
        this.fim = fim;
    }


    public int getContinuar() {
        return continuar;
    }


    public void setContinuar(int continuar) {
        this.continuar = continuar;
    }
    
}