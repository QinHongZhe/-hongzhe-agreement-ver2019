package com.pactera.v2x.v2.ver2019.SignalPhaseAndTiming;

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

public class SPAT {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @Null
  @Component(1)
  public Integer moy;
  
  @Null
  @Component(2)
  public Integer timeStamp;
  
  @Null
  @Component(3)
  public String name;
  
  @NotNull
  @Component(4)
  public Vector<IntersectionState> intersections;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof SPAT))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static SPAT per_decode(boolean align, InputStream in) throws IOException {
    return (SPAT)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(393239);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(SPAT.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    AsnConverter moyConverter = MinuteOfTheYear.CONV;
    AsnConverter timeStampConverter = DSecond.CONV;
    AsnConverter nameConverter = DescriptiveName.CONV;
    AsnConverter intersectionsConverter = IntersectionStateList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { msgCntConverter, moyConverter, timeStampConverter, nameConverter, intersectionsConverter });
  }
}
