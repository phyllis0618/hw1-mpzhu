

/* First created by JCasGen Sat Oct 13 11:32:10 EDT 2012 */
package model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 14 16:05:26 EDT 2012
 * XML source: /Users/phyllis/Documents/workspace/hw1-mpzhu/src/main/resources/CPE/genetypeSystemDescriptor.xml
 * @generated */
public class genetag extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(genetag.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected genetag() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public genetag(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public genetag(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public genetag(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets id
   * @generated */
  public String getId() {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "model.genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((genetag_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets id 
   * @generated */
  public void setId(String v) {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "model.genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((genetag_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: words

  /** getter for words - gets 
   * @generated */
  public String getWords() {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "model.genetag");
    return jcasType.ll_cas.ll_getStringValue(addr, ((genetag_Type)jcasType).casFeatCode_words);}
    
  /** setter for words - sets  
   * @generated */
  public void setWords(String v) {
    if (genetag_Type.featOkTst && ((genetag_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "model.genetag");
    jcasType.ll_cas.ll_setStringValue(addr, ((genetag_Type)jcasType).casFeatCode_words, v);}    
  }

    