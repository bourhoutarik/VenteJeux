import java.lang.reflect.Field;


public class Jeux {

	private int IdJeux;
	private String nom;
	private String numserie;
	private int prix;
	private String description;
	
	public Jeux(){
		
	}

	public int getIdJeux() {
		return IdJeux;
	}

	public void setIdJeux(int idJeux) {
		IdJeux = idJeux;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumserie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int string) {
		this.prix = string;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static String[] TabNomChamp(){
		Field[] tabFields = Jeux.class.getDeclaredFields();
		String[] tabString = new String[tabFields.length];
		for (int i = 0; i < tabFields.length; i++) {
			tabString[i] = tabFields[i].getName().toUpperCase();
		}
		return tabString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdJeux;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((numserie == null) ? 0 : numserie.hashCode());
		result = prime * result + prix;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeux other = (Jeux) obj;
		if (IdJeux != other.IdJeux)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numserie == null) {
			if (other.numserie != null)
				return false;
		} else if (!numserie.equals(other.numserie))
			return false;
		if (prix != other.prix)
			return false;
		return true;
	}
	
	
}
