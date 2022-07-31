package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class BasicSafetyMessage {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @NotNull
  @Size(min = 8, max = 8)
  @Component(1)
  public byte[] id;
  
  @NotNull
  @Component(2)
  public Integer secMark;
  
  @Null
  @Component(3)
  public TimeConfidence timeConfidence;
  
  @NotNull
  @Component(4)
  public Position3D pos;
  
  @Null
  @Component(5)
  public PositionalAccuracy posAccuracy;
  
  @Null
  @Component(6)
  public PositionConfidenceSet posConfidence;
  
  @NotNull
  @Component(7)
  public TransmissionState transmission;
  
  @NotNull
  @Component(8)
  public Integer speed;
  
  @NotNull
  @Component(9)
  public Integer heading;
  
  @Null
  @Component(10)
  public Integer angle;
  
  @Null
  @Component(11)
  public MotionConfidenceSet motionCfd;
  
  @NotNull
  @Component(12)
  public AccelerationSet4Way accelSet;
  
  @NotNull
  @Component(13)
  public BrakeSystemStatus brakes;
  
  @NotNull
  @Component(14)
  public VehicleSize size;
  
  @NotNull
  @Component(15)
  public VehicleClassification vehicleClass;
  
  @Null
  @Component(16)
  public VehicleSafetyExtensions safetyExt;
  
  @Null
  @Component(17)
  public VehicleEmergencyExtensions emergencyExt;
  
  @Null
  @Size(min = 4, max = 4)
  @Component(18)
  public byte[] token;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BasicSafetyMessage))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static BasicSafetyMessage per_decode(boolean align, InputStream in) throws IOException {
    return (BasicSafetyMessage)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(65537);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(BasicSafetyMessage.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    OctetStringConverter octetStringConverter1 = OctetStringConverter.INSTANCE;
    AsnConverter secMarkConverter = DSecond.CONV;
    AsnConverter timeConfidenceConverter = TimeConfidence.CONV;
    CompositeConverter compositeConverter1 = Position3D.CONV;
    CompositeConverter compositeConverter2 = PositionalAccuracy.CONV;
    CompositeConverter compositeConverter3 = PositionConfidenceSet.CONV;
    AsnConverter transmissionConverter = TransmissionState.CONV;
    AsnConverter speedConverter = Speed.CONV;
    AsnConverter headingConverter = Heading.CONV;
    AsnConverter angleConverter = SteeringWheelAngle.CONV;
    CompositeConverter compositeConverter4 = MotionConfidenceSet.CONV;
    CompositeConverter compositeConverter5 = AccelerationSet4Way.CONV;
    CompositeConverter compositeConverter6 = BrakeSystemStatus.CONV;
    CompositeConverter compositeConverter7 = VehicleSize.CONV;
    CompositeConverter compositeConverter8 = VehicleClassification.CONV;
    CompositeConverter compositeConverter9 = VehicleSafetyExtensions.CONV;
    CompositeConverter compositeConverter10 = VehicleEmergencyExtensions.CONV;
    OctetStringConverter octetStringConverter2 = OctetStringConverter.INSTANCE;
    CONV.setComponentConverters(new AsnConverter[] { 
          msgCntConverter, (AsnConverter)octetStringConverter1, secMarkConverter, timeConfidenceConverter, (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, (AsnConverter)compositeConverter3, transmissionConverter, speedConverter, headingConverter, 
          angleConverter, (AsnConverter)compositeConverter4, (AsnConverter)compositeConverter5, (AsnConverter)compositeConverter6, (AsnConverter)compositeConverter7, (AsnConverter)compositeConverter8, (AsnConverter)compositeConverter9, (AsnConverter)compositeConverter10, (AsnConverter)octetStringConverter2 });
  }
}
