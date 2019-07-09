import java.util.Iterator;
import java.util.List;

public class FindInstrumentTester {

  public static void main(String[] args) {
    
    Facade f = new Facade();
    
    f.initializeInventory();

    f.testSearch(new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
			                     Wood.ALDER, Wood.ALDER));
    
    f.testSearch(new MandolinSpec(Builder.COLLINGS, "BBB", Type.ELECTRIC, Style.A, 
			    		  Wood.ALDER, Wood.ALDER));
    
    f.testSearch(new BassSpec(Builder.FENDER, "BAIXO", Type.ELECTRIC, 24,
			                      Wood.ALDER, Wood.ALDER));
    
    f.testSearch(new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6,
    		Wood.CEDAR, Wood.BRAZILIAN_ROSEWOOD));
    
  }

 
}
