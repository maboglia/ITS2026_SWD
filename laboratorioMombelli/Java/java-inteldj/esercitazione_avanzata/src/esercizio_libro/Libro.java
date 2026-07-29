package esercizio_libro;

import java.util.Objects;

public class Libro {
    private String autori;
    private String titolo;
    private Integer annoDiPubblicazione = Integer.MAX_VALUE;
    private String codiceISBN;

    public Libro(String autori, String titolo, String codiceISBN) {
        this.autori = autori;
        this.titolo = titolo;
        this.codiceISBN = codiceISBN;
    }

    @Override
    public String toString() {
        if (this.annoDiPubblicazione != Integer.MAX_VALUE) {
            return this.autori + ", " + this.titolo + ", " + this.annoDiPubblicazione + ", " + this.codiceISBN;
        } else {
            return this.autori + ", " + this.titolo + ", " + this.codiceISBN;
        }
    }

    public Libro cambiaAnno(Integer anno) {
        this.annoDiPubblicazione = anno;
        return this;
    }

    public Boolean inAnno(Integer anno) {
        return this.annoDiPubblicazione.equals(anno);
    }

    public Boolean stessoAnno(Libro l){
        if (this.annoDiPubblicazione.equals(l.annoDiPubblicazione)) {
            return true;
        } else {
            return false;
        }
    }

    public Libro cambiaAnno(Libro l){
        this.annoDiPubblicazione = l.annoDiPubblicazione;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(autori, libro.autori) && Objects.equals(titolo, libro.titolo) && Objects.equals(annoDiPubblicazione, libro.annoDiPubblicazione) && Objects.equals(codiceISBN, libro.codiceISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autori, titolo, annoDiPubblicazione, codiceISBN);
    }

    public String getAutori() {
        return autori;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(Integer annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }
}
