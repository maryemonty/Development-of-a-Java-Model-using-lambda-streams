
public class Libro extends Catalogo {
    private String autore;
    private String genere;
    
    public Libro(String isbn, String titolo, int annoPubblicazione, int numPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }
    public void setAutore(String autore) {
		this.autore = autore;
	}
    
    public String getAutore() {
		return autore;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String getGenere() {
		return genere;
	}
	
	public static String toFileString(Libro libro) {
	    return String.format("%s@%s@%s@%d@%d@%s@%s", 
	            Libro.class.getSimpleName(), 
	            libro.getIsbn(),
	            libro.getTitolo(),
	            libro.getAnnoPubblicazione(),
	            libro.getNumPagine(),
	            libro.getAutore(),
	            libro.getGenere());
	}
	
	public static Libro fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");
		if (split.length != 7) {
			throw new IllegalArgumentException("Invalid input string");
		}
		return new Libro(split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6]);
	}
}