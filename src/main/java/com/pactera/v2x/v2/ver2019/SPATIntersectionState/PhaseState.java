package com.pactera.v2x.v2.ver2019.SPATIntersectionState;

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

public class PhaseState {
  @NotNull
  @Component(0)
  public LightState light;
  
  @Null
  @Component(1)
  public TimeChangeDetails timing;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PhaseState))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PhaseState per_decode(boolean align, InputStream in) throws IOException {
    return (PhaseState)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65545);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PhaseState.class);
  
  static {
    AsnConverter lightConverter = LightState.CONV;
    ChoiceConverter choiceConverter = TimeChangeDetails.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lightConverter, (AsnConverter)choiceConverter });
  }
}
