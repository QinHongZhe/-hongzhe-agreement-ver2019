package com.pactera.v2x.v2.ver2019.RSI;

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

public class ReferenceLink {
  @NotNull
  @Component(0)
  public NodeReferenceID upstreamNodeId;
  
  @NotNull
  @Component(1)
  public NodeReferenceID downstreamNodeId;
  
  @Null
  @Component(2)
  public ReferenceLanes referenceLanes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ReferenceLink))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static ReferenceLink per_decode(boolean align, InputStream in) throws IOException {
    return (ReferenceLink)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65577);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(ReferenceLink.class);
  
  static {
    CompositeConverter compositeConverter1 = NodeReferenceID.CONV;
    CompositeConverter compositeConverter2 = NodeReferenceID.CONV;
    AsnConverter referenceLanesConverter = ReferenceLanes.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, referenceLanesConverter });
  }
}
