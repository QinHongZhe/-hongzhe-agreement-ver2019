package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class VehicleSafetyExtensions {
  @Null
  @Component(0)
  public VehicleEventFlags events;
  
  @Null
  @Component(1)
  public PathHistory pathHistory;
  
  @Null
  @Component(2)
  public PathPrediction pathPrediction;
  
  @Null
  @Component(3)
  public ExteriorLights lights;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleSafetyExtensions))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static VehicleSafetyExtensions per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleSafetyExtensions)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327742);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(VehicleSafetyExtensions.class);
  
  static {
    AsnConverter eventsConverter = VehicleEventFlags.CONV;
    CompositeConverter compositeConverter1 = PathHistory.CONV;
    CompositeConverter compositeConverter2 = PathPrediction.CONV;
    AsnConverter lightsConverter = ExteriorLights.CONV;
    CONV.setComponentConverters(new AsnConverter[] { eventsConverter, (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, lightsConverter });
  }
}
