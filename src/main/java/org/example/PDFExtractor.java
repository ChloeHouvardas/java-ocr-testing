package org.example;

// File handling
import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Data Type for extracting metadata
import java.util.HashMap;
import java.util.Map;

// Tika Components
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

// Exception handling
import org.xml.sax.SAXException;

public class PDFExtractor {
    // Invoke initial handler and context * Node, the limit for BodyContentHandler - Set -1 for unlimited
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext pcontext = new ParseContext();
    FileInputStream inputStream;
    PDFParser pdfparser = new PDFParser();

    public void PDFExtractor() {

    }

    // Takes filepath as input and tries to open and extract the file
    public void importPDF(String filepath) throws FileNotFoundException {
        inputStream = new FileInputStream(new File(filepath));
        try {
            pdfparser.parse(inputStream, handler, metadata, pcontext);
            System.out.println(handler.toString()); // Added for testing, will be replaced by getDocumentText in practice
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
    }

    // Returns the document text
    public String getDocumentText() {
        return handler.toString();
    }

    // Returns document metadata
    public Map<String, String> getMetadata() {
        String[] metadatanames = metadata.names();
        Map<String, String> metamap = new HashMap<>();
        for (String name: metadatanames) {
            metamap.put(name, metadata.get(name));
        }
        return metamap;
    }
}
