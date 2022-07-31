package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

public class ReferenceLanes extends BitString {
  public static final int reserved = 0;
  
  public static final int lane1 = 1;
  
  public static final int lane2 = 2;
  
  public static final int lane3 = 3;
  
  public static final int lane4 = 4;
  
  public static final int lane5 = 5;
  
  public static final int lane6 = 6;
  
  public static final int lane7 = 7;
  
  public static final int lane8 = 8;
  
  public static final int lane9 = 9;
  
  public static final int lane10 = 10;
  
  public static final int lane11 = 11;
  
  public static final int lane12 = 12;
  
  public static final int lane13 = 13;
  
  public static final int lane14 = 14;
  
  public static final int lane15 = 15;
  
  public ReferenceLanes(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public ReferenceLanes(int size) {
    super(size);
  }
  
  public ReferenceLanes() {
    super(0);
  }
  
  public boolean getReserved() {
    return getBit(0);
  }
  
  public void setReserved() {
    setBit(0, true);
  }
  
  public void clearReserved() {
    setBit(0, false);
  }
  
  public boolean getLane1() {
    return getBit(1);
  }
  
  public void setLane1() {
    setBit(1, true);
  }
  
  public void clearLane1() {
    setBit(1, false);
  }
  
  public boolean getLane2() {
    return getBit(2);
  }
  
  public void setLane2() {
    setBit(2, true);
  }
  
  public void clearLane2() {
    setBit(2, false);
  }
  
  public boolean getLane3() {
    return getBit(3);
  }
  
  public void setLane3() {
    setBit(3, true);
  }
  
  public void clearLane3() {
    setBit(3, false);
  }
  
  public boolean getLane4() {
    return getBit(4);
  }
  
  public void setLane4() {
    setBit(4, true);
  }
  
  public void clearLane4() {
    setBit(4, false);
  }
  
  public boolean getLane5() {
    return getBit(5);
  }
  
  public void setLane5() {
    setBit(5, true);
  }
  
  public void clearLane5() {
    setBit(5, false);
  }
  
  public boolean getLane6() {
    return getBit(6);
  }
  
  public void setLane6() {
    setBit(6, true);
  }
  
  public void clearLane6() {
    setBit(6, false);
  }
  
  public boolean getLane7() {
    return getBit(7);
  }
  
  public void setLane7() {
    setBit(7, true);
  }
  
  public void clearLane7() {
    setBit(7, false);
  }
  
  public boolean getLane8() {
    return getBit(8);
  }
  
  public void setLane8() {
    setBit(8, true);
  }
  
  public void clearLane8() {
    setBit(8, false);
  }
  
  public boolean getLane9() {
    return getBit(9);
  }
  
  public void setLane9() {
    setBit(9, true);
  }
  
  public void clearLane9() {
    setBit(9, false);
  }
  
  public boolean getLane10() {
    return getBit(10);
  }
  
  public void setLane10() {
    setBit(10, true);
  }
  
  public void clearLane10() {
    setBit(10, false);
  }
  
  public boolean getLane11() {
    return getBit(11);
  }
  
  public void setLane11() {
    setBit(11, true);
  }
  
  public void clearLane11() {
    setBit(11, false);
  }
  
  public boolean getLane12() {
    return getBit(12);
  }
  
  public void setLane12() {
    setBit(12, true);
  }
  
  public void clearLane12() {
    setBit(12, false);
  }
  
  public boolean getLane13() {
    return getBit(13);
  }
  
  public void setLane13() {
    setBit(13, true);
  }
  
  public void clearLane13() {
    setBit(13, false);
  }
  
  public boolean getLane14() {
    return getBit(14);
  }
  
  public void setLane14() {
    setBit(14, true);
  }
  
  public void clearLane14() {
    setBit(14, false);
  }
  
  public boolean getLane15() {
    return getBit(15);
  }
  
  public void setLane15() {
    setBit(15, true);
  }
  
  public void clearLane15() {
    setBit(15, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ReferenceLanes))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ReferenceLanes per_decode(boolean align, InputStream in) throws IOException {
    return (ReferenceLanes)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1507486);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(ReferenceLanes.class);
}
