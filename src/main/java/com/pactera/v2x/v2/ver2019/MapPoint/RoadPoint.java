package com.pactera.v2x.v2.ver2019.MapPoint;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class RoadPoint {
  @NotNull
  @Component(0)
  public PositionOffsetLLV posOffset;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RoadPoint))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RoadPoint per_decode(boolean align, InputStream in) throws IOException {
    return (RoadPoint)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapPoint.type(196634);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RoadPoint.class);
  
  static {
    CompositeConverter compositeConverter = PositionOffsetLLV.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter });
  }
}
