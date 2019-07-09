import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

  private List inventory;

  public Inventory() {
    inventory = new LinkedList();
  }

  public void addInstrument(String serialNumber, double price,
                            InstrumentSpec spec, InstrumentType it) {
    Instrument instrument = null;
    instrument = new Instrument(serialNumber, price, spec, it);
    inventory.add(instrument);
  }

  public List search(InstrumentSpec searchSpec) {
    List matchingInstruments = new LinkedList();
    for (Iterator i = inventory.iterator(); i.hasNext(); ) {
      Instrument instrument = (Instrument)i.next();
      if (instrument.getSpec().matches(searchSpec))
    	  matchingInstruments.add(instrument);
    }
    return matchingInstruments;
  }
}
