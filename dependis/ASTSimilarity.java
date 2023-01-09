package Similarity;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class ASTSimilarity {

    public static double similarityCheck(String path1, String code) throws IOException {
    	// Parse the Java file and code snippet
        File file1 = new File(path1);
        CompilationUnit cu1 = parse(file1);
        CompilationUnit cu2 = parse(code);
        
        Set<String> idName1 = new HashSet<String>();
        cu1.accept(new org.eclipse.jdt.core.dom.ASTVisitor() { 
			  public boolean visit(VariableDeclarationFragment node) { 
				  SimpleName name11 = node.getName();
				  String idname11 = name11.getIdentifier();
				  idName1.add(idname11);
				  //name11.setIdentifier("$");
				 
	                return true;
		  } 
			  
			  public boolean visit(MethodDeclaration node) { 
				  SimpleName name12 = node.getName();
				  String idname12 = name12.getIdentifier();
				  idName1.add(idname12);
				  //name12.setIdentifier("$");
				 
	                return true;
		  }
		  });
		  
        cu2.accept(new org.eclipse.jdt.core.dom.ASTVisitor() { 
			  public boolean visit(VariableDeclarationFragment node) { 
				  SimpleName name21 = node.getName();
				  String idname21 = name21.getIdentifier();
				  idName1.add(idname21);
				  //name21.setIdentifier("$");
				 
	                return true;
		  } 
			  
			  public boolean visit(MethodDeclaration node) { 
				  SimpleName name22 = node.getName();
				  String idname22 = name22.getIdentifier();
				  idName1.add(idname22);
				  //name22.setIdentifier("$");
				 
	                return true;
		  }
		  });
		  
        //collecting all the nodes from two java files
        NodeCollector collector1 = new NodeCollector();
        cu1.accept(collector1);
        
        NodeCollector collector2 = new NodeCollector();
        cu2.accept(collector2);
        
        Set<org.eclipse.jdt.core.dom.ASTNode> nodes1 = collector1.getNodes();
        Set<org.eclipse.jdt.core.dom.ASTNode> nodes2 = collector2.getNodes();
       
       
        //converting nodes to string and removing all the empty spaces
        Set<String> strNodes1 = new HashSet<String>();
        Set<String> strNodes2 = new HashSet<String>();
        for(org.eclipse.jdt.core.dom.ASTNode node1 : nodes1) {
        	String str1 = node1.toString();
        	for(String id : idName1) {
        		if(str1.contains(id)) {
        		str1 = str1.replace(id, "");
        		}
        	}
        	if(str1.length()>1) {
        		strNodes1.add(str1);
        		}
        		
        	}
        
        for(org.eclipse.jdt.core.dom.ASTNode node2 : nodes2) {
        	String str2 = node2.toString();
        	for(String id : idName1) {
        		if(str2.contains(id)) {
        		str2 = str2.replace(id, "");
        		}
        	}
        	if(str2.length()>1) {
        		strNodes2.add(str2);	
        		}
        	}
        
         //finding the similarity
         //double totalNodes =0;
         double matchingNodes = 0;
			/*
			 * System.out.println("node1Size"+strNodes1.size());
			 * System.out.println(strNodes2.size());
			 */
         //totalNodes = strNodes1.size()+strNodes2.size();
         
        for(String nd1 : strNodes1) {
        	for(String nd2 : strNodes2) {
				  if(nd1.equals(nd2)) {
					  //System.out.println(nd1);
					  matchingNodes++; 
					  }
				 
        	}
        }
        double similarity = matchingNodes/(strNodes1.size()+strNodes2.size()-matchingNodes)*100;
		return similarity;
    }

    private static CompilationUnit parse(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        try {
        	ASTParser parser = ASTParser.newParser(AST.JLS3);
    		parser.setSource(read(input));
    		parser.setKind(ASTParser.K_COMPILATION_UNIT);
    		IProgressMonitor prgressM = new NullProgressMonitor();
    		CompilationUnit cu = (CompilationUnit) parser.createAST(prgressM);
    		
    		return cu;
        } finally {
            input.close();
        }
    }

    private static CompilationUnit parse(String str) throws IOException {
        try {
        	ASTParser parser = ASTParser.newParser(AST.JLS3);
    		parser.setSource(read(str));
    		parser.setKind(ASTParser.K_COMPILATION_UNIT);
    		IProgressMonitor prgressM = new NullProgressMonitor();
    		CompilationUnit cu = (CompilationUnit) parser.createAST(prgressM);
    		
    		return cu;
        } finally {
            
        }
    }
    
    
    private static char[] read(FileInputStream input) throws IOException {
        StringBuilder builder = new StringBuilder(1024);
        byte[] buffer = new byte[1024];
        int count;
        while ((count = input.read(buffer)) > 0) {
            builder.append(new String(buffer, 0, count));
        }
        return builder.toString().toCharArray();
    }
    
    private static char[] read(String input) throws IOException {
        StringBuilder builder = new StringBuilder(input);
        char[] charArray = builder.toString().toCharArray();
        return charArray;
    }
    
}
