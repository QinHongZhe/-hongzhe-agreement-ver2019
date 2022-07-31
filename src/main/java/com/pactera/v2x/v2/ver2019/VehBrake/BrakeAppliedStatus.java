package com.pactera.v2x.v2.ver2019.VehBrake;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

public class BrakeAppliedStatus extends BitString {
  public static final int unavailable = 0;
  
  public static final int leftFront = 1;
  
  public static final int leftRear = 2;
  
  public static final int rightFront = 3;
  
  public static final int rightRear = 4;
  
  public BrakeAppliedStatus(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public BrakeAppliedStatus(int size) {
    super(size);
  }
  
  public BrakeAppliedStatus() {
    super(0);
  }
  
  public boolean getUnavailable() {
    return getBit(0);
  }
  
  public void setUnavailable() {
    setBit(0, true);
  }
  
  public void clearUnavailable() {
    setBit(0, false);
  }
  
  public boolean getLeftFront() {
    return getBit(1);
  }
  
  public void setLeftFront() {
    setBit(1, true);
  }
  
  public void clearLeftFront() {
    setBit(1, false);
  }
  
  public boolean getLeftRear() {
    return getBit(2);
  }
  
  public void setLeftRear() {
    setBit(2, true);
  }
  
  public void clearLeftRear() {
    setBit(2, false);
  }
  
  public boolean getRightFront() {
    return getBit(3);
  }
  
  public void setRightFront() {
    setBit(3, true);
  }
  
  public void clearRightFront() {
    setBit(3, false);
  }
  
  public boolean getRightRear() {
    return getBit(4);
  }
  
  public void setRightRear() {
    setBit(4, true);
  }
  
  public void clearRightRear() {
    setBit(4, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BrakeAppliedStatus))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakeAppliedStatus per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeAppliedStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehBrake.type(65538);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(BrakeAppliedStatus.class);
}
