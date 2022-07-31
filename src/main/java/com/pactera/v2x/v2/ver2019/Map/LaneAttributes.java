package com.pactera.v2x.v2.ver2019.Map;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class LaneAttributes {
  @Null
  @Component(0)
  public LaneSharing shareWith;
  
  @NotNull
  @Component(1)
  public LaneTypeAttributes laneType;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static LaneAttributes per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = Map.type(524338);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(LaneAttributes.class);
  
  static {
    AsnConverter shareWithConverter = LaneSharing.CONV;
    ChoiceConverter choiceConverter = LaneTypeAttributes.CONV;
    CONV.setComponentConverters(new AsnConverter[] { shareWithConverter, (AsnConverter)choiceConverter });
  }
}
