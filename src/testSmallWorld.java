import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;


public class testSmallWorld {

	@Test
	public void testCellCanHaveMultipleFriends(){
		Cell cell = Cell.talkativeCell();
		Cell friend1 = mock(Cell.class);
		Cell friend2 = mock(Cell.class);
		cell.addFriend(friend1);
		cell.addFriend(friend2);
		cell.communicate();
		verify(friend1).hi();
		verify(friend2).hi();
	}
	
	
	
	@Test
	public void testSmallWorld() {
		Cell cell1 = Cell.talkativeCell();
		Cell cell2 = Cell.talkativeCell();
	
		cell1.fullyConnect(cell2);

		
	}
	public static class CellRow {
		public Cell[] cells;
		
		public void connectTo(CellRow bottomRow) {
			for (int i = 0; i < cells.length; i++) {
				Cell ourCell = cells[i];
				Cell cellBelowMe= bottomRow.cells[i];
				ourCell.fullyConnect(cellBelowMe);
				if (i < cells.length) {
					Cell cellBelowMeAndToTheRight = bottomRow.cells[i+1];
					ourCell.fullyConnect(cellBelowMeAndToTheRight);
				}
			}
			
		}
	}
}
