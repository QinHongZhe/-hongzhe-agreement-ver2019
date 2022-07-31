package com.pactera.v2x.v2.ver2019.RSI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class RSITimeDetails {
  @Null
  @Component(0)
  public Integer startTime;
  
  @Null
  @Component(1)
  public Integer endTime;
  
  @Null
  @Component(2)
  public TimeConfidence endTimeConfidence;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RSITimeDetails))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RSITimeDetails per_decode(boolean align, InputStream in) throws IOException {
    return (RSITimeDetails)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65543);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RSITimeDetails.class);
  
  static {
    AsnConverter startTimeConverter = MinuteOfTheYear.CONV;
    AsnConverter endTimeConverter = MinuteOfTheYear.CONV;
    AsnConverter endTimeConfidenceConverter = TimeConfidence.CONV;
    CONV.setComponentConverters(new AsnConverter[] { startTimeConverter, endTimeConverter, endTimeConfidenceConverter });
  }
}
