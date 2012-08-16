import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;

public class testCell {
	Cell cell;
	Cell neighbor;

	@Before
	public void setUpNeighbor() {
		neighbor = mock(Cell.class);
	}

	@Test
	public void testNewLivingCell() {
		cell = Cell.talkativeCell();
		cell.addFriend(neighbor);

		verifyCellSaysHi();
	}

	@Test
	public void testDeadCellsDontTalk() {
		cell = Cell.shyCell();
		cell.addFriend(neighbor);

		verifyCellDoestTalk();
	}

	@Test
	public void alive_without_enough_friends_becomes_silenced()
			throws Exception {
		cell = Cell.talkativeCell();
		cell.addFriend(neighbor);
		sayHi(1);
		cell.tick();
		verifyCellDoestTalk();
	}

	@Test
	public void alive_with_two_friends_is_still_talkative() throws Exception {
		cell = Cell.talkativeCell();
		cell.addFriend(neighbor);

		sayHi(2);
		cell.tick();
		verifyCellSaysHi();
	}

	@Test
	public void alive_with_three_friends_is_still_talkative() throws Exception {
		cell = Cell.talkativeCell();
		cell.addFriend(neighbor);

		sayHi(3);
		cell.tick();
		verifyCellSaysHi();
	}

	@Test
	public void alive_with_too_many_friends_becomes_shy() throws Exception {
		cell = Cell.talkativeCell();
		cell.addFriend(neighbor);

		sayHi(4);
		cell.tick();
		verifyCellDoestTalk();
	}
	
	@Test
	public void a_shy_cell_with_3_friends_becomes_talkative() throws Exception {
		cell = Cell.shyCell();
		cell.addFriend(neighbor);
		sayHi(3);
		cell.tick();
		verifyCellSaysHi();
	}

	public void sayHi(int numTimesToSayHi) {
		for (int i = 0; i < numTimesToSayHi; i++) {
			cell.hi();
		}
	}

	public void verifyCellDoestTalk() {
		cell.communicate();
		verifyZeroInteractions(neighbor);
	}

	private void verifyCellSaysHi() {
		cell.communicate();
		verify(neighbor).hi();
	}

}
