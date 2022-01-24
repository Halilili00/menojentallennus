package menojentallennus;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * T‰ss‰ luokassa kirjoitetaan tiedostoon k‰ytt‰j‰lt‰ saadut tiedot ja sen j‰lkeen tehd‰‰n hakuja tiedosta.
 * Pystyt‰‰n lukemaan ja tulostamaan koko tiedosto, hakemaan tieto p‰iv‰m‰‰r‰n persuteella ja hakemaan kuinka
 * paljon menoja on yhteens‰ kaikilta p‰ivilt‰ kussakin kategoriassa. 
 * */
public class TiedostonHallinta extends Meno{
	
	public void kijoitaTiedostoon(ArrayList<Meno> m) {
		try {
			FileWriter myFile = new FileWriter("data.txt",true);
			for(int i=0; i<m.size(); i++) {
				myFile.write(m.get(i).toString()+"\n");
			}
			myFile.close();
			System.out.println("Kirjoitettu tiedostoon");
		}
		catch (Exception e) {
			System.out.println("An error");
		}
	}
	
	public void lueKokoTiedosto() {
		 try {
		      File myObj = new File("data.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		    }
	}
	
	public void haeTiedostostaPaivamaaralla(String haettupaivamaara) {
		try {
		      File myObj = new File("data.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        StringTokenizer st = new StringTokenizer(data,"\t");
		        st.nextToken();
		        st.nextToken();
		        st.nextToken();
		        if(st.nextToken().equals(haettupaivamaara)) {
		        	System.out.println(data);
		        }
		      }
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		    }
	}
	//T‰m‰ metodi tulostaa kunkin kategorian arvon yhteens‰, jota k‰ytet‰‰n pyv‰skaavaiota luodassa 
	public double[] lueTiedostostaKategorioidenSummat() {
		 try {
		      File myObj = new File("data.txt");
		      Scanner myReader = new Scanner(myObj);
		      Meno mm = new Meno();
		      String [] kategoriat = mm.getKategoria();
		      double [] summat= new double[mm.getKategoria().length];
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        StringTokenizer st = new StringTokenizer(data,"\t");
	        	String kategoria = st.nextToken();
	        	setRahasumma(Double.parseDouble(st.nextToken()));
	        	for(int i=0; i<kategoriat.length; i++) {
	        		if(kategoriat[i].equals(kategoria)) {
			        	summat[i] += getRahasumma();
			        }
	        	}
		      }
		      return summat;
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		    }
		return null;
	}

}
