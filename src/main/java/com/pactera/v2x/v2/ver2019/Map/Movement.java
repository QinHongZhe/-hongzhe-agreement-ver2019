package com.pactera.v2x.v2.ver2019.Map;

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

public class Movement {
  @NotNull
  @Component(0)
  public NodeReferenceID remoteIntersection;
  
  @Null
  @Component(1)
  public Integer phaseId;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Movement))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Movement per_decode(boolean align, InputStream in) throws IOException {
    return (Movement)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = Map.type(327725);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Movement.class);
  
  static {
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter phaseIdConverter = PhaseID.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter, phaseIdConverter });
  }
}
