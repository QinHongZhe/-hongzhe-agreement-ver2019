package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum SteeringWheelAngleConfidence {
  unavailable(0),
  prec2deg(1),
  prec1deg(2),
  prec0_02deg(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SteeringWheelAngleConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SteeringWheelAngleConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (SteeringWheelAngleConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehSafetyExt.type(196635);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(SteeringWheelAngleConfidence.class);
  }
}
