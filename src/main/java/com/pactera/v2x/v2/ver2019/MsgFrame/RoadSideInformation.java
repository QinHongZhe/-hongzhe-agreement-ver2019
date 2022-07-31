package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class RoadSideInformation {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @Null
  @Component(1)
  public Integer moy;
  
  @NotNull
  @Size(min = 8, max = 8)
  @Component(2)
  public byte[] id;
  
  @NotNull
  @Component(3)
  public Position3D refPos;
  
  @Null
  @Component(4)
  public Vector<RTEData> rtes;
  
  @Null
  @Component(5)
  public Vector<RTSData> rtss;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RoadSideInformation))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RoadSideInformation per_decode(boolean align, InputStream in) throws IOException {
    return (RoadSideInformation)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1507472);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RoadSideInformation.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    AsnConverter moyConverter = MinuteOfTheYear.CONV;
    OctetStringConverter octetStringConverter = OctetStringConverter.INSTANCE;
    CompositeConverter compositeConverter = Position3D.CONV;
    AsnConverter rtesConverter = RTEList.CONV;
    AsnConverter rtssConverter = RTSList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { msgCntConverter, moyConverter, (AsnConverter)octetStringConverter, (AsnConverter)compositeConverter, rtesConverter, rtssConverter });
  }
}
