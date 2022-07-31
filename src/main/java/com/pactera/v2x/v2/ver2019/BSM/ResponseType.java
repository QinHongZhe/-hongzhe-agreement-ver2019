package com.pactera.v2x.v2.ver2019.BSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum ResponseType {
  notInUseOrNotEquipped(0),
  emergency(1),
  nonEmergency(2),
  pursuit(3),
  stationary(4),
  slowMoving(5),
  stopAndGoMovement(6);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  ResponseType(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ResponseType per_decode(boolean align, InputStream in) throws IOException {
    return (ResponseType)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(786517);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(ResponseType.class);
  }
}
