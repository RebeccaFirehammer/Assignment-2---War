package gameTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import gameComponents.Card;
import gameComponents.CardRank;
import gameComponents.CardSuit;
import gameComponents.Hand;
import gameComponents.Player;


public class TestCases {
	protected CardRank rank = CardRank.ACE;
	protected CardSuit suit = CardSuit.HEARTS;
	protected Card card;
	protected Stack<Card> cards;
	protected Hand playerHand;
	protected Player player;
	protected String playerName = "Test Name";
	protected int score = 0;
	
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
		cards.push(card);
		
		playerHand = new Hand();
		playerHand.push(card);
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
		Stack<Card> excpectedCards = new Stack<Card>();
		excpectedCards.push(card);
		
		player.addCardToHand(card);
		
		assertEquals(excpectedCards.toString(), player.getPlayerHand().toString());
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
	
	@Test
	public void testPop()
	{
		Card excpectedCard = new Card(rank, suit);
		
		cards.push(card);
		
		assertEquals(excpectedCard.toString(), cards.pop().toString());
		
	}

}
