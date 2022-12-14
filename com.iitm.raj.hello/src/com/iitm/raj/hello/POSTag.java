package com.iitm.raj.hello;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class POSTag {
	
	public static Set<String> taggingWord( String sentence) {
		Set<String> wdList = new HashSet<String>();
		Properties props = new Properties();
	    props.setProperty("annotators", "tokenize, ssplit, pos");
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

	    // create an empty Annotation
	    String str = sentence;
	    Annotation document = new Annotation(str);

	    // run the POS tagger on the document
	    pipeline.annotate(document);

	    // get the list of POS tags for the document
	    List<CoreLabel> posTags = document.get(CoreAnnotations.TokensAnnotation.class);
	    for (CoreLabel posTag : posTags) {
	      // get the POS tag for the current word
	    	//wdList.add(String.format("%s\t%s", posTag.word(), posTag.tag()));
	      String tag = posTag.get(CoreAnnotations.PartOfSpeechAnnotation.class);
	      
	      // check if the word is a verb or a noun
	      if (tag.startsWith("VB")||tag.startsWith("VBD") ||tag.startsWith("VBG")||tag.startsWith("VBN")||tag.startsWith("VBP") ||tag.startsWith("VBZ") ) {
	        //System.out.println(posTag.get(CoreAnnotations.TextAnnotation.class));
	    	wdList.add(posTag.get(CoreAnnotations.TextAnnotation.class));
	      } else if (tag.startsWith("NN")||tag.startsWith("NNS")||tag.startsWith("NNP") ||tag.startsWith("NNPS")) {
	        //System.out.println(posTag.get(CoreAnnotations.TextAnnotation.class));
	    	wdList.add(posTag.get(CoreAnnotations.TextAnnotation.class));
	      }
	    }
	
		return wdList;
	}
	
	
	public static void main(String[] args) {
		Set<String> rst = taggingWord("Makes an instance for the given value. This may (but does not necessarily) return an already-allocated instance.");
		for(String st : rst) {
			System.out.println(st);
		}
	}
}