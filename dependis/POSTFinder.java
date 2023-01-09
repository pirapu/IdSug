package Similarity;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class POSTFinder {
	
	
	public static void main(String[] args) {
		String text = "Marie was born in Paris.";
		// set up pipeline properties
	    Properties props = new Properties();
	    // set the list of annotators to run
	    props.setProperty("annotators", "tokenize,pos");
	    // build pipeline
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    // create a document object
	    CoreDocument document = pipeline.processToCoreDocument(text);
	    // display tokens
	    for (CoreLabel tok : document.tokens()) {
	      System.out.println(String.format("%s\t%s", tok.word(), tok.tag()));
	    }
	}
}
	
