package com.pactera.v2x.v2.ver2019.RSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum ElevationConfidence {
  unavailable(0),
  elev_500_00(1),
  elev_200_00(2),
  elev_100_00(3),
  elev_050_00(4),
  elev_020_00(5),
  elev_010_00(6),
  elev_005_00(7),
  elev_002_00(8),
  elev_001_00(9),
  elev_000_50(10),
  elev_000_20(11),
  elev_000_10(12),
  elev_000_05(13),
  elev_000_02(14),
  elev_000_01(15);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  ElevationConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ElevationConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (ElevationConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = RSM.type(262175);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(ElevationConfidence.class);
  }
}
