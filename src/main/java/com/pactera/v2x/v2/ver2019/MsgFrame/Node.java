package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class Node {
  @Null
  @Component(0)
  public String name;
  
  @NotNull
  @Component(1)
  public NodeReferenceID id;
  
  @NotNull
  @Component(2)
  public Position3D refPos;
  
  @Null
  @Component(3)
  public Vector<Link> inLinks;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Node))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Node per_decode(boolean align, InputStream in) throws IOException {
    return (Node)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(983132);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Node.class);
  
  static {
    AsnConverter nameConverter = DescriptiveName.CONV;
    CompositeConverter compositeConverter1 = NodeReferenceID.CONV;
    CompositeConverter compositeConverter2 = Position3D.CONV;
    AsnConverter inLinksConverter = LinkList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { nameConverter, (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, inLinksConverter });
  }
}
