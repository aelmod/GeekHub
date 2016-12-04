package com.github.aelmod.geekhub.homework5.task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by aelmod-notebook on 24.11.2016.
 */
public class XMLParser {
    public static String parse(String document) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document response = documentBuilder.parse(new InputSource(new StringReader(document)));
        NodeList nodeList = response.getElementsByTagName("Translation");
        Node node = nodeList.item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            return ("Translation: " + eElement.getElementsByTagName("text").item(0).getTextContent());
        }
        return null;
    }
}
