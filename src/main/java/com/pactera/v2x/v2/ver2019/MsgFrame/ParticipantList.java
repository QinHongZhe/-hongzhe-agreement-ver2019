package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class ParticipantList {
  public static void per_encode(Vector<ParticipantData> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<ParticipantData> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<ParticipantData>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1376383);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)ParticipantData.CONV);
}
