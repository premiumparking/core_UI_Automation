package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import dataModel.OD.Location;
import dataModel.OD.Market;
import dataModel.OD.Operator;
import dataModel.OD.Venue;
import dataModel.SPA.Vehicle;

/*
 * Class is to handle the XML operations i.e. getting test data from xml and binding to Java object
 * 
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class XML_Operations {

	/*
	 * This method is to load the excel sheet and it binds to Operator object and
	 * return the Operator object
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Operator getOperatorTestData() {
		JAXBContext jaxbContext;
		Operator user = null;
		File xmlFile = new File("src\\test\\java\\testData\\operator.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Operator.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			user = (Operator) jaxbUnmarshaller.unmarshal(xmlFile);
			// System.out.println(user);
		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/*
	 * This method is to load the excel sheet and it binds to Market object and
	 * return the Market object
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Market getMarketTestData() {
		JAXBContext jaxbContext;
		Market market = null;
		File xmlFile = new File("src\\test\\java\\testData\\OD\\Market.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Market.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			market = (Market) jaxbUnmarshaller.unmarshal(xmlFile);
			// System.out.println(market);
		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return market;
	}

	/*
	 * This method is to load the excel sheet and it binds to Location object and
	 * return the Location object
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Location getLocationTestData() {
		JAXBContext jaxbContext;
		Location location = null;
		File xmlFile = new File("src\\test\\java\\testData\\OD\\Location.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Location.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			location = (Location) jaxbUnmarshaller.unmarshal(xmlFile);
		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}

	public Venue getVenueTestData() {
		JAXBContext jaxbContext;
		Venue venue = null;
		File xmlFile = new File("src\\test\\java\\testData\\OD\\Venue.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Venue.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			venue = (Venue) jaxbUnmarshaller.unmarshal(xmlFile);

		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return venue;
	}

	public Vehicle getVehicleTestData() {
		JAXBContext jaxbContext;
		Vehicle vehicle = null;
		File xmlFile = new File("src\\test\\java\\testData\\SPA\\Vehicle.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Vehicle.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			vehicle = (Vehicle) jaxbUnmarshaller.unmarshal(xmlFile);

		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
	}
}
