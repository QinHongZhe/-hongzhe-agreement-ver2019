package com.pactera.v2x.v2.ver2019.VehClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public class FuelType {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehClass.type(65594);
  
  public static final AsnConverter CONV = (AsnConverter)IntegerConverter.INSTANCE;
  
  public static final Integer unknownFuel = (Integer)VehClass.value(65595, CONV);
  
  public static final Integer gasoline = (Integer)VehClass.value(65596, CONV);
  
  public static final Integer ethanol = (Integer)VehClass.value(65597, CONV);
  
  public static final Integer diesel = (Integer)VehClass.value(65598, CONV);
  
  public static final Integer electric = (Integer)VehClass.value(65599, CONV);
  
  public static final Integer hybrid = (Integer)VehClass.value(65600, CONV);
  
  public static final Integer hydrogen = (Integer)VehClass.value(65601, CONV);
  
  public static final Integer natGasLiquid = (Integer)VehClass.value(65602, CONV);
  
  public static final Integer natGasComp = (Integer)VehClass.value(65603, CONV);
  
  public static final Integer propane = (Integer)VehClass.value(65604, CONV);
}
