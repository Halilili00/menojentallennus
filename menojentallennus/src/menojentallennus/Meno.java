package menojentallennus;
/**
 * Tämä luokka kuvaa Menoa sillä on muuttujina kategoriaNumero, joka otetaan käyytäjältä sitten saadaan sitä
 * vastaava kategoria. Sitten myös rahasumma, selite ja paivamaara ja näille kaikille setterit ja gettterit.
 * */
public class Meno {
	private int kategoriaNumero;
	private double rahasumma;
	private String selite;
	private Paivamaara paivamaara;
	//Kategoriat ovat määritelty valmiiksi niitä käyttäjä ei voi muuttaa tai lisätä
	//Myös tällä tavalla välttyy käyttäjän väärinkirjoituksista
	private String[] kategoria={"Ruoka&Juoma","Vaatteet","Asuminen","Auto", "Harrastukset&Vapaa-aika","Muu"};

	public int getKategoriaNumero() {
		return kategoriaNumero;
	}

	public void setKategoriaNumero(int kategoriaNumero) {
		this.kategoriaNumero = kategoriaNumero;
	}

	public String[] getKategoria() {
		return kategoria;
	}

	public double getRahasumma() {
		return rahasumma;
	}

	public void setRahasumma(double rahasumma) {
		this.rahasumma = rahasumma;
	}

	public String getSelite() {
		return selite;
	}

	public void setSelite(String selite) {
		this.selite = selite;
	}
	
	public Paivamaara getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(Paivamaara paivamaara) {
		this.paivamaara = paivamaara;
	}
	

	public Meno(){}
	
	public Meno(int _kategoria, double _rahasumma, String _selite, Paivamaara _paivamaara) {
		this.rahasumma = _rahasumma;
		this.selite = _selite;
		this.paivamaara = _paivamaara;
	}

	public StringBuilder getKategoriat() {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=kategoria.length; i++) {
			sb.append( i + ". " +kategoria[i-1] + " ");
		}
		return sb;
	}
	@Override
	public String toString() {
		return kategoria[getKategoriaNumero()-1] + "\t" + rahasumma + "\t" + selite + "\t" + paivamaara;
	}
}
