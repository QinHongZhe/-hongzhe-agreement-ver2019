package com.pactera.v2x.v2.ver2019.BSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum SpeedConfidence {
  unavailable(0),
  prec100ms(1),
  prec10ms(2),
  prec5ms(3),
  prec1ms(4),
  prec0_1ms(5),
  prec0_05ms(6),
  prec0_01ms(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SpeedConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SpeedConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (SpeedConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(327700);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(SpeedConfidence.class);
  }
}
