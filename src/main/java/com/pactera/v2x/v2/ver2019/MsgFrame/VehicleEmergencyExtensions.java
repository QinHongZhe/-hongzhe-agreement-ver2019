package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class VehicleEmergencyExtensions {
  @Null
  @Component(0)
  public ResponseType responseType;
  
  @Null
  @Component(1)
  public SirenInUse sirenUse;
  
  @Null
  @Component(2)
  public LightbarInUse lightsUse;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleEmergencyExtensions))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static VehicleEmergencyExtensions per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleEmergencyExtensions)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(852053);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(VehicleEmergencyExtensions.class);
  
  static {
    AsnConverter responseTypeConverter = ResponseType.CONV;
    AsnConverter sirenUseConverter = SirenInUse.CONV;
    AsnConverter lightsUseConverter = LightbarInUse.CONV;
    CONV.setComponentConverters(new AsnConverter[] { responseTypeConverter, sirenUseConverter, lightsUseConverter });
  }
}
