public class Punto {
//OVERVIEW: classe che modella un punto bidimensionale con coordinate x ed y
//          classe immutabile (sia per rappresentazione che per astrazione)--> invariante di rappresentazione non serve perché immutabile

//attributi
    final private double x;
    final private double y;

//costruttori
    public Punto() {
    //MODIFIES: this
    //EFFECTS: inizzializza un punto all'origine degli assi x ed y
        x = 0.0;
        y = 0.0;
    }

    public Punto(double x, double y) throws IllegalArgumentException {//overloading
    //MODIFIES: this
    //EFFECTS: inizzializza un punto date le coordinate x ed y
    //      se il punto ha un valore negativo lancia una IllegalArgumentException
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Il punto non può avere coordinate negative");

        this.x = x;
        this.y = y;
    }

//metodi
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) //verifico se il puntatore punta a null
            return false;

        if (this == o) //verifico se lo spazio in memoria è lo stesso condiviso dai due oggetti
            return true;
        
        if (getClass() != o.getClass()) //verifico se sono della stessa classe
            return false;

        //verifico l'ugualianza degli attributi
        Punto p = (Punto) o;
        if (this.x != p.getX())
            return false;
        if (this.y != p.getY())
            return false;
        return true;
    }

    @Override
    public String toString() { //funzione di astrazione
        String res = "( " + this.x + ", " + this.y + " )";
        return res;
    }

    public double distanzaTraPunti(Punto b) throws NullPointerException {
    //EFFECTS: calcola la distanza tra due punti
    //          se b è pari a null lancia "NullPointerException"

        if (b == null)
            throw new NullPointerException("Il punto b è pari a null");

        double b_x = b.getX();
        double b_y = b.getY();

        return Math.sqrt(Math.pow((this.x - b_x), 2) + Math.pow((this.y - b_y), 2));
    }

    public Punto generaPunto(double x, double y) {
    //EFFECTS: genera un nuovo punto ad una distanza x ed y

        double x_new = this.x + x;
        double y_new = this.y + y;

        return new Punto(x_new, y_new);
    }
}