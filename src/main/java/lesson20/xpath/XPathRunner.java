package lesson20.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

public class XPathRunner {

    public static void main(String[] args) throws Exception {
        // http://www.cbr.ru/scripts/XML_daily.asp
        try (InputStream inputStream = XPathRunner.class.getResourceAsStream("/cbr.xml")) {
            Document xmlDocument = getXML(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//Valute[@ID='R01020A']";
//            NodeList valutesNode = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            Node valuteNode = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
            System.out.println("ID узла: " + valuteNode.getAttributes().getNamedItem("ID").getNodeValue());
            NodeList childNodes = valuteNode.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && "Value".equals(node.getNodeName())) {
                    Element element = (Element) node;
                    System.out.println("Курс валюты: " + element.getTextContent());
                }
            }
            System.out.println("Содержимое тега Value: " + xPath.compile("//Valute[@ID='R01020A']/Value/text()").evaluate(xmlDocument, XPathConstants.STRING));

            double avg = (Double) xPath.compile("sum(//Valute/Value) div count(//Valute/Value)").evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.println("Среднее значение валют: " + avg);
        }
    }

    private static Document getXML(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }
}
