
/* First created by JCasGen Sat Oct 13 11:32:11 EDT 2012 */
package model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sun Oct 14 16:05:27 EDT 2012
 * @generated */
public class genetag_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (genetag_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = genetag_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new genetag(addr, genetag_Type.this);
  			   genetag_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new genetag(addr, genetag_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = genetag.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("model.genetag");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "model.genetag");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "model.genetag");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_words;
  /** @generated */
  final int     casFeatCode_words;
  /** @generated */ 
  public String getWords(int addr) {
        if (featOkTst && casFeat_words == null)
      jcas.throwFeatMissing("words", "model.genetag");
    return ll_cas.ll_getStringValue(addr, casFeatCode_words);
  }
  /** @generated */    
  public void setWords(int addr, String v) {
        if (featOkTst && casFeat_words == null)
      jcas.throwFeatMissing("words", "model.genetag");
    ll_cas.ll_setStringValue(addr, casFeatCode_words, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public genetag_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_words = jcas.getRequiredFeatureDE(casType, "words", "uima.cas.String", featOkTst);
    casFeatCode_words  = (null == casFeat_words) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_words).getCode();

  }
}



    