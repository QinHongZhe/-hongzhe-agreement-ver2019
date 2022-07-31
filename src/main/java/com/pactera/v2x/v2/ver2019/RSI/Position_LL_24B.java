package com.pactera.v2x.v2.ver2019.RSI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class Position_LL_24B {
  @NotNull
  @Component(0)
  public Integer lon;
  
  @NotNull
  @Component(1)
  public Integer lat;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Position_LL_24B))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Position_LL_24B per_decode(boolean align, InputStream in) throws IOException {
    return (Position_LL_24B)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(196619);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Position_LL_24B.class);
  
  static {
    AsnConverter lonConverter = OffsetLL_B12.CONV;
    AsnConverter latConverter = OffsetLL_B12.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lonConverter, latConverter });
  }
}
