public interface Visitor
{
 boolean visit(Object data);
}
public void breadthFirst(Visitor v)
{
 if (root == null) { return; }
 Queue<Node> q = new LinkedList<Node>();
 q.add(root);
 boolean more = true;
 while (more && q.size() > 0)
 {
 Node n = q.remove();
 more = v.visit(n.data);
 if (more)
 {
 for (Node c : n.children) { q.add(c); }
 }
 }
}