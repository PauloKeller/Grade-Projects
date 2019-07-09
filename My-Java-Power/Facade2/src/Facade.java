import java.util.Iterator;
import java.util.List;


public class Facade {
	
	private Inventory inventory;
	
	public Facade(){
		inventory = new Inventory();
	}
	
	
	public void initializeInventory(){
		
		inventory.addInstrument("11277", 3999.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
			                     Wood.ALDER, Wood.ALDER), InstrumentType.GUITAR);
	    inventory.addInstrument("V95693", 1499.95, 
			      new MandolinSpec(Builder.COLLINGS, "BBB", Type.ELECTRIC, Style.A, 
			    		  Wood.ALDER, Wood.ALDER), InstrumentType.MANDOLIN);
	    inventory.addInstrument("B111", 499.95, 
			    	      new BassSpec(Builder.FENDER, "BAIXO", Type.ELECTRIC, 24,
			                      Wood.ALDER, Wood.ALDER), InstrumentType.BASS);
		
	}
	
	public void testSearch(InstrumentSpec iSpec){
		
		List instrumentoslist1 = inventory.search(iSpec);
	    if (!instrumentoslist1.isEmpty()) {
	      System.out.println("Foram encontrados os instrumentos:");
	      for (Iterator i = instrumentoslist1.iterator(); i.hasNext(); ) {
	        Instrument instrumento1 = (Instrument)i.next();
	        InstrumentSpec spec = instrumento1.getSpec();
	        System.out.println("Instrumento:" + instrumento1.getInstrumentType() + "\n" +
	          spec.getBuilder() + " " + spec.getModel() + " " +
	          spec.getType() + " guitar:\n     " +
	          spec.getBackWood() + " madeira das costas e laterais\n     " +
	          spec.getTopWood() + " madeira da frente.\nVocê pode comprá-la por R$" +
	          instrumento1.getPrice());
	        if(spec instanceof GuitarSpec){
	        	GuitarSpec g = (GuitarSpec)spec;
	        	System.out.println("numero de cordas "+g.getNumStrings());
	        } else if(spec instanceof MandolinSpec){
	        	MandolinSpec m = (MandolinSpec)spec;
	        	System.out.println("style "+m.getStyle());
	        } else {
	        	BassSpec b = (BassSpec)spec;
	        	System.out.println("numero de trastes "+b.getTamanho());
	        }
	      }
	    } else {
	      System.out.println("Nenuma guitarra encontrada");
	    }
		
	}
	

}
