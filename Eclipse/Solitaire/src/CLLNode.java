
public class CLLNode {
	
	private Object data;
	private CLLNode link;
	
	public CLLNode (Object adding){
		data=adding;
		link=null;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public CLLNode getLink() {
		return link;
	}

	public void setLink(CLLNode link) {
		this.link = link;
	}
	
	
	

}
