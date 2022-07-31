package com.pactera.v2x.v2.ver2019.DefTime;

import java.util.Vector;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.type.AsnModule;
import org.asnlab.asndt.runtime.type.AsnType;

public class DefTime extends AsnModule {
  public static final DefTime instance = new DefTime();
  
  private DefTime() {
    super(DefTime.class);
  }
  
  public static AsnType type(int id) {
    return instance.getType(id);
  }
  
  public static Object value(int valueId, AsnConverter converter) {
    return instance.getValue(valueId, converter);
  }
  
  public static Object object(int objectId, AsnConverter converter) {
    return instance.getObject(objectId, converter);
  }
  
  public static Vector objectSet(int objectSetId, AsnConverter converter) {
    return instance.getObjectSet(objectSetId, converter);
  }
}
