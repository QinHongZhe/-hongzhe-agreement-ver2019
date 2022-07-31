package com.pactera.v2x.v2.ver2019.SignalPhaseAndTiming;

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

public class UTCTiming {
  @NotNull
  @Component(0)
  public Integer startUTCTime;
  
  @Null
  @Component(1)
  public Integer minEndUTCTime;
  
  @Null
  @Component(2)
  public Integer maxEndUTCTime;
  
  @NotNull
  @Component(3)
  public Integer likelyEndUTCTime;
  
  @Null
  @Component(4)
  public Integer timeConfidence;
  
  @Null
  @Component(5)
  public Integer nextStartUTCTime;
  
  @Null
  @Component(6)
  public Integer nextEndUTCTime;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof UTCTiming))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static UTCTiming per_decode(boolean align, InputStream in) throws IOException {
    return (UTCTiming)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(262166);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(UTCTiming.class);
  
  static {
    AsnConverter startUTCTimeConverter = TimeMark.CONV;
    AsnConverter minEndUTCTimeConverter = TimeMark.CONV;
    AsnConverter maxEndUTCTimeConverter = TimeMark.CONV;
    AsnConverter likelyEndUTCTimeConverter = TimeMark.CONV;
    AsnConverter timeConfidenceConverter = Confidence.CONV;
    AsnConverter nextStartUTCTimeConverter = TimeMark.CONV;
    AsnConverter nextEndUTCTimeConverter = TimeMark.CONV;
    CONV.setComponentConverters(new AsnConverter[] { startUTCTimeConverter, minEndUTCTimeConverter, maxEndUTCTimeConverter, likelyEndUTCTimeConverter, timeConfidenceConverter, nextStartUTCTimeConverter, nextEndUTCTimeConverter });
  }
}
