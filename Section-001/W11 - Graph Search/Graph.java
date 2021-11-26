import java.util.*;

public class Graph {
    private class Vertex {
        private String label;
        private List<Vertex> adjacencies;

        public Vertex(String label) {
            this.label = label;
            adjacencies = new ArrayList<>();
        }

        public String getLabel() { return this.label; }

        public void addAdjacency(Vertex other) {
            adjacencies.add(other);
        }

        public List<Vertex> getAdjacencies() { return adjacencies; }

        public int getDegree() {
            return adjacencies.size();
        }

        public String toString() { return label; }
    }

    private class Edge {
        private Vertex v1;
        private Vertex v2;

        public Edge(Vertex v1, Vertex v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public Vertex getVertex1() { return v1; }
        public Vertex getVertex2() { return v2; }
    }

    private HashMap<String, Vertex> vertices;

    public Graph(){
        vertices = new HashMap<>();
    }

    public void addVertex(String label){
        vertices.put(label, new Vertex(label));
    }

    public void addEdge(String v1Label, String v2Label){
        Vertex v1 = vertices.get(v1Label);
        Vertex v2 = vertices.get(v2Label);

        v1.addAdjacency(v2);
        v2.addAdjacency(v1);
    }

    public Vertex getVertex(String label){
        return vertices.get(label);
    }

    /*
    Below will contain all of the code for DFS
     */
    public Set<Vertex> visited;
    public Map<Vertex, Edge> discoveredEdges;

    public void dfs(String startPoint){
        visited = new HashSet<>();
        discoveredEdges = new HashMap<>();

        Vertex startVertex = vertices.get(startPoint);
        dfs(startVertex);
    }

    public void dfs(Vertex v){
        visited.add(v);

        List<Vertex> adjacencies = v.getAdjacencies();
        for (Vertex visit : adjacencies){
            if(!visited.contains(visit)){
                discoveredEdges.put(visit, new Edge(v, visit));

                dfs(visit);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("D", "E");
        graph.addEdge("B", "D");
        graph.addEdge("C", "A");
        graph.addEdge("E", "F");
        graph.addEdge("D", "A");

        Vertex d = graph.getVertex("D");
        System.out.printf("Degree of D: %d\n", d.getDegree());
        List<Vertex> adjacencies = d.getAdjacencies();
        System.out.println("Adjacencies of D:");

        for( Vertex adja : adjacencies){
            System.out.printf("\t%s, adjacencies: \n", adja.getLabel());

            for (Vertex inner : adja.getAdjacencies()){
                System.out.printf("\t\t%s\n", inner.getLabel());
            }
            System.out.println("");
        }

        graph.dfs("D");
        System.out.println("Visited Vertices:");
        for (Vertex v : graph.visited){
            System.out.printf("\t%s\n", v.getLabel());
        }

        System.out.println("Discovered Edges:");
        for (Vertex v : graph.discoveredEdges.keySet()){
            Edge edge = graph.discoveredEdges.get(v);
            System.out.printf("\tVertex %s, discovered by edge (%s, %s)\n", v.toString(),
                                    edge.getVertex1().toString(), edge.getVertex2().toString());
        }

    }
}
