import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.NBestChunker;

import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.ScoredObject;

import java.io.File;
import java.util.Iterator;

public class lingpipe {

  public void main(String[] args) throws Exception {
    File modelFile = new File("src/ne-en-bio-genetag.hmmchunker");

    //System.out.println("Reading chunker from file=" + modelFile);

    NBestChunker chunker = (NBestChunker) AbstractExternalizable.readObject(modelFile);
    for (int i = 1; i < args.length; ++i) {
      char[] cs = args[1].toCharArray();
      Iterator<ScoredObject<Chunking>> it = chunker.nBest(cs, 0, cs.length, 8);
      //System.out.println(args[i]);
      for (int n = 0; it.hasNext(); ++n) {
        ScoredObject so = it.next();
        //double jointProb = so.score();
        Chunking chunking = (Chunking) so.getObject();
        chunking.chunkSet();
        
        //System.out.println(n + " "  + " " + chunking.chunkSet());

      }

    }

  }


  }




