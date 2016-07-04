import java.util.LinkedList;


public class Graph {
	
	public Graph(int v){
		this.v = v;
		m1 = new boolean[v*v];
		
		eList2 = new LinkedList<Edge2>();
		
		eList3 = new LinkedList<Edge3>();
	}
	
	/********************** method 1 *************************/
	
	private int v;
	private boolean[] m1;
	
	public void addEdge(int from, int to){
		if(from < to)
			m1[to*v + from] = true;
		else
			m1[from*v + to] = true;
	}
	
	public boolean isAdjacent(int from, int to){
		if(from < to)
			return m1[to*v + from];
		else
			return m1[from*v + to];
	}
	
	/********************** method 2 *************************/
	
	private class Edge2{
		public int v1, v2;
		
		public Edge2(int v1, int v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	private LinkedList<Edge2> eList2;
	
	public void addEdge_2(int v1, int v2) {
		if(isAdjacent_2(v1, v2) == false){
			eList2.add(new Edge2(v1, v2));
		}
	}
	
	public boolean isAdjacent_2(int v1, int v2){
		for(Edge2 e : eList2){
			if(e.v1 == v1 || e.v2 == v1){
				if( (e.v1 == v1 && e.v2 == v2) || (e.v2 == v1 && e.v1 == v2) )
					return true;
			}
		}
		return false;
	}
	
	/********************** method 3 *************************/
	
	private class Edge3{
		public LinkedList<Integer> toList;
		
		public Edge3(){
			toList = new LinkedList<Integer>();
		}
	}
	private LinkedList<Edge3> eList3;
	
	public void add3(int from, int to){
		for(int i : eList3.get(from).toList){
			if(to == i)
				return;
		}
		for(int i : eList3.get(to).toList){
			if(from == i)
				return;
		}
		
		eList3.get(from).toList.add(to);
		eList3.get(to).toList.add(from);
	}
	
	public boolean isAdjacent3(int from, int to){
		for(int i : eList3.get(from).toList){
			if(to == i)
				return true;
		}
		return false;
	}	
}	
