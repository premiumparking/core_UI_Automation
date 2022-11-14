package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import dataModel.Operator;

public class loadXMLData {
	
	public Operator getOperatorTestData() {
		JAXBContext jaxbContext;
		Operator user = null;
		File xmlFile = new File("src\\test\\java\\testData\\operator.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Operator.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			user = (Operator) jaxbUnmarshaller.unmarshal(xmlFile);
			//System.out.println(user);
		} 
		
		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
