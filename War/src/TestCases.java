import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class TestCases {
	protected CardRank rank = CardRank.ACE;
	protected CardSuit suit = CardSuit.HEARTS;
	protected Card card;
	protected Player player;
	protected String playerName = "Test Name";
	protected Hand playerHand;
	protected int score = 0;
	protected Stack<Card> cards;
	
	@Before
	public void setUpCard()
	{
		card = new Card(rank, suit);
	}
	
	@Before
	public void setUpPlayer()
	{
		player = new Player(playerName);
	}
	
	@Before
	public void setUpHand()
	{
		cards = new Stack<Card>();
		playerHand = new Hand();
		playerHand.push(card);
		cards.push(card);
	}
	
	@Test
	public void testGetRank()
	{
		assertEquals(rank, card.getRank());
	}
	
	@Test
	public void testGetSuit()
	{
		assertEquals(suit, card.getSuit());
		
	}
	
	@Test
	public void testGetPlayerName()
	{
		assertEquals(playerName, player.getPlayerName());
	}
	
	@Test
	public void testGetPlayerHand()
	{
		player.addCardToHand(card);
		cards.push(card);
		
		assertEquals(cards.toString(), player.getPlayerHand());
	}
	
	@Test
	public void testGetScore()
	{
		player.addPoints(score);
		
		assertEquals(score, player.getScore());
	}
	
	@Test
	public void testAddPoints()
	{
		int expectedScore = 1;
		
		score += 1;
		player.addPoints(score);
		
		assertEquals(expectedScore, player.getScore());
		
	}
	
	@Test
	public void testIsEmpty()
	{
		assertFalse(playerHand.isEmpty());
	}
	
	@Test
	public void testSize()
	{
		assertEquals(cards.size(), playerHand.size());
	}
	
	@Test
	public void testToString()
	{
		assertEquals(cards.toString(), playerHand.toString());
	}

}
