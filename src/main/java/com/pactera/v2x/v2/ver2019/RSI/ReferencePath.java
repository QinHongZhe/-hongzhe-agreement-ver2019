package com.pactera.v2x.v2.ver2019.RSI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class ReferencePath {
  @NotNull
  @Component(0)
  public Vector<PositionOffsetLLV> activePath;
  
  @NotNull
  @Component(1)
  public Integer pathRadius;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ReferencePath))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static ReferencePath per_decode(boolean align, InputStream in) throws IOException {
    return (ReferencePath)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65571);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(ReferencePath.class);
  
  static {
    AsnConverter activePathConverter = PathPointList.CONV;
    AsnConverter pathRadiusConverter = Radius.CONV;
    CONV.setComponentConverters(new AsnConverter[] { activePathConverter, pathRadiusConverter });
  }
}
