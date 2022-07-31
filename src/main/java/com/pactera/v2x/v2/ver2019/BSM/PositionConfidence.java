package com.pactera.v2x.v2.ver2019.BSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum PositionConfidence {
  unavailable(0),
  a500m(1),
  a200m(2),
  a100m(3),
  a50m(4),
  a20m(5),
  a10m(6),
  a5m(7),
  a2m(8),
  a1m(9),
  a50cm(10),
  a20cm(11),
  a10cm(12),
  a5cm(13),
  a2cm(14),
  a1cm(15);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  PositionConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static PositionConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (PositionConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(196621);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(PositionConfidence.class);
  }
}
