package com.pactera.v2x.v2.ver2019.SPATIntersectionState;

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

public class TimeCountingDown {
  @NotNull
  @Component(0)
  public Integer startTime;
  
  @Null
  @Component(1)
  public Integer minEndTime;
  
  @Null
  @Component(2)
  public Integer maxEndTime;
  
  @NotNull
  @Component(3)
  public Integer likelyEndTime;
  
  @Null
  @Component(4)
  public Integer timeConfidence;
  
  @Null
  @Component(5)
  public Integer nextStartTime;
  
  @Null
  @Component(6)
  public Integer nextDuration;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof TimeCountingDown))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static TimeCountingDown per_decode(boolean align, InputStream in) throws IOException {
    return (TimeCountingDown)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65542);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(TimeCountingDown.class);
  
  static {
    AsnConverter startTimeConverter = TimeMark.CONV;
    AsnConverter minEndTimeConverter = TimeMark.CONV;
    AsnConverter maxEndTimeConverter = TimeMark.CONV;
    AsnConverter likelyEndTimeConverter = TimeMark.CONV;
    AsnConverter timeConfidenceConverter = Confidence.CONV;
    AsnConverter nextStartTimeConverter = TimeMark.CONV;
    AsnConverter nextDurationConverter = TimeMark.CONV;
    CONV.setComponentConverters(new AsnConverter[] { startTimeConverter, minEndTimeConverter, maxEndTimeConverter, likelyEndTimeConverter, timeConfidenceConverter, nextStartTimeConverter, nextDurationConverter });
  }
}
