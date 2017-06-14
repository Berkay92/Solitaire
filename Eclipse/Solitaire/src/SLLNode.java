
public class SLLNode {
	
	private Object data;
	private SLLNode next_link;
	
	public SLLNode (Object adding){
		data=adding;
		next_link=null;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public SLLNode getNext_link() {
		return next_link;
	}
	public void setNext_link(SLLNode next_link) {
		this.next_link = next_link;
	}
	
	
	

}
