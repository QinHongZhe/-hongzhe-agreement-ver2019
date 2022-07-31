package com.pactera.v2x.v2.ver2019.MapLink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class PointList {
  public static void per_encode(Vector<RoadPoint> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<RoadPoint> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<RoadPoint>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(458765);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)RoadPoint.CONV);
}
