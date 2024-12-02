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

@Component
public class LibrosXMLSave {



    public void guardarLibroEnXML(LibroDTO librosRegistroDTO, String filePath) throws IOException, XMLStreamException{

        List<LibroDTO> libroDTOList = readXmlFile(filePath);
        if(checkIfISbnISRepeat(librosRegistroDTO, libroDTOList)) {
            libroDTOList.add(librosRegistroDTO);
            writeXmlFile(libroDTOList, filePath);
        }
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


        for(int i = 0; i < librosList.size(); i++){

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

    public boolean checkIfISbnISRepeat(LibroDTO libroDTO, List<LibroDTO> libroDTOList){
        for(LibroDTO libroDTO1 : libroDTOList){
            if(libroDTO1.getIsbn().equals(libroDTO.getIsbn())){
                return false;
            }
        }
        return true;
    }


}
