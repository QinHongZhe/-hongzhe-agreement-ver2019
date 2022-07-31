package com.pactera.v2x.v2.ver2019.VehClass;

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

public class VehicleClassification {
  @NotNull
  @Component(0)
  public Integer classification;
  
  @Null
  @Component(1)
  public Integer fuelType;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleClassification))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static VehicleClassification per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleClassification)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehClass.type(65605);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(VehicleClassification.class);
  
  static {
    AsnConverter classificationConverter = BasicVehicleClass.CONV;
    AsnConverter fuelTypeConverter = FuelType.CONV;
    CONV.setComponentConverters(new AsnConverter[] { classificationConverter, fuelTypeConverter });
  }
}
