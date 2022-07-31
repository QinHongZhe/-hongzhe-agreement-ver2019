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

public class RTSData {
  @NotNull
  @Min(0L)
  @Max(255L)
  @Component(0)
  public Integer rtsId;
  
  @NotNull
  @Component(1)
  public Integer signType;
  
  @Null
  @Component(2)
  public PositionOffsetLLV signPos;
  
  @Null
  @Component(3)
  public Description description;
  
  @Null
  @Component(4)
  public RSITimeDetails timeDetails;
  
  @Null
  @Component(5)
  public byte[] priority;
  
  @Null
  @Component(6)
  public Vector<ReferencePath> referencePaths;
  
  @Null
  @Component(7)
  public Vector<ReferenceLink> referenceLinks;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RTSData))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RTSData per_decode(boolean align, InputStream in) throws IOException {
    return (RTSData)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65583);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RTSData.class);
  
  static {
    IntegerConverter integerConverter = IntegerConverter.INSTANCE;
    AsnConverter signTypeConverter = SignType.CONV;
    CompositeConverter compositeConverter1 = PositionOffsetLLV.CONV;
    ChoiceConverter choiceConverter = Description.CONV;
    CompositeConverter compositeConverter2 = RSITimeDetails.CONV;
    AsnConverter priorityConverter = RSIPriority.CONV;
    AsnConverter referencePathsConverter = ReferencePathList.CONV;
    AsnConverter referenceLinksConverter = ReferenceLinkList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)integerConverter, signTypeConverter, (AsnConverter)compositeConverter1, (AsnConverter)choiceConverter, (AsnConverter)compositeConverter2, priorityConverter, referencePathsConverter, referenceLinksConverter });
  }
}
