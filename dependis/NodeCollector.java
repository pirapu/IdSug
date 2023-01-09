package Similarity;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class NodeCollector extends ASTVisitor {
  private Set<ASTNode> nodes = new HashSet<>();

  @Override
  public boolean preVisit2(ASTNode node) {
    nodes.add(node);
    return true;
  }

  public Set<ASTNode> getNodes() {
    return nodes;
  }
}