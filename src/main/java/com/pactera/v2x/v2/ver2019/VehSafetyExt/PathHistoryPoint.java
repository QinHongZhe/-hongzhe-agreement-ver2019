package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class PathHistoryPoint {
  @NotNull
  @Component(0)
  public PositionOffsetLLV llvOffset;
  
  @NotNull
  @Component(1)
  public Integer timeOffset;
  
  @Null
  @Component(2)
  public Integer speed;
  
  @Null
  @Component(3)
  public PositionConfidenceSet posAccuracy;
  
  @Null
  @Component(4)
  public Integer heading;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PathHistoryPoint))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PathHistoryPoint per_decode(boolean align, InputStream in) throws IOException {
    return (PathHistoryPoint)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327734);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PathHistoryPoint.class);
  
  static {
    CompositeConverter compositeConverter1 = PositionOffsetLLV.CONV;
    AsnConverter timeOffsetConverter = TimeOffset.CONV;
    AsnConverter speedConverter = Speed.CONV;
    CompositeConverter compositeConverter2 = PositionConfidenceSet.CONV;
    AsnConverter headingConverter = CoarseHeading.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, timeOffsetConverter, speedConverter, (AsnConverter)compositeConverter2, headingConverter });
  }
}
