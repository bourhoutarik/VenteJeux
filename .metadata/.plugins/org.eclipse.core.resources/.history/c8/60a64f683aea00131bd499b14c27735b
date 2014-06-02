

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {
	private ListeClient liste = null;
	private String[] listEntete = Jeux.TabNomChamp();
	private Object[][] data = null;
	
	public ModelTable() {
	}

	public ModelTable(ListeClient liste) {
		this.liste = liste;
		this.conversionListTableau();
	}

	@Override
	public int getColumnCount() {
		return listEntete.length;
	}

	@Override
	public int getRowCount() {
		return liste.getClients().size();
	}
	
	// Retourne le contenu de la cellule du tableau
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}
	
	// Retourne une ligne du tableau
	public Object getValue(int row) {
		return this.liste.getClients().get(row);
	}
	
	// Changer le contenu d'une cellule du tableau
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		super.setValueAt(arg0, arg1, arg2);
		fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int column) {
		return listEntete[column];
	}
    
	public boolean isCellEditable(int row,int col){
		if(col==0 || col ==3){
		return false;
		}
		return true;
	}
	private void conversionListTableau(){
		List<Jeux> list = liste.getClients(); //Recuperation de l'arraylist de la classe Client
		data = new Object[this.getRowCount()][this.getColumnCount()];
		int i = 0;
		// SimpleDateFormat est utilisé pour transformer une Date en String
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for (Jeux c : list){
			data[i][0] = c.getIdJeux();
			data[i][1] = c.getNom();
			data[i][2] = c.getNumserie();
			data[i][3]=c.getPrix();
			// la méthode format permet de formater la Date
			data[i][4] = c.getDescription();
			//data[i][4] = (c.isSexe()) ? "Femme" : "Homme"; // if ternaire
			// System.out.println(c.nbAttributs());
			// System.out.println(Arrays.toString(c.TabNomChamp()));
			i++;		
		}
	}
}
