package collections;

import java.util.HashSet;
import java.util.Set;

public class UserAccounts {

	public static void main(String[] args) {

		Client client1= new Client("Leo", "0001", 2000);
		Client client2= new Client("Juan", "00013", 6500);
		Client client3= new Client("Carla", "00015", 6032);
		Client client4= new Client("Mario", "00013", 1590); 
		Client client5= new Client("julia", "00313", 1590);  


		// in this case we will assume that the client cannot be duplicate. 
		// We are gonna use Set collection
		
		Set <Client> bankClient= new HashSet<Client>();
		
		bankClient.add(client1);
		bankClient.add(client2);
		bankClient.add(client3);
		bankClient.add(client4);
		
		for (Client client : bankClient) {
			System.out.println(client.getName() + " " + client.getNumberAcc() + " " + client.getSalary());
		}
		System.out.println(bankClient.size());  // 3, means that MARIO is not added to the set bankClient variable
	}

}
