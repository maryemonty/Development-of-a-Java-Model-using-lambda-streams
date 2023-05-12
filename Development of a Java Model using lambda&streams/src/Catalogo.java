public class Catalogo {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numPagine;
    
    public Catalogo(String isbn, String titolo, int annoPubblicazione, int numPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }
    
    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumeroPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
