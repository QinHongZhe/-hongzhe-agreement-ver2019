package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Size;
import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.StringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

public class Description {
  public static final int textStringChosen = 0;
  
  public static final int textGB2312Chosen = 1;
  
  public final int choiceID;
  
  @Alternative(0)
  public final String textString;
  
  @Size(min = 2, max = 512)
  @Alternative(1)
  public final byte[] textGB2312;
  
  private Description(int choiceID, String textString, byte[] textGB2312) {
    this.choiceID = choiceID;
    this.textString = textString;
    this.textGB2312 = textGB2312;
  }
  
  public static Description textString(String textString) {
    return new Description(0, textString, null);
  }
  
  public static Description textGB2312(byte[] textGB2312) {
    return new Description(1, null, textGB2312);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Description))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Description per_decode(boolean align, InputStream in) throws IOException {
    return (Description)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1507478);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(Description.class);
  
  static {
    StringConverter stringConverter = StringConverter.INSTANCE;
    OctetStringConverter octetStringConverter = OctetStringConverter.INSTANCE;
    CONV.setAlternativeConverters(new AsnConverter[] { (AsnConverter)stringConverter, (AsnConverter)octetStringConverter });
  }
}
