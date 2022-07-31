package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class RSIPriority {
  public static void per_encode(byte[] object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static byte[] per_decode(boolean align, InputStream in) throws IOException {
    return (byte[])TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1507480);
  
  public static final AsnConverter CONV = (AsnConverter)OctetStringConverter.INSTANCE;
}
