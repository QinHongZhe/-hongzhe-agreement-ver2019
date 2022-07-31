package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

public class LaneAttributes_Sidewalk extends BitString {
  public static final int sidewalk_RevocableLane = 0;
  
  public static final int bicyleUseAllowed = 1;
  
  public static final int isSidewalkFlyOverLane = 2;
  
  public static final int walkBikes = 3;
  
  public LaneAttributes_Sidewalk(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Sidewalk(int size) {
    super(size);
  }
  
  public LaneAttributes_Sidewalk() {
    super(0);
  }
  
  public boolean getSidewalk_RevocableLane() {
    return getBit(0);
  }
  
  public void setSidewalk_RevocableLane() {
    setBit(0, true);
  }
  
  public void clearSidewalk_RevocableLane() {
    setBit(0, false);
  }
  
  public boolean getBicyleUseAllowed() {
    return getBit(1);
  }
  
  public void setBicyleUseAllowed() {
    setBit(1, true);
  }
  
  public void clearBicyleUseAllowed() {
    setBit(1, false);
  }
  
  public boolean getIsSidewalkFlyOverLane() {
    return getBit(2);
  }
  
  public void setIsSidewalkFlyOverLane() {
    setBit(2, true);
  }
  
  public void clearIsSidewalkFlyOverLane() {
    setBit(2, false);
  }
  
  public boolean getWalkBikes() {
    return getBit(3);
  }
  
  public void setWalkBikes() {
    setBit(3, true);
  }
  
  public void clearWalkBikes() {
    setBit(3, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Sidewalk))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Sidewalk per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Sidewalk)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1179765);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Sidewalk.class);
}
