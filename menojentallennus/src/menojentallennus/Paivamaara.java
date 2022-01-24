package menojentallennus;
/**
 * P‰iv‰m‰‰r‰ luokkaa k‰ytet‰‰n menojen paivamaara tiedon lis‰yksess‰
 * Muutetaan k‰ytt‰j‰n Stringina antama p‰iv‰m‰‰r‰ Paivamaara typpiseksi
 * */
public class Paivamaara {
	private int paiva;
	private int kuukausi;
	private int vuosi;
	public int getPaiva() {
		return paiva;
	}
	public void setPaiva(int paiva) {
		this.paiva = paiva;
	}
	public int getKuukausi() {
		return kuukausi;
	}
	public void setKuukausi(int kuukausi) {
		this.kuukausi = kuukausi;
	}
	public int getVuosi() {
		return vuosi;
	}
	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	
	public Paivamaara() {}
	
	public Paivamaara(String paivamaara) {
		this.paiva=Integer.parseInt(paivamaara.substring(0,paivamaara.indexOf(".")));
		this.kuukausi=Integer.parseInt(paivamaara.substring(paivamaara.indexOf(".")+1,paivamaara.lastIndexOf(".")));
		this.vuosi=Integer.parseInt(paivamaara.substring(paivamaara.lastIndexOf(".")+1,paivamaara.length()));
	}
	
	@Override
	public String toString() {
		return paiva + "." + kuukausi + "." + vuosi;
	}
}
