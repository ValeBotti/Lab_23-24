import java.util.ArrayList;
import java.util.Scanner;

public class Percorso {
//OVERVIEW: modella una percorso costituito da una sequenza di dati di tipo Punto
//          calsse mutabile (astrazione ed implementazione mutabile)

//attributi
    private ArrayList<Punto> path = new ArrayList<Punto>();

//costruttori
    public Percorso(ArrayList<Punto> path) throws NullPointerException {
    //MODIFIES: this
    //EFFECTS: inizzializza l'array p inserendo i punti appartenenti al percorso
    //         se path == null lancia una NullPointerException
    //         se p (elemento dell'array path) == null lancia una NullPointerException

        for (Punto p : path) {
            if (p == null)
                throw new NullPointerException("Un elemento contenuto nell'array path è pari a null");
        }

        if (path == null)
            throw new NullPointerException("La variabile path è pari a null");

        this.path = path;
    }

//metodi
    public void add(Punto p) throws NullPointerException {
    //MODIFIES: this (p)
    //EFFECTS: aggiunge un punto alla fine del percorso
    //         se p == null lancia una NullPointerException

        if (p == null)
            throw new NullPointerException("Il punto è pari a null");

        path.add(p);
    }

    public void remove(Punto p) throws NullPointerException {
    //MODIFIES: this (p)
    //EFFECTS: rimuove l'ultimo punto alla fine del percorso
    //         se p == null lancia una NullPointerException

        path.remove(p);
    }

    public double length(){
    //EFFECTS: calcola la lunghezza del percorso
        double lengthPath = 0;

        for (int i = 0; i < path.size()-1; i++) {
            Punto a = path.get(i);
            Punto b = path.get(i+1);

            double a_x = a.getX();
            double a_y = a.getY();

            double b_x = b.getX();
            double b_y = b.getY();

            lengthPath += Math.sqrt(Math.pow(a_x - b_x, 2) + Math.pow(a_y - b_y, 2));
        }

        return lengthPath;
    }

    @Override
    public String toString() {
        String path_stringa = "";

        for (Punto punto : path) {
            path_stringa += punto.toString();
        }
        
        return path_stringa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        Percorso other = (Percorso) o;

        if (other.path == null) {
            return false;
        } else if (!this.path.equals(other.path))
            return false;

        for (int i = 0; i < path.size(); i++) {
            if (!path.get(i).equals(other.path.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean repOk() {
        if (path == null)
            return false;
        
        for (Punto punto : path) {
            if (punto == null)
                return false;
        }

        return true;
    }

    public static void main(String args[]) {

        ArrayList<Punto> storage = new ArrayList<Punto>();

        System.out.println("Inserisci le coordinate di un punto per riga nel formato <x y> (termina con CTRL+D)");

        Scanner s = new Scanner(System.in);

        while (s.hasNextDouble()) {
            double x = s.nextDouble();
            double y = s.nextDouble();

            System.out.println(x + ";" + y);

            Punto p = new Punto(x, y);

            storage.add(p);
        }

        Percorso path = new Percorso(storage);

        for (int i = 0; i < storage.size()-1; i++) {
            ArrayList<Punto> due_punti = new ArrayList<>();

            due_punti.add(storage.get(i));
            due_punti.add(storage.get(i+1));

            Percorso step = new Percorso(due_punti);

            System.out.println("Tratto " + (i+1) + ":" + " distanza " + step.length());
        }

        System.out.println("Totale: " + path.length());

        s.close();
    }
}
