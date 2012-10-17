/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.*;

import model.genetag;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

/**
 * Example annotator that detects room numbers using Java 1.4 regular expressions.
 */
/**
 * 
 * @author phyllis
 * @version 1.0
 * @see the genetagAnnotation contains the process od import the text, use string.to cut the sentence into two part: ID and words. call the PosTagNamedEntityRecognizer to analyse the text. after analysing the location of selected words, the begin will be stored in key, the end will be stored in value, and we can pick the word out according to the being and end.
 * @see use the annotion. to set the id, location and words. 
 *
 */
public class genetagAnnotator extends JCasAnnotator_ImplBase {

  private genetag annotation;

  /**
   * @see JCasAnnotator_ImplBase#process(JCas)
   */
  @Override
  public void process(JCas aJCas) {

    // get document text
    // String docText = aJCas.getDocumentText();
    // System.out.println("!!!");
    String str = aJCas.getDocumentText();
    String[] strarray = str.split("\n");
    Object genetag;
    for (int i = 0; i < strarray.length; i++) {
      

      String s = strarray[i].substring(15);
      String id = strarray[i].substring(0, 14);

      Map map = new HashMap();
      try {
        PosTagNamedEntityRecognizer postag = new PosTagNamedEntityRecognizer();
        map = postag.getGeneSpans(s);
      } catch (ResourceInitializationException e) {

        e.printStackTrace();
      }
      Set keys = map.keySet();
      if (keys != null) {
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
          int key = (Integer) iterator.next();
          int value = (Integer) map.get(key);
          String words = s.substring(key, value);
          
          genetag annotation = new genetag(aJCas);
          annotation.setId(id);
          annotation.setBegin(key);
          annotation.setEnd(value);
          annotation.setWords(words);
          annotation.addToIndexes();
                
        }
      }
     

    }
    // System.out.println("!!!");
  }
}
