package com.pactera.v2x.v2.ver2019.RSI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class RTSList {
  public static void per_encode(Vector<RTSData> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<RTSData> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<RTSData>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65584);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)RTSData.CONV);
}
