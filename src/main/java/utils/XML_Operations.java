package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import dataModel.OD.*;
import dataModel.SPA.Vehicle;
import dataModel.TextPay.Guest;

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
		File xmlFile = new File("src\\test\\java\\testdata\\OD\\Location.xml");

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
		File xmlFile = new File("src\\test\\java\\testdata\\OD\\Venue.xml");

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
		File xmlFile = new File("src\\test\\java\\testdata\\SPA\\Vehicle.xml");

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

	public Guest getGuestTestData() {
		JAXBContext jaxbContext;
		Guest guest = null;
		File xmlFile = new File("src\\test\\java\\testdata\\TextPay\\Guest.xml");

		try {
			jaxbContext = JAXBContext.newInstance(Guest.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			guest = (Guest) jaxbUnmarshaller.unmarshal(xmlFile);

		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guest;
	}

	/*
	 * This method is to load the data from XML file and bind it to the respective
	 * JAVA object
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Object getTestData(String model) {
		JAXBContext jaxbContext;
		File xmlFile;

		switch (model.toLowerCase()) {
		case "guest":
			Guest guest = null;
			xmlFile = new File("src\\test\\java\\testdata\\TextPay\\Guest.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Guest.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				guest = (Guest) jaxbUnmarshaller.unmarshal(xmlFile);

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return guest;

		case "vehicle":
			Vehicle vehicle = null;
			xmlFile = new File("src\\test\\java\\testdata\\SPA\\Vehicle.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Vehicle.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				vehicle = (Vehicle) jaxbUnmarshaller.unmarshal(xmlFile);

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vehicle;

		case "location":
			Location location = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Location.xml");
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

		case "event_rates":
			EventRates eventRates = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\EventRates.xml");
			try {
				jaxbContext = JAXBContext.newInstance(EventRates.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				eventRates = (EventRates) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return eventRates;

		case "blackout":
			Blackout blackout = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Blackout.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Blackout.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				blackout = (Blackout) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return blackout;

		case "whitelist":
			Whitelist whitelist = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Whitelist.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Whitelist.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				whitelist = (Whitelist) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return whitelist;

		case "promocode":
			PromoCode promoCode = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\PromoCode.xml");
			try {
				jaxbContext = JAXBContext.newInstance(PromoCode.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				promoCode = (PromoCode) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return promoCode;

		case "user":
			User user1 = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\User.xml");
			try {
				jaxbContext = JAXBContext.newInstance(User.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				user1 = (User) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user1;

		case "profile":
			Profile profile1 = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Profile.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Profile.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				profile1 = (Profile) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return profile1;

		case "client":
			Client client = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Client.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Client.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				client = (Client) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return client;

		case "fee":
			Fee fee = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Fee.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Fee.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				fee = (Fee) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fee;

		case "role":
			Role role = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Role.xml");
			try {
				jaxbContext = JAXBContext.newInstance(Role.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				role = (Role) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return role;

		case "glcode":
			GLCode glCode = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\GLCode.xml");
			try {
				jaxbContext = JAXBContext.newInstance(GLCode.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				glCode = (GLCode) jaxbUnmarshaller.unmarshal(xmlFile);
			}

			catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return glCode;


		case "operator":
			Operator user = null;
			xmlFile = new File("src\\test\\java\\testData\\operator.xml");
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
		case "market":
			Market market = null;
			xmlFile = new File("src\\test\\java\\testData\\OD\\Market.xml");
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
		case "venue":
			Venue venue = null;
			xmlFile = new File("src\\test\\java\\testdata\\OD\\Venue.xml");
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

		return null;
	}
}
