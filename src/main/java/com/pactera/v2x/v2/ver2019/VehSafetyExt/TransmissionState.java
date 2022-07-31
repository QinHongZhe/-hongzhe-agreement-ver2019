package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum TransmissionState {
  neutral(0),
  park(1),
  forwardGears(2),
  reverseGears(3),
  reserved1(4),
  reserved2(5),
  reserved3(6),
  unavailable(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  TransmissionState(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static TransmissionState per_decode(boolean align, InputStream in) throws IOException {
    return (TransmissionState)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehSafetyExt.type(262158);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(TransmissionState.class);
  }
}
