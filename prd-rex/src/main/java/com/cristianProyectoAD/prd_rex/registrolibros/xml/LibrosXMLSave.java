package com.cristianProyectoAD.prd_rex.registrolibros.xml;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import org.springframework.stereotype.Component;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lectura y escritura de datos de libros en formato XML.
 * @author cristian
 * @version 1.0
 */
@Component
public class LibrosXMLSave {


    /**
     * Guarda un libro en un archivo XML, verificando previamente si el ISBN ya existe.
     *
     * @param librosRegistroDTO objeto que representa el libro a guardar.
     * @param filePath ruta del archivo XML.
     * @throws IOException si ocurre un error durante la lectura o escritura del archivo.
     * @throws XMLStreamException si ocurre un error al procesar el XML.
     */
    public void guardarLibroEnXML(LibroDTO librosRegistroDTO, String filePath) throws IOException, XMLStreamException{

        List<LibroDTO> libroDTOList = readXmlFile(filePath);
        if(checkIfISbnISRepeat(librosRegistroDTO, libroDTOList)) {
            libroDTOList.add(librosRegistroDTO);
            writeXmlFile(libroDTOList, filePath);
        }
    }

    /**
     * Lee un archivo XML y convierte los datos en una lista de objetos {@link LibroDTO}.
     *
     * @param path ruta del archivo XML a leer.
     * @return una lista de libros leída del archivo.
     * @throws IOException si ocurre un error al abrir el archivo.
     * @throws XMLStreamException si ocurre un error al procesar el XML.
     */
    public List<LibroDTO> readXmlFile(String path) throws IOException, XMLStreamException {
        List<LibroDTO> librosList = new ArrayList<>();
        String elementoActual = "";
        String isbn = "";
        String autor = "";
        String nombre = "";
        LocalDate fechaLectura = null;
        LocalDate fechaRegistro = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path));
        int element;

        while (xmlStreamReader.hasNext()) {
            element = xmlStreamReader.next();

            if (element == XMLStreamConstants.START_ELEMENT) {
                elementoActual = xmlStreamReader.getLocalName();
            } else if (element == XMLStreamConstants.CHARACTERS) {
                String text = xmlStreamReader.getText().trim();
                if ("isbn".equals(elementoActual) && !text.isEmpty()) {
                    isbn = xmlStreamReader.getText().trim();

                } else if ("autor".equals(elementoActual) && !text.isEmpty()) {
                    autor = xmlStreamReader.getText().trim();
                } else if ("nombre".equals(elementoActual) && !text.isEmpty()) {
                    nombre = xmlStreamReader.getText().trim();
                } else if ("fechaLectura".equals(elementoActual) && !text.isEmpty()) {
                    fechaLectura = LocalDate.parse(xmlStreamReader.getText().trim());
                } else if ("fechaRegistro".equals(elementoActual) && !text.isEmpty()) {
                    fechaRegistro = LocalDate.parse(xmlStreamReader.getText().trim());
                }

            } else if (element == XMLStreamConstants.END_ELEMENT) {
                if ("libro".equals(xmlStreamReader.getLocalName())) {
                    librosList.add(new LibroDTO(isbn, autor, nombre, fechaLectura, fechaRegistro));
                }

            }

        }
        return librosList;


    }

    /**
     * Escribe una lista de libros en un archivo XML.
     *
     * @param librosList lista de libros a escribir.
     * @param filePath ruta del archivo XML.
     * @throws IOException si ocurre un error al abrir o escribir el archivo.
     * @throws XMLStreamException si ocurre un error al procesar el XML.
     */
    public void writeXmlFile(List<LibroDTO> librosList, String filePath) throws IOException, XMLStreamException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(filePath));
        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeCharacters("\n");
        xmlStreamWriter.writeStartElement("libros");


        for (LibroDTO libroDTO : librosList) {

            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("libro");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("isbn");
            xmlStreamWriter.writeCharacters(libroDTO.getIsbn());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("autor");
            xmlStreamWriter.writeCharacters(libroDTO.getAutor());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("nombre");
            xmlStreamWriter.writeCharacters(libroDTO.getNombre());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("fechaLectura");
            xmlStreamWriter.writeCharacters(libroDTO.getFechaLectura().toString());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("fechaRegistro");
            xmlStreamWriter.writeCharacters(libroDTO.getFechaRegistro().toString());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.close();
    }

    /**
     * Verifica si un libro ya existe en la lista basándose en el ISBN.
     *
     * @param libroDTO libro a verificar.
     * @param libroDTOList lista de libros existente.
     * @return true si el ISBN no está repetido; false en caso contrario.
     */
    public boolean checkIfISbnISRepeat(LibroDTO libroDTO, List<LibroDTO> libroDTOList){
        for(LibroDTO libroDTO1 : libroDTOList){
            if(libroDTO1.getIsbn().equals(libroDTO.getIsbn())){
                return false;
            }
        }
        return true;
    }


}
