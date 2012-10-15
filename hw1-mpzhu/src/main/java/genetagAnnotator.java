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

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import model.genetag;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

/**
 * Example annotator that detects room numbers using Java 1.4 regular expressions.
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

      File modelFile = new File("src/ne-en-bio-genetag.hmmchunker");

      // System.out.println("Reading chunker from file=" + modelFile);

      ConfidenceChunker chunker = null;

      try {
        chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for (int j = 0; j < s.length(); ++i) {
        char[] cs = s.toCharArray();
        Iterator<Chunk> it = chunker.nBestChunks(cs, 0, cs.length, 8);
        // System.out.println(args[i]);
        for (int n = 0; it.hasNext(); ++n) {
          Chunk so = it.next();
          // double jointProb = so.score();
          Chunk chunk = it.next();
          double conf = Math.pow(2.0,chunk.score());
          int start = chunk.start();
          int end = chunk.end();
          String words = s.substring(start,end);

          // System.out.println(n + " " + " " + chunking.chunkSet());

          genetag annotation = new genetag(aJCas);
          annotation.setId(id);
          annotation.setBegin(chunk.start());
          annotation.setEnd(chunk.end());
          annotation.setWords(words);
          annotation.addToIndexes();

        }
      }

    }
    // System.out.println("!!!");
  }
}
