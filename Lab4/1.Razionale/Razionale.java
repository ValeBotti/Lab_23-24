import java.util.Scanner;

public class Razionale {
//OVERVIEW: modella un numero razionale
//          rappresentazione immutabile ed astrazione mutabile

//attributi
    private int num;
    private int den;

//costruttore
    public Razionale(int num, int den) throws ArithmeticException {
    //MODIFIES: this
    //EFFECTS: inizzializza this
    //      se den == 0 lancia una ArithmeticException
        if (den == 0)
            throw new ArithmeticException("Denominatore del razionale e' zero");

        this.num = num;
        this.den = den;
    }

//metodi
    
    public double valore() throws ArithmeticException {
    //EFFECTS: restituisce il rapporto tra numeratore e denominatore

        try {
            return num/den;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Denominatore del razionale e' zero");
        }
    }

    public void setNum(int num) {
        this.num = num;
        assert repOk();
    }

    public void setDen(int den) {
        this.den = den;
        assert repOk();
    }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    @Override
    public String toString() { //funzione di astrazione
        String res = "Numeratore: " + num + " Denominatore: " + den;
        return res;
    }

    public boolean repOk() {//invariante di rappresentazione
        if (den == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = 0;
        int den = 0;

        while (s.hasNext()) {
            num = s.nextInt();
            den = s.nextInt();
        }

        Razionale r = new Razionale(num, den);

        System.out.println(r.valore());

        s.close();
    }
}
