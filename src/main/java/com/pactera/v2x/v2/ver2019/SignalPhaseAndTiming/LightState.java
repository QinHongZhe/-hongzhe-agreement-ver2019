package com.pactera.v2x.v2.ver2019.SignalPhaseAndTiming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum LightState {
  unavailable(0),
  dark(1),
  flashing_red(2),
  red(3),
  flashing_green(4),
  permissive_green(5),
  protected_green(6),
  yellow(7),
  flashing_yellow(8);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  LightState(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LightState per_decode(boolean align, InputStream in) throws IOException {
    return (LightState)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = SignalPhaseAndTiming.type(262161);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(LightState.class);
  }
}
