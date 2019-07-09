public class Instrument {
 
  private String serialNumber;
  private double price;
  private InstrumentSpec spec;
  private InstrumentType instrumentType;

  public Instrument(String serialNumber, double price, InstrumentSpec spec, InstrumentType it) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
    this.instrumentType = it; 
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public InstrumentSpec getSpec() {
    return spec;
  }
  
  public InstrumentType getInstrumentType() {
	    return instrumentType;
}
}
