package Similarity;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;


public class CompareCount {
	static int i = 0;
	static int j = 0;
    public static void main(String[] args) {
        String source = "public class Test {\n"
                     + "  public void foo() {\n"
                     + "    int x = 10;\n"
                     + "    int y = 10;\n"
                     + "    System.out.println(x);\n"
                     + "  }\n"
                     + "  public void sum() {\n"
                     + "    int z = x+y;\n"
                     + "    System.out.println(x);\n"
                     + "  }\n"
                     + "}\n";

        // Create an AST parser
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        // Parse the source code and create an AST
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        // Visit the AST and remove all identifiers
         Set<String> id = new HashSet<String>();
		  cu.accept(new org.eclipse.jdt.core.dom.ASTVisitor() { 
			  public boolean visit(VariableDeclarationFragment node) { 
				  SimpleName name1 = node.getName();
				  String nme1 = name1.getIdentifier();
				  id.add(nme1);
				  //name.setIdentifier(nmeNw1);
				 
	                return true;
		  } 
			  
			  public boolean visit(MethodDeclaration node) { 
				  SimpleName name2 = node.getName();
				  String nme2 = name2.getIdentifier();
				  id.add(nme2);
				  //name.setIdentifier(nmeNw2);
				 
	                return true;
		  }
		  });
		 
		  for(String str : id) {
			  System.out.println(str);
		  }
        // Print the modified source code
        //System.out.println(cu.toString());
    }
}