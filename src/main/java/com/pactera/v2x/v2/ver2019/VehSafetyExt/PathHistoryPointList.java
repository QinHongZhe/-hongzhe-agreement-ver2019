package com.pactera.v2x.v2.ver2019.VehSafetyExt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class PathHistoryPointList {
  public static void per_encode(Vector<PathHistoryPoint> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<PathHistoryPoint> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<PathHistoryPoint>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327735);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)PathHistoryPoint.CONV);
}
