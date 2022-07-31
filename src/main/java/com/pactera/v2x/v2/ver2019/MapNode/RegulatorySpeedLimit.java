package com.pactera.v2x.v2.ver2019.MapNode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class RegulatorySpeedLimit {
  @NotNull
  @Component(0)
  public SpeedLimitType type;
  
  @NotNull
  @Component(1)
  public Integer speed;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RegulatorySpeedLimit))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RegulatorySpeedLimit per_decode(boolean align, InputStream in) throws IOException {
    return (RegulatorySpeedLimit)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(262156);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RegulatorySpeedLimit.class);
  
  static {
    AsnConverter typeConverter = SpeedLimitType.CONV;
    AsnConverter speedConverter = Speed.CONV;
    CONV.setComponentConverters(new AsnConverter[] { typeConverter, speedConverter });
  }
}
