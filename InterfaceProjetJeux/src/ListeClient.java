

import java.util.ArrayList;
import java.util.List;

public class ListeClient {
	private List<Jeux> clients = null;

	public ListeClient() {
		this.clients = new ArrayList();
	}

	public List<Jeux> getClients() {
		return clients;
	}

	public void ajouterClient(Jeux jeux){
		clients.add(jeux);
	}
	
	public void supprimerClient(Jeux jeux){
		if (clients.contains(jeux)) clients.remove(jeux);
	}
	
	public void effacerList(){
		clients.clear();
	}
	
	// ATTENTION, il faut redéfinir Equals et HashCode dans Client
	public boolean contientClient(Jeux jeux){
		return this.clients.contains(jeux);
	}
	
	public Jeux recupClient(int pos){
		if (pos >= 0 && pos < clients.size()){
			return this.clients.get(pos);
		}
		return null;
	}
}
