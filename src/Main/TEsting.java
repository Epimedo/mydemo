package Main;
import java.io.IOException;
import java.lang.reflect.Proxy;

import javax.xml.bind.JAXBException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import com.mybank.controller.ForCustomer;
import com.mybank.domain.Account;
import com.mybank.domain.Customer;
import com.mybank.inter.CreatingProxyForObject;
import com.mybank.inter.Individuals;

import view.BankChatRoom;
/**
 * 
 * @author Halavin Egor
 * @version 1.0
 */
public class TEsting {


	public static void main(String[] args) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, MarshalException, ValidationException {
		Customer customer = new Customer();
		customer.setAccount(new Account(100));
		customer.setAccount(new Account(200));
		/*ForCustomer.setCustomer(customer);
		BankChatRoom.main(args);
	    */
	    
	}

}
