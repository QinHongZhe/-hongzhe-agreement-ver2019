package com.pactera.v2x.v2.ver2019.RSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum SourceType {
  unknown(0),
  selfinfo(1),
  v2x(2),
  video(3),
  microwaveRadar(4),
  loop(5),
  lidar(6),
  integrated(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SourceType(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SourceType per_decode(boolean align, InputStream in) throws IOException {
    return (SourceType)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = RSM.type(65538);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(SourceType.class);
  }
}
