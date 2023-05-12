
public class Rivista extends Catalogo {
    private Periodicita periodicita;
    
    public Rivista(String isbn, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }
    
    public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	public static String toFileString(Rivista rivista) {
	    return String.format("%s@%s@%s@%d@%d@%s", 
	            Rivista.class.getSimpleName(), 
	            rivista.getIsbn(),
	            rivista.getTitolo(),
	            rivista.getAnnoPubblicazione(),
	            rivista.getNumPagine(),
	            rivista.getPeriodicita());
	}

	public static Rivista fromFileString(String fileString) {
	    String[] split = fileString.split("@");
	    String isbn = split[1];
	    String titolo = split[2];
	    int annoPubblicazione = Integer.parseInt(split[3]);
	    int numPagine = Integer.parseInt(split[4]);
	    Periodicita periodicita = Periodicita.valueOf(split[5]);
	    return new Rivista(isbn, titolo, annoPubblicazione, numPagine, periodicita);
	}
}
    

