package com.pactera.v2x.v2.ver2019.MapSpeedLimit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class SpeedLimitList {
  public static void per_encode(Vector<RegulatorySpeedLimit> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<RegulatorySpeedLimit> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<RegulatorySpeedLimit>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapSpeedLimit.type(65540);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)RegulatorySpeedLimit.CONV);
}
