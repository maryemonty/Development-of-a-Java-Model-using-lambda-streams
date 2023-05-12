import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

public class Main {

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		Archivio catalogo = new Archivio();
		
		Libro libro = new Libro("9781416554998","The Secret", 2006, 226, "Rhonda Byrne", "Letterario");
		Rivista rivista = new Rivista("11112","Cioè", 1980, 30, Periodicita.MENSILE);
		
		catalogo.aggiungi(libro);
		catalogo.aggiungi(rivista);
		
		catalogo.salvaCatalogo();
		
		catalogo.caricaCatalogo();
		
		List<Libro> ricercaAutore = catalogo.autore("Rhonda Byrne");
		
		ricercaAutore.forEach(elem -> System.out.println("Titolo: " + elem.getTitolo()));


	}

}
