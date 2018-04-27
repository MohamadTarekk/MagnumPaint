package paint.controller;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import paint.model.Shape;

public class XML implements MyFile {

	Data data = Data.getInstance();
	
	@Override
	public void save(String filePath) {
		
		ArrayList<Shape> arr = data.getDrawingsList();
		XMLEncoder e;
		try {
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)));
		    e.writeObject(arr);
		    e.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		/*
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.newDocument();
			
			Element element = document.createElement("Developer");
			document.appendChild(element);
			
			Attr attr = document.createAttribute("ID");
			attr.setValue("1");
			element.setAttributeNode(attr);
			
			Element name = document.createElement("Name");
			name.appendChild(document.createTextNode("Mahmoud"));
			element.appendChild(name);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(document);
			
			StreamResult streamResult = new StreamResult(filePath);
			
			transformer.transform(source, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//*/
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String filePath) {
		
		XMLDecoder e;
		try {
			e = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
		    data.setDrawingsList((ArrayList<Shape>) e.readObject());
		    e.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		/*
		try {
			File xmlFile = new File(filePath);
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);

			NodeList list = document.getElementsByTagName("Developer");
			
			for(int i = 0; i<list.getLength(); i++) {
				Node node = list.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println(element.getAttribute("ID"));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//*/
	}
}