package com.pactera.v2x.v2.ver2019.SPATIntersectionState;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class PhaseStateList {
  public static void per_encode(Vector<PhaseState> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<PhaseState> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<PhaseState>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65546);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)PhaseState.CONV);
}
