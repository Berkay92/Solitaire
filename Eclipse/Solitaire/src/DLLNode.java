
public class DLLNode {
	Object data;
	DLLNode next;
	DLLNode prev;
	
	public DLLNode(Object data) {
		this.data = data;
		next=null;
		prev=null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public DLLNode getNext() {
		return next;
	}
	public void setNext(DLLNode next) {
		this.next = next;
	}
	public DLLNode getPrev() {
		return prev;
	}
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
}

