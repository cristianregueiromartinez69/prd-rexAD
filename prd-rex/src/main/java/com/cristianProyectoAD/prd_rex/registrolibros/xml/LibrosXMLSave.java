package com.cristianProyectoAD.prd_rex.registrolibros.xml;

import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroDTO;
import com.cristianProyectoAD.prd_rex.registrolibros.dto.LibroRegistroDTOWrapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar la lógica de los elementos guardados en listas para escribir en xml
 *
 * @author cristian
 * @version 1.0
 */
@Component
public class LibrosXMLSave {


    /**
     * Metodo para guardar datos en fichero xml
     *
     * @param librosRegistroDTO el libro ha guardar
     * @param filePath          la ruta donde estará el archivo
     * @throws IOException lanzamos una excepcion que será recogida en el controlador
     */
    public void guardarLibroEnXML(LibroDTO librosRegistroDTO, String filePath) throws IOException, XMLStreamException {

        List<LibroDTO> libroDTOList = readXmlFile(filePath);
        libroDTOList.add(librosRegistroDTO);
        writeXmlFile(libroDTOList, filePath);
    }

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

    public void writeXmlFile(List<LibroDTO> librosList, String filePath) throws IOException, XMLStreamException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(filePath));
        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeCharacters("\n");
        xmlStreamWriter.writeStartElement("libros");

        /**
         * bucle for de 2 vueltas ya que nos piden escribirlo 2 veces
         * será tan largo como longitud tenga el objeto array autores
         */
        for(int i = 0; i < librosList.size(); i++){

            /**
             * Explicación de los métodos
             * writeCharacters -> va a escribir algo dentro de un tag
             * writeStartElement -> nombre de la etiqueta y la inicia
             * writeAttribute -> atributo con valor de la etiqueta anteriormente creada
             * writeEndElement -> cerramos la ultima etiqueta abierta
             */
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("libro");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("isbn");
            xmlStreamWriter.writeCharacters(librosList.get(i).getIsbn());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("autor");
            xmlStreamWriter.writeCharacters(librosList.get(i).getAutor());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("nombre");
            xmlStreamWriter.writeCharacters(librosList.get(i).getNombre());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("fechaLectura");
            xmlStreamWriter.writeCharacters(librosList.get(i).getFechaLectura().toString());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("fechaRegistro");
            xmlStreamWriter.writeCharacters(librosList.get(i).getFechaRegistro().toString());
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters("\n");
        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.close();
    }


}
