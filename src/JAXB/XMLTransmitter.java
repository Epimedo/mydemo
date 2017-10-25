package JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLTransmitter {
	public void intoXML(Object obj,Class<?> c,File file) throws JAXBException
	  {
		  
		  JAXBContext context = JAXBContext.newInstance(c);
	      Marshaller marshaller = context.createMarshaller();
	      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	      marshaller.marshal(obj, file);
	      marshaller.marshal(obj, System.out);
	  }
	  public Object outXML(File file,Class c) throws JAXBException, InstantiationException, IllegalAccessException
	  {
		  JAXBContext context = JAXBContext.newInstance(c);
	      Unmarshaller unmarshaller = context.createUnmarshaller();
	      Object obj = c.newInstance();
	       obj = unmarshaller.unmarshal(file);
	      System.out.println(obj);
	      return obj; 
	  }
}
