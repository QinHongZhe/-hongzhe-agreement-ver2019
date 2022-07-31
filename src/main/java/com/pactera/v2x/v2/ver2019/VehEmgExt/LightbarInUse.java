package com.pactera.v2x.v2.ver2019.VehEmgExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum LightbarInUse {
  unavailable(0),
  notInUse(1),
  inUse(2),
  yellowCautionLights(3),
  schooldBusLights(4),
  arrowSignsActive(5),
  slowMovingVehicle(6),
  freqStops(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  LightbarInUse(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LightbarInUse per_decode(boolean align, InputStream in) throws IOException {
    return (LightbarInUse)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehEmgExt.type(65539);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(LightbarInUse.class);
  }
}
