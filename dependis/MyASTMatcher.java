package Similarity;

import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;

public class MyASTMatcher extends ASTMatcher {

    private int totalNodes;
    private int matchingNodes;

    public MyASTMatcher() {
        totalNodes = 0;
        matchingNodes = 0;
    }
    
    
    public boolean match(ASTNode node1, ASTNode node2) {
        totalNodes++;
        if (node1 instanceof AnnotationTypeDeclaration && node2 instanceof AnnotationTypeDeclaration && super.match((AnnotationTypeDeclaration) node1, node2)) {
            matchingNodes++;
            return true;
        }
        return false;
    }

    public double getSimilarity() {
        return (double) matchingNodes / totalNodes;
    }
}