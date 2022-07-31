package com.pactera.v2x.v2.ver2019.BSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class BrakeSystemStatus {
  @Null
  @Component(0)
  public BrakePedalStatus brakePadel;
  
  @Null
  @Component(1)
  public BrakeAppliedStatus wheelBrakes;
  
  @Null
  @Component(2)
  public TractionControlStatus traction;
  
  @Null
  @Component(3)
  public AntiLockBrakeStatus abs;
  
  @Null
  @Component(4)
  public StabilityControlStatus scs;
  
  @Null
  @Component(5)
  public BrakeBoostApplied brakeBoost;
  
  @Null
  @Component(6)
  public AuxiliaryBrakeStatus auxBrakes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BrakeSystemStatus))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static BrakeSystemStatus per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeSystemStatus)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = BSM.type(458779);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(BrakeSystemStatus.class);
  
  static {
    AsnConverter brakePadelConverter = BrakePedalStatus.CONV;
    AsnConverter wheelBrakesConverter = BrakeAppliedStatus.CONV;
    AsnConverter tractionConverter = TractionControlStatus.CONV;
    AsnConverter absConverter = AntiLockBrakeStatus.CONV;
    AsnConverter scsConverter = StabilityControlStatus.CONV;
    AsnConverter brakeBoostConverter = BrakeBoostApplied.CONV;
    AsnConverter auxBrakesConverter = AuxiliaryBrakeStatus.CONV;
    CONV.setComponentConverters(new AsnConverter[] { brakePadelConverter, wheelBrakesConverter, tractionConverter, absConverter, scsConverter, brakeBoostConverter, auxBrakesConverter });
  }
}
