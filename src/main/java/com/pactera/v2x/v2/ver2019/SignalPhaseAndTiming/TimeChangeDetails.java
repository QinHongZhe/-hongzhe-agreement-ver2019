package com.pactera.v2x.v2.ver2019.SignalPhaseAndTiming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

public class TimeChangeDetails {
  public static final int countingChosen = 0;
  
  public static final int utcTimingChosen = 1;
  
  public final int choiceID;
  
  @Alternative(0)
  public final TimeCountingDown counting;
  
  @Alternative(1)
  public final UTCTiming utcTiming;
  
  private TimeChangeDetails(int choiceID, TimeCountingDown counting, UTCTiming utcTiming) {
    this.choiceID = choiceID;
    this.counting = counting;
    this.utcTiming = utcTiming;
  }
  
  public static TimeChangeDetails counting(TimeCountingDown counting) {
    return new TimeChangeDetails(0, counting, null);
  }
  
  public static TimeChangeDetails utcTiming(UTCTiming utcTiming) {
    return new TimeChangeDetails(1, null, utcTiming);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof TimeChangeDetails))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static TimeChangeDetails per_decode(boolean align, InputStream in) throws IOException {
    return (TimeChangeDetails)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(262162);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(TimeChangeDetails.class);
  
  static {
    CompositeConverter compositeConverter1 = TimeCountingDown.CONV;
    CompositeConverter compositeConverter2 = UTCTiming.CONV;
    CONV.setAlternativeConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2 });
  }
}
