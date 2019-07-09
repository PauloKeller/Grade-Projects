public class BassSpec extends InstrumentSpec {
 
  private int tamanho;

  public BassSpec(Builder builder, String model, Type type,
                    int numStrings, Wood backWood, Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.tamanho = numStrings;
  }

  public int getTamanho() {
    return tamanho;
  }

  // Override the superclass matches()
  public boolean matches(InstrumentSpec otherSpec) {
    if (!super.matches(otherSpec)) 
      return false;
    if (!(otherSpec instanceof BassSpec))
      return false;
    BassSpec spec = (BassSpec)otherSpec;
    if (tamanho != spec.tamanho) 
      return false;
    return true;
  }
}
