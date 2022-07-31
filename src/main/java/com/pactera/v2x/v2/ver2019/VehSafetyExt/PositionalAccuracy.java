package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class PositionalAccuracy {
  @NotNull
  @Component(0)
  public Integer semiMajor;
  
  @NotNull
  @Component(1)
  public Integer semiMinor;
  
  @NotNull
  @Component(2)
  public Integer orientation;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PositionalAccuracy))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PositionalAccuracy per_decode(boolean align, InputStream in) throws IOException {
    return (PositionalAccuracy)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(131088);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PositionalAccuracy.class);
  
  static {
    AsnConverter semiMajorConverter = SemiMajorAxisAccuracy.CONV;
    AsnConverter semiMinorConverter = SemiMinorAxisAccuracy.CONV;
    AsnConverter orientationConverter = SemiMajorAxisOrientation.CONV;
    CONV.setComponentConverters(new AsnConverter[] { semiMajorConverter, semiMinorConverter, orientationConverter });
  }
}
