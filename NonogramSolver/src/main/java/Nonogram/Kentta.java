package Nonogram;

import java.util.Arrays;

/**
 * kenttä jolla peliä pelataan
 *
 */
public class Kentta {
    
    private Integer[][] alue;
    private Integer korkeus;
    private Integer leveys;
    private Integer ykkoset;
    private Integer kakkoset;
    
    /**
     * kenttä luodaan korkeudella ja leveydellä. kenttä myös pohjustetaan nollilla.
     *
     * @param l leveys
     * @param k korkeus
     */
    public Kentta(Integer k, Integer l) {
        this.alue = new Integer[l][k];

        this.korkeus = l;
        this.leveys = k;
//        System.out.println("kenttä alustettaan: " + k + ", " + l);
        ykkoset = 0;
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                alue[j][i] = 0;
            }
        }
//        System.out.println(this);
    }
    
    public Integer getYkkoset() {
        return ykkoset;
    }

    public Integer[][] getKentta() {
        return alue;
    }
    
    public void setKentta(Integer[][] kentta) {
        alue = kentta;
    }

    public Integer getKorkeus() {
        return korkeus;
    }

    public Integer getLeveys() {
        return leveys;
    }
    public int getKohta(int i, int j) {
//        System.out.println("haetaan kohtaa (" + i + ", " + j + ")");
        return alue[i][j];
    }
    
    /**
     * 
     * @param i x koordinaatti
     * @param j y koordinaatti
     * @param k numero joka asetetaan x ja y koordinaatteihin
     */
    public void setKohta(int i, int j, int k) {
        if (k == 1 && alue[i][j] == 0) {
            ykkoset++;
        } 
        else if (alue[i][j] == 1 && k == 0) {
            ykkoset--;
        }
        alue[i][j] = k;
    }
    /**
     * palauttaa halutun rivin.
     * @param i halutun rivin indexi taulukossa
     * @return palauttaa yksittäisen Integer[] taulukon.
     */
    public Integer[] getRivi(int i) {
        return alue[i];
    }
    
    /**
     * palauttaa halutun sarakkeen.
     * @param i halutun sarakkeen indexi talukossa
     * @return palauttaa yksittäisen Integer[] taulukon.
     */
    public Integer[] getSarake(int i) {
        Integer[] palaute = new Integer[korkeus];
        for (int j = 0; j < korkeus; j++) {
            palaute[j] = alue[j][i];
        }
        return palaute;
    }
    
    /**
     * testi metodi/ metodi jota bruteforce käytää. Tämäkin on huono- /
     * hidasratkaisu bruteforcen ratkomiseen mutta, kakkos muuttuja mukana
     * tuominen rekursiivisestikkään ei toiminut joten parempaa ei tule olemaan.
     *
     * @return palauttaa tämän hetkiset kakkoset jota kentällä on.
     */
    public Integer getKakkoset() {
        Integer kakkos = 0;
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (alue[i][j] == 2) {
                    kakkos++;
                }
            }
        }
        return kakkos;
    }

    /**
     * kopio this.kentaksi annetun kentan.
     *
     * @param k kentta joka kopiodaan tähän kenttaan.
     */
    public void copy(Kentta k) {
        Integer[][] uusi = new Integer[k.korkeus][k.leveys];
        for (int i = 0; i < uusi.length; i++) {
            for (int j = 0; j < uusi[0].length; j++) {
                uusi[i][j] = k.getKohta(i, j);
            }
        }
        alue = uusi;
        korkeus = k.getKorkeus();
        leveys = k.getLeveys();
        ykkoset = k.getYkkoset();
    }

    private Integer[][] getAlue() {
        return alue;
    }
    
    @Override
    public String toString() {
        String palaute = "";
        for (int i = 0; i < alue.length; i++) {
            palaute += "[";
            for (Integer item : alue[i]) {
                palaute = palaute + item;
            }
            if (i+1==alue.length) {
                palaute += "]";
            } else {
                palaute += "]\n";
            }
            
        }
        return palaute;
    }
}
