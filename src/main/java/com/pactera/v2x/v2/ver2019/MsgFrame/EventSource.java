package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum EventSource {
  unknown(0),
  police(1),
  government(2),
  meteorological(3),
  internet(4),
  detection(5);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  EventSource(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static EventSource per_decode(boolean align, InputStream in) throws IOException {
    return (EventSource)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MsgFrame.type(1507476);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(EventSource.class);
  }
}
