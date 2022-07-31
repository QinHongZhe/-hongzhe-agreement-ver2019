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

public class PathHistory {
  @Null
  @Component(0)
  public FullPositionVector initialPosition;
  
  @Null
  @Component(1)
  public GNSSstatus currGNSSstatus;
  
  @NotNull
  @Component(2)
  public Vector<PathHistoryPoint> crumbData;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PathHistory))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PathHistory per_decode(boolean align, InputStream in) throws IOException {
    return (PathHistory)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(720941);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PathHistory.class);
  
  static {
    CompositeConverter compositeConverter = FullPositionVector.CONV;
    AsnConverter currGNSSstatusConverter = GNSSstatus.CONV;
    AsnConverter crumbDataConverter = PathHistoryPointList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter, currGNSSstatusConverter, crumbDataConverter });
  }
}
