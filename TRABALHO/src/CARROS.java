public class CARROS {
    public String NOME;
    public String MARCA;
    public int ANO;
    public String COR;
    public String VALOR;

    public CARROS (String NOME, String MARCA, int ANO, String COR, String VALOR){
        this.NOME=NOME;
        this.MARCA=MARCA;
        this.ANO=ANO;
        this.COR=COR;
        this.VALOR=VALOR;
    }
    public String getNOME(){return NOME;}
    public String getMARCA(){return MARCA;}
    public int getANO(){return ANO;}
    public String getCOR(){return COR;}
    public String getVALOR(){return VALOR;}
}
