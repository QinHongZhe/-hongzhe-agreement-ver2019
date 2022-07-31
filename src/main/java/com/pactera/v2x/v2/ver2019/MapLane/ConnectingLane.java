package com.pactera.v2x.v2.ver2019.MapLane;

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

public class ConnectingLane {
  @NotNull
  @Component(0)
  public Integer lane;
  
  @Null
  @Component(1)
  public AllowedManeuvers maneuver;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ConnectingLane))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static ConnectingLane per_decode(boolean align, InputStream in) throws IOException {
    return (ConnectingLane)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(65551);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(ConnectingLane.class);
  
  static {
    AsnConverter laneConverter = LaneID.CONV;
    AsnConverter maneuverConverter = AllowedManeuvers.CONV;
    CONV.setComponentConverters(new AsnConverter[] { laneConverter, maneuverConverter });
  }
}
