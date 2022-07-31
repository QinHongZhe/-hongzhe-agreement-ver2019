package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class AccelerationSet4Way {
  @NotNull
  @Component(0)
  public Integer long_;
  
  @NotNull
  @Component(1)
  public Integer lat;
  
  @NotNull
  @Component(2)
  public Integer vert;
  
  @NotNull
  @Component(3)
  public Integer yaw;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof AccelerationSet4Way))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static AccelerationSet4Way per_decode(boolean align, InputStream in) throws IOException {
    return (AccelerationSet4Way)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(458776);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(AccelerationSet4Way.class);
  
  static {
    AsnConverter long_Converter = Acceleration.CONV;
    AsnConverter latConverter = Acceleration.CONV;
    AsnConverter vertConverter = VerticalAcceleration.CONV;
    AsnConverter yawConverter = YawRate.CONV;
    CONV.setComponentConverters(new AsnConverter[] { long_Converter, latConverter, vertConverter, yawConverter });
  }
}
