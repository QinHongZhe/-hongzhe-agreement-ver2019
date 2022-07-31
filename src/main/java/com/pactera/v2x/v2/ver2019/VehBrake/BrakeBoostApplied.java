package com.pactera.v2x.v2.ver2019.VehBrake;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum BrakeBoostApplied {
  unavailable(0),
  off(1),
  on(2);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  BrakeBoostApplied(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakeBoostApplied per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeBoostApplied)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehBrake.type(65542);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(BrakeBoostApplied.class);
  }
}
