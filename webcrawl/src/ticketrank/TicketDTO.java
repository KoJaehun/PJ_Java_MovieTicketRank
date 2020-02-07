package ticketrank;

public class TicketDTO {
	private int count;
	private int total;
	
	public TicketDTO() {}

	public TicketDTO(int count, int total) {
		super();
		this.count = count;
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "TicketDTO [count=" + count + ", total=" + total + "]";
	}
	
	

}
