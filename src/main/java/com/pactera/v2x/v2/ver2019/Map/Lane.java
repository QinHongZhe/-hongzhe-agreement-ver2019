package com.pactera.v2x.v2.ver2019.Map;

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

public class Lane {
  @NotNull
  @Component(0)
  public Integer laneID;
  
  @Null
  @Component(1)
  public Integer laneWidth;
  
  @Null
  @Component(2)
  public LaneAttributes laneAttributes;
  
  @Null
  @Component(3)
  public AllowedManeuvers maneuvers;
  
  @Null
  @Component(4)
  public Vector<Connection> connectsTo;
  
  @Null
  @Component(5)
  public Vector<RegulatorySpeedLimit> speedLimits;
  
  @Null
  @Component(6)
  public Vector<RoadPoint> points;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Lane))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Lane per_decode(boolean align, InputStream in) throws IOException {
    return (Lane)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = Map.type(524336);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Lane.class);
  
  static {
    AsnConverter laneIDConverter = LaneID.CONV;
    AsnConverter laneWidthConverter = LaneWidth.CONV;
    CompositeConverter compositeConverter = LaneAttributes.CONV;
    AsnConverter maneuversConverter = AllowedManeuvers.CONV;
    AsnConverter connectsToConverter = ConnectsToList.CONV;
    AsnConverter speedLimitsConverter = SpeedLimitList.CONV;
    AsnConverter pointsConverter = PointList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { laneIDConverter, laneWidthConverter, (AsnConverter)compositeConverter, maneuversConverter, connectsToConverter, speedLimitsConverter, pointsConverter });
  }
}
