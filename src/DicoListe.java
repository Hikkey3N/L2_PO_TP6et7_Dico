public class DicoListe extends Dico{
	//Create Element
	private class Element{
		public static final String Element = null;
		String cle;
		String valeur;
		Element next = null;
		
		public Element(String cle, String valeur, Element next) {
			this.cle = cle;
			this.valeur = valeur;
			this.next = next;
		}
	}
	
	//Class Paire and functions around Paire:
	public class Paire{
		String cle;
		String valeur;
		
		public Paire(String cle, String valeur) {
			this.cle = cle;
			this.valeur = valeur;
		}
	}
	
	public Paire getPaire(Element e) {
		Paire output = new Paire(e.cle, e.valeur);
		return output;
	}


	public boolean checkingPaire(Paire p, Element e) {
		if (e != null){
			boolean checking = ((p.valeur).compareTo(e.valeur) == 0 && (p.cle).compareTo(e.cle) == 0);
			if (checking) {
				return checking;
			}
			else {
				checkingPaire(p, e.next);
			}
			return checking;
		}
		return false;
	}
	

	//Assosie
	private Element head;
	public DicoListe(){
		this.head = null;
	}
	
	@Override
	public void associe(String cle, String valeur) {
		// TODO Auto-generated method stub
		Paire p = new Paire(cle, valeur);

		if (head != null) {
			boolean checking = checkingPaire(p, head);
			if (!checking){
				Element newElement = new Element(cle, valeur, null);
				head = new Element(head.cle, head.valeur, newElement);
			}
		}
		else {
			head = new Element(cle, valeur, null);
		}
	}
	
	
	//Supprimer
	public boolean checkingCle(String cle, Element e) {
		boolean checking = ((e.cle).compareTo(cle) == 0);
		if (checking || e == null) {
			return checking;
		}
		else{
			checkingCle(cle, e.next);
		}
		return checking;
	}
	
	@Override
	public void supprime(String cle) {
		// TODO Auto-generated method stub
		boolean checking = false;
		Element newTail;
		while ((head.next != null) || (!checking)){
			if((head.next.cle).compareTo(cle) == 0){
				newTail = head.next.next;
				head.next = newTail;
				checking = true;
			}
		}
	}


	@Override
	public String get(String cle) {
		// TODO Auto-generated method stub
		Element temp = head;
		while((temp != null)){
			if ((temp.cle).compareTo(cle) == 0){
				return ("With the key: " + cle + ", we have the value: " + temp.valeur);
			}
			else{
				temp = temp.next;
			}
		}
		return null;
	}


}
