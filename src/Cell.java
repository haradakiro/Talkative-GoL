
public class Cell {
	
	private Cell neighbor;
	
	private boolean isTalkative;
	private int numFriends=0;
	
	
	private Cell(boolean isAlive){
		this.isTalkative=isAlive;
	}
	
	
	public static Cell talkativeCell() {
		return new Cell(true);
	}

	public static Cell shyCell() {
		return new Cell(false);
	}

	public void hi() {
		numFriends++;
	}

	public void tick() {
		maybeBecomeShy();
		maybeBecomeTalkative();
	}

	private void maybeBecomeTalkative() {
		if(numFriends==3){
			this.isTalkative=true;
		}
	}


	private void maybeBecomeShy() {
		if(numFriends<2 || numFriends>3){
			this.isTalkative=false;
		}
	}

	public void addFriend(Cell friend) {
		this.neighbor = friend;
	}

	public void communicate() {
		if(isTalkative){
			neighbor.hi();
		}
	}


	public void fullyConnect(Cell otherCell) {
		addFriend(otherCell);
		otherCell.addFriend(this);
	}


}
