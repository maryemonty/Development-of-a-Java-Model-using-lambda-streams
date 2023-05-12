import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class Archivio {
	private static final Logger logger = Logger.getLogger(Archivio.class);
	private static final String FILE_PATH = "C:\\Users\\39388\\Desktop\\biblioteca.txt";
	private Map<String, Catalogo> archivio;

	public Archivio() {
		this.archivio = new HashMap<>();	
	}

	public void aggiungi(Catalogo nuovoElemento) {
		archivio.put(nuovoElemento.getIsbn(), nuovoElemento);
		System.out.printf("Elemento aggiunto in archivio. ISBN: {} - Anno Pubblicazione: {}",nuovoElemento.getIsbn(), nuovoElemento.getAnnoPubblicazione());
	}
	
	public void rimuovi(String isbn) {
		Catalogo elementoRimosso = archivio.remove(isbn);
		if (elementoRimosso != null)
			System.out.printf("Elemento rimosso dall'archivio. ISBN: {} - Anno Pubblicazione: {}",elementoRimosso.getIsbn(), elementoRimosso.getAnnoPubblicazione());
	}
	
	public Catalogo ricercaPerIsbn(String isbn) {
		return archivio.get(isbn);	
	}
	
	public List<Catalogo> ricercaPerAnnoPubblicazione(Integer annoPubblicazione) {
		return archivio.values().stream()
					  .filter(elem -> annoPubblicazione.equals(elem.getAnnoPubblicazione()))
					  .collect(Collectors.toList()); 
	}
	
	public List<Libro> autore(String autore) {
		return archivio.values().stream()
					  .filter(elem -> elem instanceof Libro)
					  .map(elem -> (Libro) elem)
					  .filter(elem -> autore.equals(elem.getAutore()))
					  .collect(Collectors.toList()); 
	}
	
	public void salvaCatalogo() {
		StringBuilder fileString = new StringBuilder();

		for (Catalogo elemento : archivio.values()) {
			if (fileString.length() != 0) {
				fileString.append("#");
			}
			if (elemento instanceof Libro) {
				fileString.append(Libro.toFileString((Libro) elemento));
			} else if (elemento instanceof Rivista) {
				fileString.append(Rivista.toFileString((Rivista) elemento));
			} 
		}

		try {
			FileUtils.writeStringToFile(new File(FILE_PATH), fileString.toString(), "UTF-8");
			logger.info(String.format("Dati salvati correttamente sul file %s", FILE_PATH));
		} catch (IOException e) {
			logger.error(String.format("Errore durante la scrittura sul file %s", FILE_PATH), e);
		}
	}

	public void caricaCatalogo() {
	    this.archivio.clear();

	    try {
	        String fileString = FileUtils.readFileToString(new File(FILE_PATH), "UTF-8");
	        List<String> splitElementiString = Arrays.asList(fileString.split("#"));

	        for (String curString : splitElementiString) {
	            Catalogo elemento = null;
	            if (curString.startsWith(Libro.class.getSimpleName())) {
	                elemento = Libro.fromStringFile(curString);
	            } else if (curString.startsWith(Rivista.class.getSimpleName())) {
	                elemento = Rivista.fromFileString(curString);
	            }
	            if (elemento != null) {
	                this.archivio.put(elemento.getIsbn(), elemento);
	            }
	        }
	        System.out.printf("Dati caricati con successo da %s\n", FILE_PATH);

	    } catch (IOException e) {
	        System.out.printf("Errore durante la lettura del file %s: %s\n", FILE_PATH, e.getMessage());
	    }
	}	

	}