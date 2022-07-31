package com.pactera.v2x.v2.ver2019.MapLink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.StringConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class DescriptiveName {
  public static void per_encode(String object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static String per_decode(boolean align, InputStream in) throws IOException {
    return (String)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(65543);
  
  public static final AsnConverter CONV = (AsnConverter)StringConverter.INSTANCE;
}
