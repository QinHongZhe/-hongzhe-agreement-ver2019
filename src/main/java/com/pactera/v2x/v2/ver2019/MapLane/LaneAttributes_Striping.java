package com.pactera.v2x.v2.ver2019.MapLane;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

public class LaneAttributes_Striping extends BitString {
  public static final int stripeToConnectingLanesRevocableLane = 0;
  
  public static final int stripeDrawOnLeft = 1;
  
  public static final int stripeDrawOnRight = 2;
  
  public static final int stripeToConnectingLanesLeft = 3;
  
  public static final int stripeToConnectingLanesRight = 4;
  
  public static final int stripeToConnectingLanesAhead = 5;
  
  public LaneAttributes_Striping(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Striping(int size) {
    super(size);
  }
  
  public LaneAttributes_Striping() {
    super(0);
  }
  
  public boolean getStripeToConnectingLanesRevocableLane() {
    return getBit(0);
  }
  
  public void setStripeToConnectingLanesRevocableLane() {
    setBit(0, true);
  }
  
  public void clearStripeToConnectingLanesRevocableLane() {
    setBit(0, false);
  }
  
  public boolean getStripeDrawOnLeft() {
    return getBit(1);
  }
  
  public void setStripeDrawOnLeft() {
    setBit(1, true);
  }
  
  public void clearStripeDrawOnLeft() {
    setBit(1, false);
  }
  
  public boolean getStripeDrawOnRight() {
    return getBit(2);
  }
  
  public void setStripeDrawOnRight() {
    setBit(2, true);
  }
  
  public void clearStripeDrawOnRight() {
    setBit(2, false);
  }
  
  public boolean getStripeToConnectingLanesLeft() {
    return getBit(3);
  }
  
  public void setStripeToConnectingLanesLeft() {
    setBit(3, true);
  }
  
  public void clearStripeToConnectingLanesLeft() {
    setBit(3, false);
  }
  
  public boolean getStripeToConnectingLanesRight() {
    return getBit(4);
  }
  
  public void setStripeToConnectingLanesRight() {
    setBit(4, true);
  }
  
  public void clearStripeToConnectingLanesRight() {
    setBit(4, false);
  }
  
  public boolean getStripeToConnectingLanesAhead() {
    return getBit(5);
  }
  
  public void setStripeToConnectingLanesAhead() {
    setBit(5, true);
  }
  
  public void clearStripeToConnectingLanesAhead() {
    setBit(5, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Striping))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Striping per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Striping)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(65545);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Striping.class);
}
