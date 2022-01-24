package menojentallennus;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 * T‰m‰ luokka on p‰‰luokka, jossa ArrayListaan tallennetaan k‰ytt‰j‰n antamat tiedot. Sen j‰lkeen tehd‰‰n
 * teht‰v‰n annossa vaatimat teht‰v‰t sen mukaan mink‰ k‰ytt‰j‰ valitsetee tai haluaa tehd‰.
 * */
public class MenotMain {
	private static ArrayList<Meno> menot = new ArrayList<Meno>();
	public static void main(String[] args) {
		MenotMain mm = new MenotMain();
		TiedostonHallinta tkl = new TiedostonHallinta();
		while(true) {
			Scanner input = new Scanner(System.in);
			int valinta;
			System.out.println("Valitse mit‰ haluat tehd‰");
			System.out.println("1. Lis‰‰ menoja\n2. Hae menot p‰iv‰m‰‰‰r‰ll‰\n"
					+ "3. Lue kaikki tiedostossa olevat tiedot\n4. N‰yt‰ pylv‰skaaviolla kustakin kategoriasta yhteenveto"
					+ "\n5. Poistu");
			valinta = input.nextInt();
			if(valinta == 5) {
				break;
			}
			switch (valinta) {
			case 1: {
				mm.lisaamenot();
				tkl.kijoitaTiedostoon(menot);
				mm.tulosta();
				menot.clear();
				break;
			}
			case 2: {
				mm.haePaivamaaralla();
				break;
			}
			case 3: {
				tkl.lueKokoTiedosto();
				break;
			}
			case 4: {
				mm.pylvaskaavioYhteenveto();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + valinta);
			}
		}
	}
	
	public void lisaamenot() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lis‰‰ p‰iv‰m‰‰r‰ (Muodossa \"pp.kk.vvvv\")");
		Paivamaara p1 = new Paivamaara(scanner.nextLine());
		String lopeta;
		do {
			Meno m1 = new Meno();
			System.out.println("Valitse yksi alla olevista kategorioista johon menosi kuuluu: ");
			System.out.println(m1.getKategoriat());
			m1.setKategoriaNumero(scanner.nextInt());
			System.out.println("rahasumma");
			m1.setRahasumma(scanner.nextDouble());
			System.out.println("selite");
			scanner.nextLine();
			m1.setSelite(scanner.nextLine());
			m1.setPaivamaara(p1);
			menot.add(m1);
			System.out.println("Haluat jatkaa menojen lis‰yst‰ y/n");
			lopeta = scanner.nextLine();
		}while(lopeta.equals("y"));
	}
	//Tulostaa viimeksi lis‰tyt menot
	public void tulosta() {
		double yhteensa =0;
		for(int i=0; i<menot.size(); i++) {
			if(menot.get(i).getPaivamaara()==menot.get(menot.size()-1).getPaivamaara()) {
				System.out.println(menot.get(i));
				yhteensa += menot.get(i).getRahasumma();
			}
		}
		System.out.println("P‰iv‰n menot yhteens‰: "+yhteensa);
	}
	
	public void haePaivamaaralla() {
		TiedostonHallinta tkl = new TiedostonHallinta();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Haettu p‰iv‰m‰‰r‰ (15.2.2021)");
		Paivamaara p1 = new Paivamaara(scanner.nextLine());
		tkl.haeTiedostostaPaivamaaralla(p1.toString());
		
	}
	
	public void pylvaskaavioYhteenveto() {
		TiedostonHallinta tkl = new TiedostonHallinta();
		JFrame f = new JFrame();
	    f.setSize(800, 500);
	    Meno me = new Meno();
	    String[] names = me.getKategoria();
	    double[] values = tkl.lueTiedostostaKategorioidenSummat();
	    for(int i=0; i<names.length;i++) {
	    	names[i] = names[i];
	    	values[i] = values[i];
	    }
	    f.getContentPane().add(new ChartPanel(values, names));

	    WindowListener wndCloser = new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	      }
	    };
	    f.addWindowListener(wndCloser);
	    f.setVisible(true);
	}
}
