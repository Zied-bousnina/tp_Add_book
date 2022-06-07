package application;

import java.util.*;


public class DataClass {

	private List<Person> importList;
	private List<Person> exportList;
	private PersonneService ps;
	public DataClass() {
		// TODO Auto-generated constructor stub
		
		importList = new ArrayList<Person>();
//		importList.add(new Person(1,"sami", "benAli", "sami@exemple.com"));
//		importList.add(new Person(2,"Alia", "BenSalah", "ALIA@exemple.com"));
//		importList.add(new Person(3,"Ali", "benSalahAli", "ALI@exemple.com"));
		importList = ps.findAll();
		exportList = new ArrayList<Person>();
		
		
		
		
	}

	/**
	 * @return the importList
	 */
	public List<Person> getImportList() {
		return importList;
	}

	

	/**
	 * @return the exportList
	 */
	public List<Person> getExportList() {
		return exportList;
	}

	
	public void setExportList(List<Person> exportList) {
		this.exportList.addAll(exportList);
		   for(Person p: this.exportList) {
			   System.out.println(p);
		   }
	}

}
