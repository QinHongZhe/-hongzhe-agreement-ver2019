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

public class Link {
  @Null
  @Component(0)
  public String name;
  
  @NotNull
  @Component(1)
  public NodeReferenceID upstreamNodeId;
  
  @Null
  @Component(2)
  public Vector<RegulatorySpeedLimit> speedLimits;
  
  @Null
  @Component(3)
  public Integer linkWidth;
  
  @Null
  @Component(4)
  public Vector<RoadPoint> points;
  
  @Null
  @Component(5)
  public Vector<Movement> movements;
  
  @NotNull
  @Component(6)
  public Vector<Lane> lanes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Link))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Link per_decode(boolean align, InputStream in) throws IOException {
    return (Link)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = Map.type(327694);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Link.class);
  
  static {
    AsnConverter nameConverter = DescriptiveName.CONV;
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter speedLimitsConverter = SpeedLimitList.CONV;
    AsnConverter linkWidthConverter = LaneWidth.CONV;
    AsnConverter pointsConverter = PointList.CONV;
    AsnConverter movementsConverter = MovementList.CONV;
    AsnConverter lanesConverter = LaneList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { nameConverter, (AsnConverter)compositeConverter, speedLimitsConverter, linkWidthConverter, pointsConverter, movementsConverter, lanesConverter });
  }
}
