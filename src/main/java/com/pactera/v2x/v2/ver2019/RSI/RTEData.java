package com.pactera.v2x.v2.ver2019.RSI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class RTEData {
  @NotNull
  @Min(0L)
  @Max(255L)
  @Component(0)
  public Integer rteId;
  
  @NotNull
  @Component(1)
  public Integer eventType;
  
  @NotNull
  @Component(2)
  public EventSource eventSource;
  
  @Null
  @Component(3)
  public PositionOffsetLLV eventPos;
  
  @Null
  @Component(4)
  public Integer eventRadius;
  
  @Null
  @Component(5)
  public Description description;
  
  @Null
  @Component(6)
  public RSITimeDetails timeDetails;
  
  @Null
  @Component(7)
  public byte[] priority;
  
  @Null
  @Component(8)
  public Vector<ReferencePath> referencePaths;
  
  @Null
  @Component(9)
  public Vector<ReferenceLink> referenceLinks;
  
  @Null
  @Component(10)
  public Integer eventConfidence;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RTEData))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RTEData per_decode(boolean align, InputStream in) throws IOException {
    return (RTEData)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65580);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RTEData.class);
  
  static {
    IntegerConverter integerConverter = IntegerConverter.INSTANCE;
    AsnConverter eventTypeConverter = EventType.CONV;
    AsnConverter eventSourceConverter = EventSource.CONV;
    CompositeConverter compositeConverter1 = PositionOffsetLLV.CONV;
    AsnConverter eventRadiusConverter = Radius.CONV;
    ChoiceConverter choiceConverter = Description.CONV;
    CompositeConverter compositeConverter2 = RSITimeDetails.CONV;
    AsnConverter priorityConverter = RSIPriority.CONV;
    AsnConverter referencePathsConverter = ReferencePathList.CONV;
    AsnConverter referenceLinksConverter = ReferenceLinkList.CONV;
    AsnConverter eventConfidenceConverter = Confidence.CONV;
    CONV.setComponentConverters(new AsnConverter[] { 
          (AsnConverter)integerConverter, eventTypeConverter, eventSourceConverter, (AsnConverter)compositeConverter1, eventRadiusConverter, (AsnConverter)choiceConverter, (AsnConverter)compositeConverter2, priorityConverter, referencePathsConverter, referenceLinksConverter, 
          eventConfidenceConverter });
  }
}
